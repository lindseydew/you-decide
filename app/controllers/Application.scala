package controllers

import play.api._
import mvc._
import models.Urls._
import models.Urls.Trail
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
    val clicks = currentNumberOfClick(id)
    Redirect(url.getWebUrl)

  }

  def updateClickRate(id: Long) = {
    DB.withConnection { implicit c =>
      SQL("UPDATE click_rate SET no_of_clicks = no_of_clicks + 1 WHERE id={id}").on(
        'id -> id
      ).executeUpdate()
    }
  }

  def currentNumberOfClick(id: Long): Int = {
    DB.withConnection { implicit c =>
      SQL("SELECT no_of_clicks FROM click_rate WHERE id={id}").on(
        'id -> id
      )
    }.execute()


  }
}