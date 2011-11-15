package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

	def sum(xs: List[Int]) = xs.foldLeft(0){ (a, b) => a + b }
	def sum(xs: List[String]) = xs.foldLeft(""){ (a, b) => a + b }

  def index = Action {
		val xs: List[Int] = (1 to 10).toList
		Ok(sum(xs).toString)
  }

}