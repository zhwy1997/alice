package com.mybatis.DAOtest;
/**
*sellgood持久层测试类 测试给定条件下的待售商品查询
*/
import java.io.InputStream;
import java.util.List;
import java.io.IOException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.mybatis.pojo.SellGoodsParam;
import com.mybatis.po.SellGoods;
public class TestCondition {
	public static void main(String[] args) {
		try {
			//读取配置文件mybatis-config.xml
			InputStream config = Resources.getResourceAsStream("com/mybatis/mapper/MybatisTest-config.xml");
			//根据配置文件构建SqlSessionFactory
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
			//通过SqlSessionFactory创建SqlSession
			SqlSession sqlSession = ssf.openSession();
			//SqlSession执行映射文件中定义的SQL，并返回映射结果
			SellGoodsParam param = new SellGoodsParam();
			param.setGood_Type("电子类");
		    List<SellGoods> listSellGoods = sqlSession.selectList("com.mybatis.DAO.SellGoodsDAO.selectSellGoods",param); 
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