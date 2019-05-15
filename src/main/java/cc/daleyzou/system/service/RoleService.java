package cc.daleyzou.system.service;

import java.util.List;

import cc.daleyzou.common.service.IService;
import cc.daleyzou.system.domain.Role;
import cc.daleyzou.system.domain.RoleWithMenu;

public interface RoleService extends IService<Role> {

	List<Role> findUserRole(String userName);

	List<Role> findAllRole(Role role);
	
	RoleWithMenu findRoleWithMenus(Long roleId);

	Role findByName(String roleName);

	void addRole(Role role, Long[] menuIds);
	
	void updateRole(Role role, Long[] menuIds);

	void deleteRoles(String roleIds);
}
