package com.mt.ssm.blog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @auther MT
 * @create 2019-09-02 15:37
 * 文章分类关联表
 */
@Data
public class ArticleCategoryRef implements Serializable {
    private static final long serialVersionUID = -6809206515467725995L;

    private Integer articleId;

    private Integer categoryId;

    public ArticleCategoryRef() {
    }

    public ArticleCategoryRef(Integer articleId, Integer categoryId) {
        this.articleId = articleId;
        this.categoryId = categoryId;
    }
}
