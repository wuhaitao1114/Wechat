package controllers;

import models.user.AdminUser;
import play.Logger;
import play.mvc.Controller;

import java.util.Date;

public class LoginCtrl extends Controller {

    private static final String TAG = "LoginCtrl";

    public static void login() {
        render();
    }

    public static void loginAction(String loginName,String loginPassword){
        Logger.info(loginName,loginPassword);
        Logger.info(loginName,loginPassword);

//        AdminUser adminUser = AdminUser.find("loginName=? and loginPassword=? ",loginName,ConvertUtil.toMD5(loginPassword)).first();
        AdminUser adminUser = AdminUser.find("loginName=? and loginPassword=? ",loginName,loginPassword).first();

        if(adminUser==null){
            Logger.info(TAG+":000",adminUser);
            flash.put("error", "用户或密码错误!");
            redirect("/login");
        }else{
            Logger.info(TAG+":111","right");
            flash.put("chenggong", "登陆成功!");
            session.put(AdminUser.LOGIN_TAG,adminUser.id);
            redirect("/");
        }

    }

    public static void register() {
        render();
    }

    public static void registerAction(String loginName,String loginPassword){


        AdminUser adminUser = new AdminUser();
        adminUser.loginName=loginName;
//        adminUser.loginPassword=ConvertUtil.toMD5(loginPassword);
        adminUser.loginPassword=loginPassword;
        adminUser.createAt = new Date();
        adminUser.save();

        login();
    }
}