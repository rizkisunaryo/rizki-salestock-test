
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/rizki/scala/rizki-salestock-test/conf/routes
// @DATE:Wed Jan 13 14:12:13 WIB 2016

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def at(file:String): Call = {
    
      (file: @unchecked) match {
      
        // @LINE:6
        case (file) if file == "app/index.html" =>
          implicit val _rrc = new ReverseRouteContext(Map(("path", "/public"), ("file", "app/index.html")))
          Call("GET", _prefix)
      
        // @LINE:14
        case (file)  =>
          implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
          Call("GET", _prefix + { _defaultPrefix } + implicitly[PathBindable[String]].unbind("file", file))
      
      }
    
    }
  
  }

  // @LINE:8
  class ReversePosts(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def like(id:String): Call = {
      import ReverseRouteContext.empty
      Call("PATCH", _prefix + { _defaultPrefix } + "api/post/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + "/like")
    }
  
    // @LINE:11
    def add(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "api/post")
    }
  
    // @LINE:8
    def list(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/posts")
    }
  
    // @LINE:12
    def delete(id:String): Call = {
      import ReverseRouteContext.empty
      Call("DELETE", _prefix + { _defaultPrefix } + "api/post/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
    }
  
    // @LINE:10
    def update(id:String): Call = {
      import ReverseRouteContext.empty
      Call("PATCH", _prefix + { _defaultPrefix } + "api/post/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
    }
  
  }


}