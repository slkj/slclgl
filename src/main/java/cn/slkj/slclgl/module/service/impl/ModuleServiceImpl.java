package cn.slkj.slclgl.module.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.slkj.slclgl.module.bean.Module;
import cn.slkj.slclgl.module.mapper.ModuleMapper;
import cn.slkj.slclgl.module.service.ModuleService;

@Service
public class ModuleServiceImpl implements ModuleService {
	@Autowired
	private ModuleMapper mapper;

	@Override
	public List<Module> getAll() {
		List<Module> list = mapper.getAll();
		return makeTree(list);
	}

	private List<Module> makeTree(List<Module> list) {
		List<Module> parent = new ArrayList<Module>();
		for (Module e : list) {
			if (e.getParent_id() == null) {
				e.setChildren(new ArrayList<Module>(0));
				parent.add(e);
			}
		}
		// 删除parentId = null;
		list.removeAll(parent);
		makeChildren(parent, list);
		return parent;
	}
	private void makeChildren(List<Module> parent, List<Module> children) {
		if (children.isEmpty()) {
			return ;
		}
		
		List<Module> tmp = new ArrayList<Module>();
		for (Module c1 : parent) {
			for (Module c2 : children) {
				c2.setChildren(new ArrayList<Module>(0));
				if (c1.getId().equals(c2.getParent().getId())) {
					c1.getChildren().add(c2);
					tmp.add(c2);
				}
			}
		}
		
		children.removeAll(tmp);
		
		makeChildren(tmp, children);
	}
}
