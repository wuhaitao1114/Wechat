package models.article;


import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "article")
public class Article extends Model {

    @Required
    public String articleId;

    public String title;
    //创建日期
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    public Date createAt;

    public String url;
    //图片
    public List<String> img_urls;

    public String author;

    public String contents;
    //标签
    public List<String> tags;
    //
    public String articleType;
    //
    public String articleTypeStr;

    public String articleSubType;

    public String articleSubTypeStr;

    public boolean isHot;


    public List<Article> getArticleByArticleType(String articleType){
        List<Article> articleList=null;
        //sql语句
        String sql = "select * from article where articleType=articleType order by id desc;";
        //创建sql查询
        Query query = Model.em().createNativeQuery(sql,Article.class);
        // 查询结果返回至实体对象Article
        articleList = query.getResultList();
        //分页
//        ValuePaginator paginator = new ValuePaginator(questions);
//        paginator.setPageSize(20);
//        paginator.setPageNumber(1);


        return articleList;
    }




}
