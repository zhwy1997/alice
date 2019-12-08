package service.interfaces;
import com.mybatis.po.MyUsr;
import java.util.List;
public interface UsrService {

		/**登录
		 * @param user 登录信息只含用户名和密码
		 * @return 登录后的用户信息
		 */
		MyUsr login(MyUsr user);	
		/**注册
		 * @param user 注册的用户信息
		 * @return  注册成功后的用户信息
		 */
		MyUsr register(MyUsr user);	
		/**
		  *修改
		 * @param user 修改信息
		 * @return 修改后用户信息
		 */
		MyUsr modify(MyUsr user);	
		
		/** 查询用户信息
		 * @param user 使用ID查询
		 * @return 查询结果
		 */
		MyUsr usrInfo(MyUsr user);
		List<MyUsr> allUsrInfo();

}
