package com.hcq.spring.controller;


import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.hcq.spring.domain.Auctionuser;
import com.hcq.spring.domain.Result;
import com.hcq.spring.service_impl.Userimpl;
import com.hcq.spring.utils.Myutils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

@Controller
public class UserController {

    @Autowired
    Userimpl userimpl;

    @GetMapping("{url}.html")
    public String login(@PathVariable String url) {
        return url;
    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request,Model model) {
        String errorExeption = (String) request.getAttribute("shiroLoginFailure");
        if (errorExeption != null) {
            System.out.println(errorExeption);
            if (UnknownAccountException.class.getName().equals(errorExeption)) {
                model.addAttribute("errorMsg", "账号错误");
            }
            if (IncorrectCredentialsException.class.getName().equals(errorExeption)) {
                model.addAttribute("errorMsg", "密码错误");

            }
            if ("valideCodeError".equals(errorExeption)) {
                model.addAttribute("errorMsg", "验证码错误");
            }

        }
        return "login";

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model,
                           @ModelAttribute("registerUser") @Validated Auctionuser auctionuser, BindingResult bing) {
        if (bing.hasErrors()) {
            bing.getFieldErrors().forEach(e ->
                    model.addAttribute(e.getField(), e.getDefaultMessage()));
            return "register";
        }
        userimpl.UserRegistered(auctionuser);
        return "login";
    }

    @RequestMapping("/doLoginout")
    public String doLoginout(HttpSession session) {
        session.removeAttribute("user");
        return "login";
    }

    @RequestMapping("/checkUserExist")
    @ResponseBody
    public Result checkUserExist(String username) {
        Myutils.printlnLog(username);
        System.out.println(username);
        boolean exist = userimpl.isExist(username);
        Result result = new Result();
        if (exist) {
            result.setMessage("用户名被占用");
        } else {
            result.setMessage("用户名可用");
        }
        return result;
    }

    @Autowired
    private DefaultKaptcha captchaProducer;

    /**
     * 获取验证码
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws Exception
     */
    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws Exception {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            // 生产验证码字符串并保存到session中
            String createText = captchaProducer.createText();
            httpServletRequest.getSession().setAttribute("vrifyCode", createText);
            // 使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = captchaProducer.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }
}
