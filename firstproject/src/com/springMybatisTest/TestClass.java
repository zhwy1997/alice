package com.springMybatisTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;
import com.mybatis.DAO.MyUsrDAO;
import com.mybatis.DAO.SellGoodsDAO;
import com.mybatis.po.MyUsr;
import com.mybatis.po.SellGoods;
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
	
		SellGoodsDAO sdao = appCon.getBean(SellGoodsDAO.class);
		SellGoods sellGoods = sdao.selectLatestSellGoodsByUsr(1);
		System.out.print(sellGoods);
		/*
		 * List<SellGoods> sellGoodsList = sdao.selectAllSellGoods(); for (SellGoods i:
		 * sellGoodsList ) { System.out.print(i); }
		 */
	}
}
