package com.jyj019.controller;

import java.awt.image.BufferedImage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.jyj019.dto.UserRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jyj019.domain.User;
import com.jyj019.dto.CheckResult;
import com.jyj019.dto.UserLoginDto;
import com.jyj019.service.UserService;
import com.jyj019.util.CommonUtil;
/**
 *
 *@Author jyj019
 **/
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/login")
	//@RequestParam(name="username",defaultValue="1")string uid
	public String doLogin(@Valid UserLoginDto user,Errors errors,
			HttpServletRequest request,Model model) {
		String viewName = "login";
		String codeFromServer = (String) request.getSession().getAttribute("code");
		//System.out.println(user.getCode()+codeFromServer);
		if (codeFromServer.equalsIgnoreCase(user.getCode())) {
			if (!errors.hasErrors()) {
				user.setIpAddress(request.getRemoteAddr());
				if (userService.login(user)) {
					request.getSession().setAttribute("userId", user.getId());
					request.getSession().setAttribute("userRealname", user.getRealname());
					viewName = "redirect:home";
				} else {
					model.addAttribute("hint", "用户名或密码错误");
				}
			} else {
				model.addAttribute("hint", "请输入有效的登录信息");
			}
		} else {
			model.addAttribute("hint", "请输入正确的验证码");
		}
		return viewName;
	}


	@PostMapping("/register")
	public String doReg(@Valid UserRegisterDto user, Model model, Errors errors,
						HttpServletRequest request) {
		String viewName = "register";
		String codeFromServer = (String) request.getSession().getAttribute("code");
		//System.out.println(user.getCode()+codeFromServer);
		if (codeFromServer.equalsIgnoreCase(user.getCode())) {

			if (user.getPassword().equals(user.getRepassword())) {
				if (userService.register(user)) {
					viewName = "tologin";
				} else {
					model.addAttribute("hint", "注册失败请尝试更换信息");
				}
			}else{
				model.addAttribute("hint", "注册失败两次密码重复");
			}
		}else {
				model.addAttribute("hint", "请输入正确的验证码");
		}
		return viewName;
	}

	

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:home";
	}
	
	@GetMapping(value="/code",produces = "image/png")
	@ResponseBody
    public BufferedImage getAuthCode(HttpSession session){
		int num=4;
		String code = CommonUtil.generateCode(num);
		//System.out.println(code);
		session.setAttribute("code", code);
		//resp.setContentType("image/png");
		BufferedImage codeImage = CommonUtil.generateCodeImage(code, 80, 30);
//		ImageIO.write(codeImage, "PNG", resp.getOutputStream());
//		resp.getOutputStream().flush();
		return codeImage;
    }
	
	@GetMapping("/check")
	@ResponseBody
	public CheckResult checkUsername(String username) {
		boolean valid=userService.checkUnique(username);
		return new CheckResult(username,valid,valid?"用户名可用":"用户名不可用",
				valid?"ok.png":"no.png");
	}
	
}