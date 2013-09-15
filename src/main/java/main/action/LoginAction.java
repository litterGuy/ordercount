package main.action;

import javax.annotation.Resource;

import main.model.CommonUser;
import main.service.CommonUserService;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Namespace("/login")
@Scope("prototype")  
public class LoginAction extends ActionSupport{
	private static final long serialVersionUID = 2259907236377321303L;
	private final static Logger log = Logger.getLogger(LoginAction.class);
	
	@Resource
	private CommonUserService userService;
	
	private CommonUser user;
	private String loginStatus;
	
	@Action(value = "login", results = {
															@Result(name = "success", location = "/WEB-INF/page/welcome.jsp"),
															@Result(name = "error", location = "/index.jsp")
														 }) 
	public String login(){
		log.info("not too bad,at last one page picture had push!!");
		boolean flag = userService.userLogin(user);
		String result = "success";
		if(!flag){
			loginStatus = "error";
			result = "error";
		}
		return result;
	}

	public CommonUser getUser() {
		return user;
	}

	public void setUser(CommonUser user) {
		this.user = user;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	
	 
}
