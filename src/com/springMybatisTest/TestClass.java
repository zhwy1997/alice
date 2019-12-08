package com.springMybatisTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;
import com.mybatis.DAO.MyUsrDAO;
import com.mybatis.po.MyUsr;
public class TestClass {
//	List<MyUsr> ; 
	
	public static void main(String[] args) {
		ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
		MyUsrDAO dao = appCon.getBean(MyUsrDAO.class);
		List<MyUsr> usrList = dao.selectAllUser();
	//	MyUsr usr = dao.selectUserByuid(1);
//		System.out.print(usr);
		for (MyUsr i: usrList) {
			System.out.print(i);
		}
	}
}
