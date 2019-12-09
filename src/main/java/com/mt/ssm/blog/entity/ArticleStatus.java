package com.mt.ssm.blog.entity;

/**
 * @auther MT
 * @create 2019-09-05 22:04
 */
public enum ArticleStatus {

    PUBLISH(1,"已发布"),
    DRAFT(0,"草稿");

    private Integer value;

    private String message;

    ArticleStatus(Integer value, String message) {
        this.value = value;
        this.message = message;
    }
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
