package cn.ekgc.express.controller;

import cn.ekgc.express.controller.base.BaseController;
import cn.ekgc.express.pojo.entity.Menu;
import cn.ekgc.express.pojo.entity.Role;
import cn.ekgc.express.pojo.entity.User;
import cn.ekgc.express.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * <b>首页模块控制器</b>
 * @author Arthur
 * @version 1.0.0 2020-08-04
 * @since 1.0.0
 */
@Controller("indexController")
public class IndexController extends BaseController {
	@Autowired
	private MenuService menuService;

	/**
	 * <b>加载首页面</b>
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/")
	public String index(ModelMap map) throws Exception {
		// 获得当前登录用户
		User user = (User) session.getAttribute("user");
		if (user != null) {
			// 用户已登录
			// 根据当前登录用户获得对应的角色
			Role role = user.getRole();
			// 根据角色获得对应的菜单功能
			List<Menu> menuList = menuService.getMenuListForIndex(role);
			// 转发到页面
			map.put("menuList", menuList);
			return "index";
		}
		return "redirect:user/login";
	}
}
