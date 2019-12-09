package com.mt.ssm.blog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @auther MT
 * @create 2019-09-02 15:41
 */
@Data
public class Menu implements Serializable {
    private static final long serialVersionUID = 489914127235951698L;
    private Integer menuId;

    private String menuName;

    private String menuUrl;

    private Integer menuLevel;

    private String menuIcon;

    private Integer menuOrder;

}