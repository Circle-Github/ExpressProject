package cn.ekgc.express.service;

import cn.ekgc.express.pojo.entity.Menu;
import cn.ekgc.express.pojo.entity.Role;

import java.util.List;

/**
 * <b>菜单模块业务层接口</b>
 * @author Arthur
 * @version 1.0.0 2020-08-04
 * @since 1.0.0
 */
public interface MenuService {
	/**
	 * <b>根据角色查询菜单列表</b>
	 * @param role
	 * @return
	 * @throws Exception
	 */
	List<Menu> getMenuListForIndex(Role role) throws Exception;
}
