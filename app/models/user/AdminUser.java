package models.user;


import play.db.jpa.GenericModel;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by user on 2017/2/28.
 */
@Entity
public class AdminUser extends Model {
    public static String LOGIN_TAG = "admin_tag";

    public String loginName;
    public String loginPassword;

    //创建日期
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    public Date createAt;

    public String telephone;
    public Integer sex;
    public String  nickname;

//    public String url;

}
