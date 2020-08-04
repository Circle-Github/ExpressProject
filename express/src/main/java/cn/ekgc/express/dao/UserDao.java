package cn.ekgc.express.dao;

import cn.ekgc.express.pojo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>用户模块数据持久层接口</b>
 * @author Arthur
 * @version 1.0.0 2020-08-04
 * @since 1.0.0
 */
@Repository
public interface UserDao {
	/**
	 * <b>根据用户信息查询相关用户信息列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<User> findUserListByQuery(User query) throws Exception;
}
