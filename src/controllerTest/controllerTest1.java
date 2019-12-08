package controllerTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybatis.po.MyUsr;

import serviceTest.MvcTest;


@Controller
public class controllerTest1 {
	
	//注入服务类
	@Autowired
	private MvcTest mvcTest;

	@RequestMapping("/login")
	public 	@ResponseBody MyUsr login (@RequestBody MyUsr usr) {
		System.out.println("这是测试控制器类");	
		mvcTest.test();
			return usr;
		}
	
}
