package SpringTest;
import controller.UsrController;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybatis.po.MyUsr;


public class UsrTest {
	public static void main(String[] args) {
		ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
		UsrController i = (UsrController)appCon.getBean("usrController");
		MyUsr u = new MyUsr();
		u.setuAccount("admin0");
		u.setPassword("root");
//		MyUsr n= i.login(u);
	//	System.out.println(n);
		
	}
}
