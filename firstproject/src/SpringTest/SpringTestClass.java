package SpringTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import SpringTest.SpringTestController;



public class SpringTestClass {
	public static void main (String[] args) {
		ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过容器获取testDIService实例，测试构造方法 注入
	   SpringTestController t=(SpringTestController)appCon.getBean("springTestController");
		t.test();
		
	}
}
