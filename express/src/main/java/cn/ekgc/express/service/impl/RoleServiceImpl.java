package cn.ekgc.express.service.impl;

import cn.ekgc.express.dao.RoleDao;
import cn.ekgc.express.dao.UserDao;
import cn.ekgc.express.pojo.entity.Role;
import cn.ekgc.express.pojo.vo.Page;
import cn.ekgc.express.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>角色模块业务层接口实现类</b>
 * @author Arthur
 * @version 1.0.0 2020-08-05
 * @since 1.0.0
 */
@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;

	/**
	 * <b>分页查询信息列表</b>
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@Override
	public Page<Role> getListByPage(Page<Role> page) throws Exception {
		// 使用 PageHelper 进行分页查询
		//获取第1页，10条内容，默认查询总数count
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<Role> list = roleDao.findListByQuery(null);
		// 为了获得分页的其他信息，通过使用分页后的列表获得 PageInfo 对象
		PageInfo<Role> pageInfo = new PageInfo<Role>(list);
		// 提取 PageInfo 对象中的相关信息，进行系统分页对象 Page 属性的填充
		page.setList(list);
		page.setTotalSize(pageInfo.getTotal());
		page.setTotalPage((long) pageInfo.getPages());

		return page;
	}
}
