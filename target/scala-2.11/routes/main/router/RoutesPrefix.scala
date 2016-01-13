
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/rizki/scala/rizki-salestock-test/conf/routes
// @DATE:Wed Jan 13 23:31:35 WIB 2016


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
