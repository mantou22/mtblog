package com.mt.ssm.blog.service.impl;

import com.mt.ssm.blog.entity.Article;
import com.mt.ssm.blog.mapper.ArticleMapper;
import com.mt.ssm.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther MT
 * @create 2019-09-02 16:52
 */

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired(required = false)
    private ArticleMapper articleMapper;

    @Override
    public Integer countArticleByUser(Integer id) {
        return articleMapper.countArticleByUser(id);
    }

    @Override
    public List<Article> listRecentArticle(Integer limit) {
        return articleMapper.listRecentArticle(limit);
    }

    @Override
    public Article getArticleByStatusAndId(Integer status, Integer id) {
        return articleMapper.getArticleByStatusAndId(status,id);
    }

    @Override
    public void updateCommentCount(Integer articleId) {
        articleMapper.updateCommentCount(articleId);
    }

    @Override
    public void updateArticle(Article article) {
        articleMapper.updateArticle(article);
    }
}
