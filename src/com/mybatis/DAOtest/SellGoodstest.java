package com.mybatis.DAOtest;
/**
*sellgood持久层测试类
*/
import java.io.InputStream;

import java.util.List;
import java.io.IOException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.po.SellGoods;
public class SellGoodstest {
	public static void main(String []args) {
	try {
		//读取配置文件mybatis-config.xml
		InputStream config = Resources.getResourceAsStream("com/mybatis/mapper/MybatisTest-config.xml");
		//根据配置文件构建SqlSessionFactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
		//通过SqlSessionFactory创建SqlSession
		SqlSession sqlSession = ssf.openSession();
		//SqlSession执行映射文件中定义的SQL，并返回映射结果
		//com.mybatis.mapper.UserMapper.selectUserById为UserMapper.xml中的命名空间+select的id
/*
		File file = new File("D:\\jee-2019-09\\IMG\\moog.gif");
		InputStream inputStream= new FileInputStream(file);
		SellGoods addSellGoods = new SellGoods();
		//insert into SellGoods (belongUsr,goodType,goodName,minPrice,fixedPrice,goodDescription,goodIMG) 

		addSellGoods.setBelongUsr(1);
		addSellGoods.setGoodType("电子类");
		addSellGoods.setMinPrice(1.0);
		addSellGoods.setFixedPrice(1);
		addSellGoods.setGoodDescription("一件测试用的商品");
		addSellGoods.setGoodIMG(inputStream);
		addSellGoods.setGoodName("测试商品2号");
		sqlSession.insert("com.mybatis.mapper.SellGoodsMapper.addSellGoods", addSellGoods);
*/
		//查询所有商品
			
			/*
			 * List<SellGoods> listSellGoods =
			 * sqlSession.selectList("com.mybatis.mapper.SellGoodsMapper.selectAllSellGoods"
			 * ); for (SellGoods goods : listSellGoods) { System.out.println(goods); }
			 */
		//查询某账号下所有商品
			  List<SellGoods> listSellGoods =
					  sqlSession.selectList("com.mybatis.DAO.SellGoodsDao.selectSellGoodsByUsr",3); 
			  for (SellGoods goods : listSellGoods) { 
				  System.out.println(goods); 
				  }
		
		
		//提交事务
		sqlSession.commit();
		//关闭SQL
		if (sqlSession!=null) {
			sqlSession.close();
		}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		
		
	}
}
