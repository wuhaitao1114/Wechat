package controllers;

import play.mvc.Controller;

/**
 * Created by user on 2017/2/28.
 */
public class HomeCtrl extends Controller {

    public static void home() {

//        AdminUser adminUser = Secure.getLoginUser();
//        if(adminUser == null)
//            LoginCtrl.login();
//        String loginName = adminUser.loginName;
//        String loginPassword = adminUser.loginPassword;
//
//        render(loginName,loginPassword);
        render();

    }

    public static void leftcontent(){
        render();
    }

    public static void rightcontent_1(){
        render();
    }

    public static void rightcontent_2(){
        render();
    }

    public static void rightcontent_3(){
        render();
    }

}