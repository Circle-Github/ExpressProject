package cn.ekgc.express.service.impl;

import cn.ekgc.express.dao.MenuDao;
import cn.ekgc.express.pojo.entity.Menu;
import cn.ekgc.express.pojo.entity.Role;
import cn.ekgc.express.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>菜单模块业务层接口实现类</b>
 * @author Arthur
 * @version 1.0.0 2020-08-04
 * @since 1.0.0
 */
@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDao menuDao;

	/**
	 * <b>根据角色查询菜单列表</b>
	 * @param role
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Menu> getMenuListForIndex(Role role) throws Exception {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("role", role.getId());
		// 查询所有的一级菜单
		queryMap.put("parent", null);
		List<Menu> menuList = menuDao.findMenuListByRoleAndParent(queryMap);
		// 循环遍历一级菜单
		for (Menu parent : menuList) {
			// 获得此时一级菜单的主键，该主键是二级菜单的 parent_id
			queryMap.put("parent", parent.getId());
			List<Menu> childrenMenus = menuDao.findMenuListByRoleAndParent(queryMap);
			parent.setChildrenMenus(childrenMenus);
		}
		return menuList;
	}
}
