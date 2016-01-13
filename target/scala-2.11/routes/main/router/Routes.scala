
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/rizki/scala/rizki-salestock-test/conf/routes
// @DATE:Wed Jan 13 23:31:35 WIB 2016

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  Assets_1: controllers.Assets,
  // @LINE:8
  Chats_0: controllers.Chats,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Assets_1: controllers.Assets,
    // @LINE:8
    Chats_0: controllers.Chats
  ) = this(errorHandler, Assets_1, Chats_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Assets_1, Chats_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Assets.at(path:String = "/public", file:String = "app/index.html")"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/chat""", """controllers.Chats.add"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/chat/$id<[^/]+>""", """controllers.Chats.update(id:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/chat/$id<[^/]+>""", """controllers.Chats.delete(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/chat/$id<[^/]+>""", """controllers.Chats.findById(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/chat/user/$user<[^/]+>""", """controllers.Chats.findByUser(user:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/chats""", """controllers.Chats.list"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """$file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_Assets_at0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Assets_at0_invoker = createInvoker(
    Assets_1.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """ Home page""",
      this.prefix + """"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_Chats_add1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/chat")))
  )
  private[this] lazy val controllers_Chats_add1_invoker = createInvoker(
    Chats_0.add,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Chats",
      "add",
      Nil,
      "POST",
      """""",
      this.prefix + """api/chat"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Chats_update2_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/chat/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Chats_update2_invoker = createInvoker(
    Chats_0.update(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Chats",
      "update",
      Seq(classOf[String]),
      "PUT",
      """""",
      this.prefix + """api/chat/$id<[^/]+>"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_Chats_delete3_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/chat/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Chats_delete3_invoker = createInvoker(
    Chats_0.delete(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Chats",
      "delete",
      Seq(classOf[String]),
      "DELETE",
      """""",
      this.prefix + """api/chat/$id<[^/]+>"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_Chats_findById4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/chat/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Chats_findById4_invoker = createInvoker(
    Chats_0.findById(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Chats",
      "findById",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """api/chat/$id<[^/]+>"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Chats_findByUser5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/chat/user/"), DynamicPart("user", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Chats_findByUser5_invoker = createInvoker(
    Chats_0.findByUser(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Chats",
      "findByUser",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """api/chat/user/$user<[^/]+>"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_Chats_list6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/chats")))
  )
  private[this] lazy val controllers_Chats_list6_invoker = createInvoker(
    Chats_0.list,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Chats",
      "list",
      Nil,
      "GET",
      """""",
      this.prefix + """api/chats"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_Assets_at7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at7_invoker = createInvoker(
    Assets_1.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """$file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Assets_at0_route(params) =>
      call(Param[String]("path", Right("/public")), Param[String]("file", Right("app/index.html"))) { (path, file) =>
        controllers_Assets_at0_invoker.call(Assets_1.at(path, file))
      }
  
    // @LINE:8
    case controllers_Chats_add1_route(params) =>
      call { 
        controllers_Chats_add1_invoker.call(Chats_0.add)
      }
  
    // @LINE:9
    case controllers_Chats_update2_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_Chats_update2_invoker.call(Chats_0.update(id))
      }
  
    // @LINE:10
    case controllers_Chats_delete3_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_Chats_delete3_invoker.call(Chats_0.delete(id))
      }
  
    // @LINE:11
    case controllers_Chats_findById4_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_Chats_findById4_invoker.call(Chats_0.findById(id))
      }
  
    // @LINE:12
    case controllers_Chats_findByUser5_route(params) =>
      call(params.fromPath[String]("user", None)) { (user) =>
        controllers_Chats_findByUser5_invoker.call(Chats_0.findByUser(user))
      }
  
    // @LINE:13
    case controllers_Chats_list6_route(params) =>
      call { 
        controllers_Chats_list6_invoker.call(Chats_0.list)
      }
  
    // @LINE:15
    case controllers_Assets_at7_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at7_invoker.call(Assets_1.at(path, file))
      }
  }
}