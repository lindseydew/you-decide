package controllers

import play.api._
import mvc._
import models.Urls._
import models.Urls.Trail

object Application extends Controller {

  val urls: Map[String, Trail] = Urls.urls

  def index = Action {
    Ok(views.html.index(urls) )
  }

  def test(id: Long) = Action {
    val url : Trail = urls("/test1")
    Redirect(url.getWebUrl)

  }


}