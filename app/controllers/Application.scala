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


object Application extends Controller {

  val urls: Map[String, Trail] = Urls.urls

  def index = Action {
    Ok(views.html.index(urls) )
  }

  def test(id: Long) = Action {
    val url : Trail = urls("/test/%d".format(id))
    updateClickRate(id)
    Redirect(url.getWebUrl)

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

}