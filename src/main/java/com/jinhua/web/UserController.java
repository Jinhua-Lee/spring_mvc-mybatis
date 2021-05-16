package com.jinhua.web;

import com.jinhua.domain.PageBean;
import com.jinhua.domain.User;
import com.jinhua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jinhua
 */
@Controller
public class UserController {

    /**
     * 用户业务
     */
    private UserService us;

    @Autowired
    @Qualifier("userService")
    public void setUs(UserService us) {
        this.us = us;
    }

    /**
     * 登录功能
     *
     * @param request Http请求
     * @param user    页面传入实体
     * @return 返回登录结果页面
     */
    @RequestMapping(value = "/login.action")
    public String login(HttpServletRequest request, @ModelAttribute User user) {
        Map<String, String> loginErrors = new HashMap<>();
        System.out.println(user);

        if (user.getName() == null || user.getName().trim().isEmpty()) {
            loginErrors.put("nameError", "用户名不能为空！");
            request.setAttribute("loginErrors", loginErrors);
            return "login.jsp";
        }

        if (user.getPwd() == null || user.getPwd().trim().isEmpty()) {
            loginErrors.put("pwdError", "密码不能为空！");
            request.setAttribute("loginErrors", loginErrors);
            return "login.jsp";
        }

        if (us.login(user)) {
            request.getSession().setAttribute("SessionUser", user);
            request.setAttribute("msg", "欢迎用户 " + user.getName());
            return "success.jsp";
        } else {
            return "login.jsp";
        }
    }


    /**
     * 注册功能
     *
     * @param request Http请求
     * @param user    页面传入参数
     * @return 返回注册结果页面
     */
    @RequestMapping(value = "/register.action")
    public String register(HttpServletRequest request, @ModelAttribute User user) {
        Map<String, String> registerErrors = new HashMap<>();

        if (user.getName().length() < 3 || user.getName().length() > 14) {
            registerErrors.put("nameError", "用户名长度应该在3位到14位之间！");

            if (user.getPwd().length() < 6 || user.getPwd().length() > 18) {
                registerErrors.put("pwdError", "用户密码长度应该在6位到18位之间！");
            }

            String pwdConfig = (String) request.getAttribute("pwdConfig");
            if (pwdConfig != null && !pwdConfig.equals(user.getPwd())) {
                registerErrors.put("pwdconfigError", "输入密码不一致！");
            }
            request.setAttribute("registerErors", registerErrors);
            return "register.jsp";
        }
        if (us.register(user)) {
            return "login.jsp";
        } else {
            return "register.jsp";
        }
    }

    /**
     * 删除用户
     *
     * @param request Http请求
     * @param user    传入用户实体
     * @return 返回删除结果
     */
    @RequestMapping(value = "/delete.action")
    public String delete(HttpServletRequest request, @ModelAttribute User user) {
        boolean delete = us.delete(user);
        if (delete) {
            return "forward:/showall.action";
        } else {
            return "error.jsp";
        }
    }

    /**
     * 显示所有用户信息
     *
     * @param model 向页面传数据
     * @return 返回显示页面
     */
    @RequestMapping(value = "/showall.action")
    public String showall(Model model) {
        List<User> userList = us.getUserAll();
        model.addAttribute("userList", userList);
        return "showAll.jsp";
    }

    @RequestMapping(value = "/update.action")
    public String update(HttpServletRequest request, HttpServletResponse response, @ModelAttribute User user)
            throws ServletException, IOException {
        boolean update = us.update(user);
        if (update) {
            return "forward:/showall.action";
        } else {
            return "error.jsp";
        }
    }


    /**
     * 获取分页参数
     *
     * @param req       Http请求
     * @param pageParam 页面参数字符串
     * @return 返回分页的属性
     */
    private int getPageParameter(HttpServletRequest req, String pageParam) {
        String ppm = req.getParameter(pageParam);
        System.out.println(pageParam + "----->" + ppm);
        if (ppm == null || ppm.trim().isEmpty()) {
            return 1;
        } else {
            int param = Integer.parseInt(ppm);
            if (param < 1) {
                return 1;
            }
        }
        return Integer.parseInt(ppm);
    }

    @RequestMapping(value = "/query.action")
    public String query(HttpServletRequest request, Model model, @ModelAttribute User criteria) {
        int pc = getPageParameter(request, "pageBean.pageCurrent");
        int ps = getPageParameter(request, "pageBean.pageSize");

        System.out.println("传入的实体" + criteria);

        PageBean<User> pageBean = us.getUserByPage(pc, ps, criteria);

        model.addAttribute("pageBean", pageBean);

        request.setAttribute("criteria", criteria);

        return "query.jsp";
    }
}
