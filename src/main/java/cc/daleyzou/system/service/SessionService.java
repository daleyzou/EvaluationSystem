package cc.daleyzou.system.service;

import java.util.List;

import cc.daleyzou.system.domain.UserOnline;

public interface SessionService {

	List<UserOnline> list();

	boolean forceLogout(String sessionId);
}
