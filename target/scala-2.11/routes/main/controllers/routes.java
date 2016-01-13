
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/rizki/scala/rizki-salestock-test/conf/routes
// @DATE:Wed Jan 13 23:31:35 WIB 2016

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseChats Chats = new controllers.ReverseChats(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseChats Chats = new controllers.javascript.ReverseChats(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}
