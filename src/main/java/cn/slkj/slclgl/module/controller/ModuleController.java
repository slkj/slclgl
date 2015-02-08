package cn.slkj.slclgl.module.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.slkj.slclgl.module.bean.Module;
import cn.slkj.slclgl.module.service.impl.ModuleServiceImpl;

@Controller
@RequestMapping("/module")
public class ModuleController {
	@Autowired
	private ModuleServiceImpl moduleServiceImpl;

	@RequestMapping(value = "/list/{roleid}")
	@ResponseBody
	public List<Module> list(@PathVariable String roleid) {
		List<Module> list = moduleServiceImpl.getAll(roleid);
		return list;
	}

}
