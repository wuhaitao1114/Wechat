package controllers.auth;

import models.user.AdminUser;
import play.Logger;
import play.cache.Cache;
import play.mvc.Controller;
import utils.ConvertUtil;

/**
 * Created by user on 2017/2/28.
 */
public class Secure extends Controller {
    public final static String CACHE_LOGIN_USER_TAG = "ULC_ADMIN_CACHE_LOGIN_USER_";

    /**
     * 获取当前登录用户
     * @return
     */
    public static AdminUser getLoginUser() {
        long loginUserId = ConvertUtil.toLong(session.get(AdminUser.LOGIN_TAG));
        AdminUser adminUser = Cache.get("lgUser_" + loginUserId,AdminUser.class);
        if(adminUser==null){
            Logger.info("-------->load login user info from database");
            adminUser = AdminUser.findById(loginUserId);
            Cache.set(CACHE_LOGIN_USER_TAG + loginUserId,adminUser,"30mn");
        }
        return  adminUser;
    }

//    /**
//     * baseModel对象基本信息设置
//     * @param baseModel
//     */
//    public static BaseModel setBaseInfo(BaseModel baseModel){
//        AdminUser loginUser = getLoginUser();
//        if(baseModel.id ==null){
//            baseModel.createAt = new Date();
//            baseModel.creator = loginUser;
//            baseModel.ctDept = loginUser.adminDept;
//        }else{
//            baseModel.modifyAt = new Date();
//            baseModel.modifier = loginUser;
//        }
//        return baseModel;
//    }

    /**
     * 获取当前登录用户ID
     * @return
     */
    public static long getLoginUserId(){
        return ConvertUtil.toLong(session.get(AdminUser.LOGIN_TAG));
    }

//    @Before()
//    public static void filter() throws Throwable {
//        Logger.info("[AdminSecure]: Filter for URL -> " + request.url);
//        if (skipLoginCheck()) {
//            Logger.info("[Secure]: Skip login check");
//            return;
//        }
//        long loginUserId = getLoginUserId();
//
//        if(loginUserId==0){
//            redirect("/login");
//        }else{
//            if(!skipAuthCheck()){
//                String ctrlUrl = ConvertUtil.spliteUrlCtrl(request.url);
//                String actionMethod = request.actionMethod;
//                //为了方便目前先用数据库验证,之后有性能问题考虑用户登录时权限全部加载到缓存,在程序中校验
////                if(!AdminRoleOperate.isSecure(loginUserId,ctrlUrl,actionMethod)){
////                    redirect("/basic/LoginCtrl/nopriv");
////                }
//            }
//        }
//
//    }


//    private static boolean skipLoginCheck() {
//        if (getActionAnnotation(SkipLoginCheck.class) != null ||
//                getControllerInheritedAnnotation(SkipLoginCheck.class) != null) {
//            Logger.info("SkipLoginCheck=true");
//            return true;
//        }
//        Logger.info("SkipLoginCheck=false");
//        return false;
//    }
//
//    private static boolean skipAuthCheck() {
//        if (getActionAnnotation(SkipAuth.class) != null ||
//                getControllerInheritedAnnotation(SkipAuth.class) != null) {
//            Logger.info("SkipAuth=true");
//            return true;
//        }
//        Logger.info("SkipAuth=false");
//        return false;
//    }
}
