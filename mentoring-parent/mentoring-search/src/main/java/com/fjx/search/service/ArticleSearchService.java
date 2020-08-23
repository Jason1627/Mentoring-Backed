package com.fjx.search.service;/*
 * @program: tensquare_parent
 * @Date: 2020-04-27 9:42
 * @Author: Jason
 * @Description:
 */


import com.fjx.search.dao.ArticleSearchDao;
import com.fjx.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import until.IdWorker;

@Service
@Transactional
public class ArticleSearchService {
    @Autowired
    private ArticleSearchDao articleSearchDao;

//    @Autowired
//    private IdWorker idWorker;

    /*
    * @Description: 增加文章
    * @param [article]
    * @Return: void
    * @Author: Jason
    * @Date: 2020-04-27 10:05
    */
    public void add(Article article){
        // article.setId(idWorker.nextId()+"");
        articleSearchDao.save(article);
    }

    public Page<Article> findByKey(String key, int page, int size) {
        Pageable pageable = PageRequest.of(page-1,size);
        return articleSearchDao.findBytitleOrContentLike(key,key,pageable);
    }
}
