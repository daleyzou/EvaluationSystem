package cc.daleyzou.system.dao;

import java.util.List;

import cc.daleyzou.common.config.MyMapper;
import cc.daleyzou.system.domain.Role;
import cc.daleyzou.system.domain.RoleWithMenu;

public interface RoleMapper extends MyMapper<Role> {
	
	List<Role> findUserRole(String userName);
	
	List<RoleWithMenu> findById(Long roleId);
}