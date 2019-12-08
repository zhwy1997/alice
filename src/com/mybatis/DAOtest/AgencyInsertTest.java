package com.mybatis.DAOtest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.po.AgencyTable;
/*
 * 测试agencyInsert的自动更新否则插入功能
 */
public class AgencyInsertTest {
	public static void main(String[] args) {
		try {
			//读取配置文件mybatis-config.xml
			InputStream config = Resources.getResourceAsStream("com/mybatis/mapper/MybatisTest-config.xml");
			//根据配置文件构建SqlSessionFactory
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
			//通过SqlSessionFactory创建SqlSession
			SqlSession sqlSession = ssf.openSession();
			//SqlSession执行映射文件中定义的SQL，并返回映射结果
			AgencyTable agencyTable = new AgencyTable();
			agencyTable.setDealDay(new Date());
			agencyTable.setCity("北京");
			agencyTable.setGoodType("电子类");
			agencyTable.setIncome(20.0);
			sqlSession.insert("com.mybatis.mapper.AgencyTableMapper.addAgencyTable", agencyTable);
			
			agencyTable.setCity("上海");
			agencyTable.setGoodType("电子类");
			agencyTable.setIncome(15.0);
			sqlSession.insert("com.mybatis.mapper.AgencyTableMapper.addAgencyTable", agencyTable);
			
	
		    List<AgencyTable> listAgencyTable = sqlSession.selectList("com.mybatis.DAO.AgencyTableDao.selectAllAgencyTable"); 
				  for (AgencyTable table : listAgencyTable) { 
					  System.out.println(table); 
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
