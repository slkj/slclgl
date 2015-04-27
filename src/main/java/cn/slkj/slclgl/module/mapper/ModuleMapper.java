package cn.slkj.slclgl.module.mapper;

import java.util.HashMap;
import java.util.List;

import cn.slkj.slclgl.module.bean.Module;
import cn.slkj.slclgl.module.bean.Permission;

public interface ModuleMapper {
	List<Module> getAll(HashMap<String, Object> map);

	int insert(Module module);

	int update(Module module);

	int delete(String id);

	Module queryOne(String id);

	List<Module> getModuleByRoleId(HashMap<String, Object> map);

	List<Module> listByUser(HashMap<String, Object> map);
	
	List<Permission> getPermission(HashMap<String, Object> map);

	List<Permission> getRolePer(HashMap<String, Object> map);
}
