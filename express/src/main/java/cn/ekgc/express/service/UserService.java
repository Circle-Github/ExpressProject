package cn.ekgc.express.service;

import cn.ekgc.express.pojo.entity.User;

/**
 * <b>用户模块业务层接口</b>
 * @author Arthur
 * @version 1.0.0 2020-08-04
 * @since 1.0.0
 */
public interface UserService {
	/**
	 * <b>根据手机号码查询用户信息</b>
	 * @param cellphone
	 * @return
	 * @throws Exception
	 */
	User getUserByCellphone(String cellphone) throws Exception;
}
