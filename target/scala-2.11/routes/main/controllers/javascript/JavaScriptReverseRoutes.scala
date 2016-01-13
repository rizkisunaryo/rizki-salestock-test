
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/rizki/scala/rizki-salestock-test/conf/routes
// @DATE:Wed Jan 13 23:31:35 WIB 2016

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:8
  class ReverseChats(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def findById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Chats.findById",
      """
        function(id) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/chat/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
        }
      """
    )
  
    // @LINE:8
    def add: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Chats.add",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/chat"})
        }
      """
    )
  
    // @LINE:13
    def list: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Chats.list",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/chats"})
        }
      """
    )
  
    // @LINE:10
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Chats.delete",
      """
        function(id) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/chat/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
        }
      """
    )
  
    // @LINE:9
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Chats.update",
      """
        function(id) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/chat/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
        }
      """
    )
  
    // @LINE:12
    def findByUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Chats.findByUser",
      """
        function(user) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/chat/user/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("user", encodeURIComponent(user))})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file) {
        
          if (file == """ + implicitly[JavascriptLiteral[String]].to("app/index.html") + """) {
            return _wA({method:"GET", url:"""" + _prefix + """"})
          }
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
          }
        
        }
      """
    )
  
  }


}