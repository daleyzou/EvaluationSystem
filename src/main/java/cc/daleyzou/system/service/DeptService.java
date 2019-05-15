package cc.daleyzou.system.service;

import java.util.List;

import cc.daleyzou.common.domain.Tree;
import cc.daleyzou.common.service.IService;
import cc.daleyzou.system.domain.Dept;

public interface DeptService extends IService<Dept> {

	Tree<Dept> getDeptTree();

	List<Dept> findAllDepts(Dept dept);

	Dept findByName(String deptName);

	Dept findById(Long deptId);
	
	void addDept(Dept dept);
	
	void updateDept(Dept dept);

	void deleteDepts(String deptIds);
}
