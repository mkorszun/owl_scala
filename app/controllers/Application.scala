package controllers

import play.api.mvc._
import com.stackmob.newman._
import com.stackmob.newman.dsl._
import scala.concurrent._
import scala.concurrent.duration._
import java.net.URL

object Application extends Controller {

  def index = Action {
    implicit val httpClient = new ApacheHttpClient()
    val url = new URL("https://api.cloudcontrol.com/.meta/version")
    val response = Await.result(GET(url).apply, 5.second).bodyString
    Ok(views.html.index(response.toString))
  }

}