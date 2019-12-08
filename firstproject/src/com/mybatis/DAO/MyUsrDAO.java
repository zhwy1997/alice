package com.mybatis.DAO;
/*
 * MyUsr类DAO层
 */
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mybatis.po.MyUsr;

@Repository
@Mapper
/*使用Spring自动扫描MyBatis的接口并装配
（Spring将指定包中所有被@Mapper注解标注的接口自动装配为MyBatis的映射接口*/
public interface MyUsrDAO {
	public MyUsr selectUserByuid (Integer uid);
	public MyUsr selectUserByuAccount (String uAccount);
	public List<MyUsr> selectAllUser ();
	public int addUser (MyUsr usr);
	public int updateUser (MyUsr usr);
}
