package cn.slkj.slclgl.module.mapper;

import java.util.HashMap;
import java.util.List;

import cn.slkj.slclgl.module.bean.Module;

public interface ModuleMapper {
	List<Module> getAll(HashMap<String, Object> map);

	int insert(Module module);

	int update(Module module);

	int delete(String id);
}
