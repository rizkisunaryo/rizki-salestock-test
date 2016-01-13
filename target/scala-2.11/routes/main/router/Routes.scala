
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/rizki/scala/rizki-salestock-test/conf/routes
// @DATE:Wed Jan 13 18:00:36 WIB 2016

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  Assets_0: controllers.Assets,
  // @LINE:8
  Posts_1: controllers.Posts,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Assets_0: controllers.Assets,
    // @LINE:8
    Posts_1: controllers.Posts
  ) = this(errorHandler, Assets_0, Posts_1, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Assets_0, Posts_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Assets.at(path:String = "/public", file:String = "app/index.html")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/posts""", """controllers.Posts.list"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/post/$id<[^/]+>""", """controllers.Posts.findOne(id:String)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/post/$id<[^/]+>/like""", """controllers.Posts.like(id:String)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/post/$id<[^/]+>""", """controllers.Posts.update(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/post""", """controllers.Posts.add"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/post/$id<[^/]+>""", """controllers.Posts.delete(id:String)"""),
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
    Assets_0.at(fakeValue[String], fakeValue[String]),
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
  private[this] lazy val controllers_Posts_list1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/posts")))
  )
  private[this] lazy val controllers_Posts_list1_invoker = createInvoker(
    Posts_1.list,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Posts",
      "list",
      Nil,
      "GET",
      """""",
      this.prefix + """api/posts"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Posts_findOne2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/post/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Posts_findOne2_invoker = createInvoker(
    Posts_1.findOne(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Posts",
      "findOne",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """api/post/$id<[^/]+>"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_Posts_like3_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/post/"), DynamicPart("id", """[^/]+""",true), StaticPart("/like")))
  )
  private[this] lazy val controllers_Posts_like3_invoker = createInvoker(
    Posts_1.like(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Posts",
      "like",
      Seq(classOf[String]),
      "PATCH",
      """""",
      this.prefix + """api/post/$id<[^/]+>/like"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_Posts_update4_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/post/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Posts_update4_invoker = createInvoker(
    Posts_1.update(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Posts",
      "update",
      Seq(classOf[String]),
      "PATCH",
      """""",
      this.prefix + """api/post/$id<[^/]+>"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Posts_add5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/post")))
  )
  private[this] lazy val controllers_Posts_add5_invoker = createInvoker(
    Posts_1.add,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Posts",
      "add",
      Nil,
      "POST",
      """""",
      this.prefix + """api/post"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_Posts_delete6_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/post/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Posts_delete6_invoker = createInvoker(
    Posts_1.delete(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Posts",
      "delete",
      Seq(classOf[String]),
      "DELETE",
      """""",
      this.prefix + """api/post/$id<[^/]+>"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_Assets_at7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at7_invoker = createInvoker(
    Assets_0.at(fakeValue[String], fakeValue[String]),
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
        controllers_Assets_at0_invoker.call(Assets_0.at(path, file))
      }
  
    // @LINE:8
    case controllers_Posts_list1_route(params) =>
      call { 
        controllers_Posts_list1_invoker.call(Posts_1.list)
      }
  
    // @LINE:9
    case controllers_Posts_findOne2_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_Posts_findOne2_invoker.call(Posts_1.findOne(id))
      }
  
    // @LINE:10
    case controllers_Posts_like3_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_Posts_like3_invoker.call(Posts_1.like(id))
      }
  
    // @LINE:11
    case controllers_Posts_update4_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_Posts_update4_invoker.call(Posts_1.update(id))
      }
  
    // @LINE:12
    case controllers_Posts_add5_route(params) =>
      call { 
        controllers_Posts_add5_invoker.call(Posts_1.add)
      }
  
    // @LINE:13
    case controllers_Posts_delete6_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_Posts_delete6_invoker.call(Posts_1.delete(id))
      }
  
    // @LINE:15
    case controllers_Assets_at7_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at7_invoker.call(Assets_0.at(path, file))
      }
  }
}