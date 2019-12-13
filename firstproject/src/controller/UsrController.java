package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybatis.po.MyUsr;
import com.mybatis.pojo.UsrMessage;

import service.interfaces.UsrService;

@Controller
@RequestMapping(value="/usr")
public class UsrController {
	//注入服务类
	@Autowired
	private UsrService usrService;

	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public 	@ResponseBody UsrMessage login (@RequestBody MyUsr usr) {
		System.out.println("登录");	
		MyUsr result=usrService.login(usr);
		UsrMessage response = new UsrMessage();
		if(result==null) {
			System.out.println("无此用户名");
			response.setMyUsr(result);
			response.setMessage("无此用户名");
			response.setMessageCode("00");
		} else if(result.equals(usr)){
			System.out.println("密码错误");
			response.setMyUsr(result);
			response.setMessage("密码错误");
			response.setMessageCode("01");
		} else{
			System.out.println("查询成功");
			response.setMyUsr(result);
			response.setMessage("查询成功");
			response.setMessageCode("10");
			
		}
			return response;
		}
	
	@RequestMapping("/register")
	public @ResponseBody UsrMessage register(@RequestBody MyUsr usr) {
		System.out.println("注册");	
		MyUsr result=usrService.register(usr);
		UsrMessage response = new UsrMessage();
		if(result==null) {
			response.setMyUsr(result);
			response.setMessage("注册失败 已存在的用户名");
			response.setMessageCode("00");
		} else {
			response.setMyUsr(result);
			response.setMessage("注册成功");
			response.setMessageCode("10");
		}
			return response;
	}

	@RequestMapping("/modify") 
	public @ResponseBody UsrMessage modify(@RequestBody MyUsr usr) {
		System.out.println("修改基本信息");
		MyUsr result=usrService.modify(usr);
		UsrMessage response = new UsrMessage();
		if(result==null) {
			response.setMyUsr(result);
			response.setMessage("修改失败");
			response.setMessageCode("00");
		} else {
			response.setMyUsr(result);
			response.setMessage("修改成功");
			response.setMessageCode("10");
		}
			return response;
	}

	@RequestMapping("/info")
	public @ResponseBody UsrMessage usrInfo(@RequestBody MyUsr usr) {
		MyUsr result = usrService.usrInfo(usr.getUid());
		UsrMessage response = new UsrMessage();
		if (result==null) {
			response.setMyUsr(result);
			response.setMessage("查询失败");
			response.setMessageCode("00");
		} else {
			response.setMyUsr(result);
			response.setMessage("查询成功");
			response.setMessageCode("10");
		}
		return response;
	}
	
	//充值
	@RequestMapping("/recharge")
	public @ResponseBody UsrMessage recharge(@RequestBody MyUsr usr) {
		MyUsr result = usrService.recharge(usr.getUid(),usr.getBalance(), 0);
		UsrMessage response = new UsrMessage();
		if (result==null) {
			response.setMyUsr(result);
			response.setMessage("充值成功");
			response.setMessageCode("10");
		} else {
			response.setMyUsr(result);
			response.setMessage("充值失败");
			response.setMessageCode("00");
		}
		return response;
	}



}
