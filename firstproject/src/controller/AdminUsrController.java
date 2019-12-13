package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybatis.po.MyUsr;
import com.mybatis.po.AdminUsr;

import com.mybatis.pojo.AdminMessage;

import service.interfaces.AdminUsrService;

@Controller
@RequestMapping(value="/admin")
public class AdminUsrController {
	@Autowired 
	private AdminUsrService adminUsrService;

	@RequestMapping("/login")
	public 	@ResponseBody AdminMessage login (@RequestBody AdminUsr adminUsr) {
		System.out.println("登录");	
		AdminUsr result=adminUsrService.login(adminUsr);
		AdminMessage response = new AdminMessage();
		if(result==null) {
			System.out.println("无此用户名");
			response.setAdminUsr(result);
			response.setMessage("无此用户名");
			response.setMessageCode("00");
		} else if(result.equals(adminUsr)){
			System.out.println("密码错误");
			response.setAdminUsr(result);
			response.setMessage("密码错误");
			response.setMessageCode("01");
		} else{
			System.out.println("查询成功");
			response.setAdminUsr(result);
			response.setMessage("查询成功");
			response.setMessageCode("10");
			
		}
			return response;
		}
	
	
	@RequestMapping(value="/allUsrinfo",method=RequestMethod.POST)
	public @ResponseBody AdminMessage allUsrInfo() {
		List <MyUsr> result = adminUsrService.allUsrInfo();
		AdminMessage response = new AdminMessage();
		if (result==null) {
			response.setUsrList(result);
			response.setMessage("无用户列表");
			response.setMessageCode("00");
			
		} else {
			response.setUsrList(result);
			response.setMessage("查询成功");
			response.setMessageCode("10");
		}
			
		return response;
		
	}

}
