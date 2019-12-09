package com.mt.ssm.blog.service;

import com.mt.ssm.blog.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @auther MT
 * @create 2019-09-02 16:52
 */

public interface ArticleService {



    /**
     * 用户的文章数
     *
     * @param id 用户ID
     * @return 数量
     */
    Integer countArticleByUser(Integer id);

    List<Article> listRecentArticle(Integer limit);

    /**
     * 根据id查询用户信息
     *
     * @param status 状态
     * @param id 文章ID
     * @return 文章
     */
    Article getArticleByStatusAndId(@Param(value = "status") Integer status, @Param(value = "id") Integer id);


    void updateCommentCount(Integer articleId);

    void updateArticle(Article article);




}
