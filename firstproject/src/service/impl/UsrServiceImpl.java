package service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mybatis.po.MyUsr;
import service.interfaces.UsrService;
import com.mybatis.DAO.MyUsrDAO;
@Service("usrService")
public class UsrServiceImpl implements UsrService {
	@Autowired
	private MyUsrDAO myUsrDAO;
	@Override
	public MyUsr login(MyUsr user) {
		// TODO Auto-generated method stub		
		MyUsr result = myUsrDAO.selectUserByuAccount(user.getuAccount());
		if(result!=null) {//用户名存在
			if(user.getPassword().equals(result.getPassword())) {// 密码一致
				return result;
			} else {
				return user;
			}
		} else {
			return null;
		}
	}

	@Override
	public MyUsr register(MyUsr user) {
		// TODO Auto-generated method stub
		if(myUsrDAO.selectUserByuAccount(user.getuAccount())==null) {	//无此用户则添加
			myUsrDAO.addUser(user);
			MyUsr result=myUsrDAO.selectUserByuAccount(user.getuAccount());
			return result;
		}	else {	
			return null;
		}
	}

	
	@Override
	public MyUsr modify(MyUsr user) {
		// TODO Auto-generated method stub
		int flag = myUsrDAO.updateUser(user);
		if(flag==1) {
			MyUsr result=myUsrDAO.selectUserByuid(user.getUid());	//获取新对象
			return result;
		} else {
			return null;
		}

	}

	@Override
	public MyUsr usrInfo(MyUsr user) {
		// TODO Auto-generated method stub
		MyUsr result = myUsrDAO.selectUserByuid(user.getUid());
			return result;
	}

	@Override
	public List<MyUsr> allUsrInfo() {
		// TODO Auto-generated method stub
		List<MyUsr> result = myUsrDAO.selectAllUser();
		return result;
	}
}
