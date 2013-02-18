package controllers

import play.api._
import mvc._
import models.Urls._

object Application extends Controller {

  val urls = Urls.urls

  def index = Action {
    Ok(views.html.index(urls))
  }

  def test1 = Action {
    val url = Urls.urls("/test1")
    Redirect(url)
  }


}