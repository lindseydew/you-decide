package controllers

import play.api._
import mvc._
import models.Urls._
import models.Urls.Trail
import models.Urls.ClickCount
import play.api.db.DB
import play.api.Play.current
import anorm._
import anorm.SqlParser._
import scala.util.Random


object Application extends Controller {

  val urls: Map[Long, Trail] = Urls.urls
  val experimentRunning: Boolean = false

  def index = Action {
    if(experimentRunning) {
      val trails = displayRandomTrailBlocks
      Ok(views.html.index(trails) )
    }
    else {
      Ok(views.html.index(urls) )
    }
  }

  def test(id: Long) = Action {
    val url : Trail = urls(id)
    updateClickRate(id)
    Redirect(url.getWebUrl)

  }

  def displayRandomTrailBlocks: Map[Long, Trail] = {
    Random.shuffle(urls).take(5).toMap
  }


  def showClicks = Action {
      val clicks: List[ClickCount] = currentNumberOfClicks
      Ok(views.html.clicks(clicks))
  }

  def updateClickRate(id: Long) = {
    DB.withConnection { implicit c =>
      SQL("UPDATE click_rate SET no_of_clicks = no_of_clicks + 1 WHERE id={id}").on(
        'id -> id
      ).executeUpdate()
    }
  }

  val click_rate = {
    get[Long]("id") ~
      get[Long]("no_of_clicks") map {
      case id~no_of_clicks => ClickCount(id, no_of_clicks)
    }
  }

  def currentNumberOfClicks = {
     DB.withConnection { implicit c =>
      SQL("SELECT id, no_of_clicks FROM click_rate").as(click_rate *)
    }
  }


  def topNumberOfClicks = {
    DB.withConnection { implicit c =>
      SQL("SELECT id, no_of_clicks FROM click_rate order by no_of_clicks limit 5").as(click_rate *)
    }
  }

  def startExperiment = Action {
    DB.withConnection { implicit c =>
      SQL("UPDATE click_rate SET no_of_clicks = 0").executeUpdate()
    }
    DB.withConnection { implicit c =>
      SQL("UPDATE experiment SET started = true").executeUpdate()
    }
    Redirect("/admin")
  }

  def stopExperiment = Action {
    DB.withConnection { implicit c =>
      SQL("UPDATE experiment SET started = false").executeUpdate()
    }
    Redirect("/results")
  }


  def results = Action {
    Ok(views.html.admin_results())
  }


  def admin = Action {
    val row = DB.withConnection { implicit c =>
      SQL("SELECT started FROM experiment").asSimple.single()
    }
    Ok(views.html.admin_entry(row.get[Boolean]("started").get))
  }
}



