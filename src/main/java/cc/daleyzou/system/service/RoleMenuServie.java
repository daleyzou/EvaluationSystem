package cc.daleyzou.system.service;

import cc.daleyzou.common.service.IService;
import cc.daleyzou.system.domain.RoleMenu;

public interface RoleMenuServie extends IService<RoleMenu> {

	void deleteRoleMenusByRoleId(String roleIds);

	void deleteRoleMenusByMenuId(String menuIds);
}
