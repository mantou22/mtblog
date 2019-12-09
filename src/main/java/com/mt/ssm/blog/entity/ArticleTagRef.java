package com.mt.ssm.blog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @auther MT
 * @create 2019-09-02 15:39
 * 文章和标签关联
 */
@Data
public class ArticleTagRef implements Serializable {
    private static final long serialVersionUID = -5816783232020910492L;

    private Integer articleId;

    private Integer tagId;

    public ArticleTagRef() {
    }

    public ArticleTagRef(Integer articleId, Integer tagId) {
        this.articleId = articleId;
        this.tagId = tagId;
    }
}