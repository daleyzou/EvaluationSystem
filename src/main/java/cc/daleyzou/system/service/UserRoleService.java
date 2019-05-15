package cc.daleyzou.system.service;

import cc.daleyzou.common.service.IService;
import cc.daleyzou.system.domain.UserRole;

public interface UserRoleService extends IService<UserRole> {

	void deleteUserRolesByRoleId(String roleIds);

	void deleteUserRolesByUserId(String userIds);
}
