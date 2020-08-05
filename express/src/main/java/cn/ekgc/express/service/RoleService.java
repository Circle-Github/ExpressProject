package cn.ekgc.express.service;

import cn.ekgc.express.pojo.entity.Role;
import cn.ekgc.express.pojo.vo.Page;

/**
 * <b>角色模块业务层接口</b>
 * @author Arthur
 * @version 1.0.0 2020-08-05
 * @since 1.0.0
 */
public interface RoleService {
	/**
	 * <b>分页查询信息列表</b>
	 * @param page
	 * @return
	 * @throws Exception
	 */
	Page<Role> getListByPage(Page<Role> page) throws Exception;
}
