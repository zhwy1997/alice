package service.impl;

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
	public MyUsr usrInfo(int uid) {
		// TODO Auto-generated method stub
		MyUsr result = myUsrDAO.selectUserByuid(uid);
			return result;
	}

	@Override
	public MyUsr recharge(int uid,double balance,double agencyFee) {
		// TODO Auto-generated method stub
		MyUsr user  = new MyUsr();
		user.setUid(uid);
		user.setBalance(balance-agencyFee);
		int flag = myUsrDAO.updateUserBalance(user);
		if(flag==1) {
			MyUsr result=myUsrDAO.selectUserByuid(user.getUid());	//获取新对象
			return result;
		} else {
			return null;
		}
	}

	@Override
	public MyUsr pay(int uid,double balance,double agencyFee) {
		// TODO Auto-generated method stub
		MyUsr user  = new MyUsr();
		user.setUid(uid);
		user.setBalance(balance);
		int flag1 =  myUsrDAO.updateUserConsumption(user);//增加累计消费
		user.setBalance(-balance-agencyFee);//置收益为负数
		int flag2 =  myUsrDAO.updateUserBalance(user); //扣款
		if(flag1!=0&&flag2!=0) {
			MyUsr result=myUsrDAO.selectUserByuid(user.getUid());	//获取新对象
			return result;
		} else {
			return null;
		}
	}

}
