package com.fjx.article.dao;


import com.fjx.article.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ArticleDao extends JpaRepository<Article,String>, JpaSpecificationExecutor<Article> {

    /*
    * @Description: 文章审核状态
    * @param [id]
    * @Return: void
    * @Author: Jason
    * @Date: 2020-04-15 21:24
    */
    @Modifying
    @Query(value="UPDATE tb_article set state=1 WHERE id=?",nativeQuery = true)
    public void updateState(String id);

    /*
    * @Description: 点赞数加1
    * @param [id]
    * @Return: void
    * @Author: Jason
    * @Date: 2020-04-15 21:23
    */
    @Modifying
    @Query(value="UPDATE tb_article set thumbup=thumbup+1 WHERE id=? and state=1",nativeQuery = true)
    public void addThumbup(String id);

}
