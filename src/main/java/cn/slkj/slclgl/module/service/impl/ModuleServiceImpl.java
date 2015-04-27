package cn.slkj.slclgl.module.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.slkj.easyui.util.Tree;
import cn.slkj.slclgl.module.bean.Module;
import cn.slkj.slclgl.module.bean.Permission;
import cn.slkj.slclgl.module.mapper.ModuleMapper;

@Repository
public class ModuleServiceImpl {
	@Autowired
	private ModuleMapper mapper;

	public List<Module> getAll(HashMap<String, Object> map) {
		return mapper.getAll(map);
	}

	public List<Tree> getCombotree(String parentId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<Module> list = mapper.getAll(map);
		return toTree(list, "0");
	}

	private List<Tree> toTree(List<Module> list, String code) {
		List<Tree> trees = new ArrayList<Tree>();
		for (Module m : list) {
			Tree t = new Tree();
			t.setId(m.getId() + "");
			t.setText(m.getName());
			// t.setState();
			// t.setChecked();
			if (code.equals(m.getParent_id())) {
				t.setChildren(toTree(list, m.getId()));
				trees.add(t);
			}

		}
		return trees;
	}

	public int insert(Module module) {
		try {
			return mapper.insert(module);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

	public int update(Module module) {
		try {
			return mapper.update(module);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(String id) {
		try {
			return mapper.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

	public Module queryOne(String id) {
		return mapper.queryOne(id);
	}

	public List<Module> getModuleByRoleId(HashMap<String, Object> map) {
		return mapper.getModuleByRoleId(map);
	}

	public List<Module> listByUser(HashMap<String, Object> map) {
		return mapper.listByUser(map);
	}

	public List<Permission> getPermission(HashMap<String, Object> map) {
		return mapper.getPermission(map);
	}

	public List<Permission> getRolePer(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.getRolePer(map);
	}
}
