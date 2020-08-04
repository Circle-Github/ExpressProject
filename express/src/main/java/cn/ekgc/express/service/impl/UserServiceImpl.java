package cn.ekgc.express.service.impl;

import cn.ekgc.express.dao.UserDao;
import cn.ekgc.express.pojo.entity.User;
import cn.ekgc.express.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>用户模块业务层接口实现类</b>
 * @author Arthur
 * @version 1.0.0 2020-08-04
 * @since 1.0.0
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	/**
	 * <b>根据手机号码查询用户信息</b>
	 * @param cellphone
	 * @return
	 * @throws Exception
	 */
	@Override
	public User getUserByCellphone(String cellphone) throws Exception {
		// 创建查询对象
		User query = new User();
		query.setCellphone(cellphone);
		List<User> userList = userDao.findUserListByQuery(query);
		if (userList != null && userList.size() > 0) {
			// 此时查询获得相关数据
			return userList.get(0);
		}
		return null;
	}
}
