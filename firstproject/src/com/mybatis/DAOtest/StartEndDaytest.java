package com.mybatis.DAOtest;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.po.AgencyTable;
import com.mybatis.pojo.AgencyTableParam;

public class StartEndDaytest {
	public static void main(String[] args) throws ParseException {
		try {
			//读取配置文件mybatis-config.xml
			InputStream config = Resources.getResourceAsStream("com/mybatis/mapper/MybatisTest-config.xml");
			//根据配置文件构建SqlSessionFactory
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
			//通过SqlSessionFactory创建SqlSession
			SqlSession sqlSession = ssf.openSession();
			//SqlSession执行映射文件中定义的SQL，并返回映射结果
			
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = dateformat.parse("2019-10-30");
			
			AgencyTableParam agencyTable = new AgencyTableParam();
			agencyTable.setStartDay(date); 
			date = dateformat.parse("2019-12-1");
			agencyTable.setEndDay(date); 
			agencyTable.setCity("北京");
		
		    List<AgencyTable> listAgencyTable = sqlSession.selectList("com.mybatis.DAO.AgencyTableDao.selectAgencyTableByDay",agencyTable); 
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
