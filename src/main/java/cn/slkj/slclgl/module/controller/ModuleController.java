package cn.slkj.slclgl.module.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.slkj.easyui.util.Tree;
import cn.slkj.slclgl.module.bean.Module;
import cn.slkj.slclgl.module.service.impl.ModuleServiceImpl;

@Controller
@RequestMapping("/module")
public class ModuleController {
	@Autowired
	private ModuleServiceImpl moduleServiceImpl;
	@RequestMapping(value = "/queryOne/{id}")
	@ResponseBody
	public Module queryOne(@PathVariable String id) {
		return moduleServiceImpl.queryOne(id);
	}
	@RequestMapping(value = "/list")
	@ResponseBody
	public List<Module> list() {
		return moduleServiceImpl.getAll("");
	}

	@RequestMapping(value = "/getCombotree")
	@ResponseBody
	public List<Tree> getCombotree() {
		return moduleServiceImpl.getCombotree("");
	}

	@RequestMapping(value = "/addModule")
	@ResponseBody
	public boolean addModule(Module module) {
		int i = moduleServiceImpl.insert(module);
		if (i > 0) {
			return true;
		} else {
			return false;
		}

	}
	@RequestMapping(value = "/editModule")
	@ResponseBody
	public boolean editModule(Module module) {
		int i = moduleServiceImpl.update(module);
		if (i > 0) {
			return true;
		} else {
			return false;
		}

	}
	@RequestMapping(value = "/deleteModule/{id}")
	@ResponseBody
	public boolean deleteModule(@PathVariable String id) {
		int i = moduleServiceImpl.delete(id );
		if (i > 0) {
			return true;
		} else {
			return false;
		}

	}
}
