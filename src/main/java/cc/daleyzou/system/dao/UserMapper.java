package cc.daleyzou.system.dao;

import java.util.List;

import cc.daleyzou.common.config.MyMapper;
import cc.daleyzou.system.domain.User;
import cc.daleyzou.system.domain.UserWithRole;

public interface UserMapper extends MyMapper<User> {

	List<User> findUserWithDept(User user);
	
	List<UserWithRole> findUserWithRole(Long userId);
	
	User findUserProfile(User user);
}