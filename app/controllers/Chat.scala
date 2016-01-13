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

class Chats @Inject() (val reactiveMongoApi: ReactiveMongoApi)
    extends Controller with MongoController with ReactiveMongoComponents {

  import controllers.ChatFields._

  var idMap:Map[String,Int] = Map()

  def chatRepo = new backend.ChatMongoRepo(reactiveMongoApi)

  def list = Action.async {implicit request =>
    chatRepo.find()
      .map(chats => Ok(Json.toJson(chats.reverse)))
      .recover {case PrimaryUnavailableException => InternalServerError("Please install MongoDB")}
  }

  def findById(id:String) = Action.async {implicit request =>
    chatRepo.findByCriteria(BSONDocument(Id -> id))
      .map(chats => Ok(Json.toJson(chats(0))))
      .recover {case PrimaryUnavailableException => InternalServerError("Please install MongoDB")}
  }

  def findByUser(user:String) = Action.async {implicit request =>
    chatRepo.findByCriteria(BSONDocument(User -> user))
      .map(chats => Ok(Json.toJson(chats.reverse)))
      .recover {case PrimaryUnavailableException => InternalServerError("Please install MongoDB")}
  }

  def update(id: String) = Action.async(BodyParsers.parse.json) { implicit request =>
    val value = (request.body \ Text).as[String]
    chatRepo.update(BSONDocument(Id -> id), BSONDocument("$set" -> BSONDocument(Text -> value)))
      .map(le => Ok(Json.obj("success" -> le.ok)))
  }

  def delete(id: String) = Action.async {
    chatRepo.remove(BSONDocument(Id -> id))
      .map(le => Ok(Json.obj("success" -> le.ok)))
      .recover {case PrimaryUnavailableException => InternalServerError("Please install MongoDB")}
  }

  private def RedirectAfterChat(result: WriteResult, call: Call): Result =
    if (result.inError) InternalServerError(result.toString)
    else Redirect(call)

  def add = Action.async(BodyParsers.parse.json) { implicit request =>
    val user = (request.body \ User).as[String]
    val text = (request.body \ Text).as[String]
    val r = scala.util.Random
    var id = Math.abs(r.nextInt).toString
    while(idMap.contains(id)) {
      id = Math.abs(r.nextInt).toString
    }
    idMap += (id -> 1)
    chatRepo.save(BSONDocument(
      User -> user,
      Text -> text,
      Id -> id
    )).map(le => Ok(Json.obj("success" -> le.ok, "_id" -> id)))
    .recover {case PrimaryUnavailableException => InternalServerError("Please install MongoDB")}
  }
}

object ChatFields {
  val Id = "_id"
  val User = "user"
  val Text = "text"
}
