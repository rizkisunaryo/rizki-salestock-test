package controllers

import javax.inject.Inject

import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.libs.json.Json
import play.api.mvc.{ Action, BodyParsers, Call, Controller, Result }

import reactivemongo.bson.{ BSONObjectID, BSONDocument }
import reactivemongo.core.actors.Exceptions.PrimaryUnavailableException
import reactivemongo.api.commands.WriteResult

import play.modules.reactivemongo.{
  MongoController, ReactiveMongoApi, ReactiveMongoComponents
}

class Posts @Inject() (val reactiveMongoApi: ReactiveMongoApi)
    extends Controller with MongoController with ReactiveMongoComponents {

  import controllers.PostFields._

  var idMap:Map[String,Int] = Map()

  def postRepo = new backend.PostMongoRepo(reactiveMongoApi)

  def list = Action.async {implicit request =>
    postRepo.find()
      .map(posts => Ok(Json.toJson(posts.reverse)))
      .recover {case PrimaryUnavailableException => InternalServerError("Please install MongoDB")}
  }

  def findOne(id:String) = Action.async {implicit request =>
    postRepo.findByCriteria(BSONDocument(Id -> id))
      .map(posts => Ok(Json.toJson(posts(0))))
      .recover {case PrimaryUnavailableException => InternalServerError("Please install MongoDB")}
  }

  def like(id: String) = Action.async(BodyParsers.parse.json) { implicit request =>
    val value = (request.body \ Favorite).as[Boolean]
    postRepo.update(BSONDocument(Id -> BSONObjectID(id)), BSONDocument("$set" -> BSONDocument(Favorite -> value)))
      .map(le => Ok(Json.obj("success" -> le.ok)))
  }

  def update(id: String) = Action.async(BodyParsers.parse.json) { implicit request =>
    val value = (request.body \ Text).as[String]
    postRepo.update(BSONDocument(Id -> BSONObjectID(id)), BSONDocument("$set" -> BSONDocument(Text -> value)))
      .map(le => Ok(Json.obj("success" -> le.ok)))
  }

  def delete(id: String) = Action.async {
    postRepo.remove(BSONDocument(Id -> id))
      .map(le => Ok(Json.obj("success" -> le.ok)))
      .recover {case PrimaryUnavailableException => InternalServerError("Please install MongoDB")}
  }

  private def RedirectAfterPost(result: WriteResult, call: Call): Result =
    if (result.inError) InternalServerError(result.toString)
    else Redirect(call)

  def add = Action.async(BodyParsers.parse.json) { implicit request =>
    val username = (request.body \ Username).as[String]
    val text = (request.body \ Text).as[String]
    val avatar = (request.body \ Avatar).as[String]
    val r = scala.util.Random
    var id = Math.abs(r.nextInt).toString
    while(idMap.contains(id)) {
      id = Math.abs(r.nextInt).toString
    }
    idMap += (id -> 1)
    postRepo.save(BSONDocument(
      Text -> text,
      Username -> username,
      Avatar -> avatar,
      Favorite -> false,
      Id -> id
    )).map(le => Ok(Json.obj("success" -> le.ok, "_id" -> id)))
    .recover {case PrimaryUnavailableException => InternalServerError("Please install MongoDB")}
  }
}

object PostFields {
  val Id = "_id"
  val Text = "text"
  val Username = "username"
  val Avatar = "avatar"
  val Favorite = "favorite"
}
