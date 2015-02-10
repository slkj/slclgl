package cn.slkj.slclgl.module.service;

import java.util.List;

import cn.slkj.easyui.util.Tree;
import cn.slkj.slclgl.module.bean.Module;

public interface ModuleService {

	List<Module> getAll(String parentId);

	List<Tree> getCombotree(String parentId);

	int insert(Module module);

	int update(Module module);

	int delete(String id);

	Module queryOne(String id);
}
