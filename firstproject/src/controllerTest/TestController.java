package controllerTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybatis.po.MyUsr;
@Controller
public class TestController {
	/**
	 * 接收页面请求的JSON数据，并返回JSON格式结果
	 */
	@RequestMapping("/testJson")
	@ResponseBody
	public MyUsr testJson(@RequestBody MyUsr user) {
		//打印接收的JSON格式数据
		System.out.println("pname=" + user.getuAccount() +
				", password=" + user.getPassword());
		//返回JSON格式的响应
		return user;
	}
}
