package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.DAO.AdminUsrDAO;
import com.mybatis.DAO.MyUsrDAO;
import com.mybatis.po.AdminUsr;
import com.mybatis.po.MyUsr;

import service.interfaces.AdminUsrService;
@Service("adminUsrService")
public class AdminUsrServiceImpl implements AdminUsrService {

	@Autowired
	private AdminUsrDAO adminUsrDAO;
	@Autowired
	private MyUsrDAO myUsrDAO;
	@Override
	public AdminUsr login(AdminUsr adminUsr) {
			// TODO Auto-generated method stub		
		AdminUsr result = adminUsrDAO.selectUserByuAccount(adminUsr.getuAccount());
			if(result!=null) {//用户名存在
				if(adminUsr.getPassword().equals(result.getPassword())) {// 密码一致
					return result;
				} else {
					return adminUsr;
				}
			} else {
				return null;
			}
	}
	
	
	@Override
	public List<MyUsr> allUsrInfo() {
		// TODO Auto-generated method stub
		List<MyUsr> result = myUsrDAO.selectAllUser();
		return result;
	}
}


