package service.interfaces;

import java.util.List;

import com.mybatis.po.AdminUsr;
import com.mybatis.po.MyUsr;

public interface AdminUsrService {
	/**登录
	 * @param admin 登录信息只含用户名和密码
	 * @return 登录后的用户信息
	 */
	AdminUsr login(AdminUsr adminUsr);
	/**查询所有用户
	 * @return 用户信息列表
	 */
	List<MyUsr> allUsrInfo();
}
