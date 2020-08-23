package com.fjx.search.dao;/*
 * @program: tensquare_parent
 * @Date: 2020-04-27 9:41
 * @Author: Jason
 * @Description:
 */


import com.fjx.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleSearchDao extends ElasticsearchRepository<Article,String> {
   Page<Article> findBytitleOrContentLike(String title, String content, Pageable pageable);
}
