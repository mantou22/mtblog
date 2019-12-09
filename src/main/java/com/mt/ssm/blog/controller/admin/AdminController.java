package com.mt.ssm.blog.controller.admin;

import com.mt.ssm.blog.entity.Article;
import com.mt.ssm.blog.entity.Comment;
import com.mt.ssm.blog.entity.User;
import com.mt.ssm.blog.service.ArticleService;
import com.mt.ssm.blog.service.CommentService;
import com.mt.ssm.blog.service.UserService;
import com.mt.ssm.blog.util.MyUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther MT
 * @create 2019-09-02 15:50
 */
@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;
    /**
     * 后台首页
     *
     * @return
     */
    @RequestMapping("/admin")
    public String index(Model model)  {
        //文章列表
        List<Article> articleList = articleService.listRecentArticle(5);
        model.addAttribute("articleList",articleList);

        //评论列表
        List<Comment> commentList = commentService.listRecentComment(5);
        model.addAttribute("commentList",commentList);

        return "Admin/index";
    }

    /**
     * 登录页面显示
     *
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "Admin/login";
    }


    @RequestMapping("")
    public String index(){
        return "Admin/login";
    }


    /**
     * 退出登录
     *
     * @return
     */
    @RequestMapping(value = "/admin/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:/login";
    }


    @RequestMapping(value = "/loginVerify", method = RequestMethod.POST)
    @ResponseBody
    public String loginVerify(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> map = new HashMap<>();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberme = request.getParameter("rememberme");
        User user = userService.getUserByName(username);
        if(user == null){
            map.put("code",0);
            map.put("msg","用户名无效！");
        }else if (!user.getUserPass().equals(password)){
            map.put("code",0);
            map.put("msg","密码错误！");
        }else{ //登录成功
            map.put("code",1);
            map.put("msg","");

            //添加session
            request.getSession().setAttribute("user",user);
            if(rememberme !=null){ //创建cookie
                Cookie nameCookie = new Cookie("username", username);
                Cookie pwdCookie = new Cookie("password", password);
                //设置Cookie的有效期为3天
                nameCookie.setMaxAge(60 * 60 * 24 * 7);
                pwdCookie.setMaxAge(60 * 60 * 24 * 7);
                response.addCookie(nameCookie);
                response.addCookie(pwdCookie);
            }
            user.setUserLastLoginTime(new Date());
            user.setUserLastLoginIp(MyUtils.getIpAddr(request));
            userService.update(user);

        }
        String res= new JSONObject(map).toString();
        return res;
    }




}
