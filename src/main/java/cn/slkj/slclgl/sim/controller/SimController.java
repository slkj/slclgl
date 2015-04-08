package cn.slkj.slclgl.sim.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.slkj.easyui.util.EPager;
import cn.slkj.slclgl.sim.bean.Sim;
import cn.slkj.slclgl.sim.service.impl.SimServiceImpl;

@Controller
@RequestMapping("/sim")
public class SimController {
	@Autowired
	private SimServiceImpl impl;

	@RequestMapping("/list")
	@ResponseBody
	public EPager<Sim> getAllUsers(HttpServletRequest request) throws Exception {
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		Map<String, Object> pageMap = new HashMap<String, Object>();
		pageMap.put("startPage", (page - 1) * rows);
		pageMap.put("endPage", rows);
		pageMap.put("intime", request.getParameter("intime"));
		pageMap.put("type", Integer.parseInt(request.getParameter("type")));
		pageMap.put("state", request.getParameter("state"));
		pageMap.put("cardType", request.getParameter("cardType"));
		int total = impl.getAllCount(pageMap);
		List<Sim> list = impl.getAll(pageMap);
		return new EPager<Sim>(total, list);
	}
	
	@RequestMapping("/getList")
	@ResponseBody
	public List<Sim> getList(HttpServletRequest request) throws Exception {
		int telnum = Integer.parseInt(request.getParameter("telnum"));
		Map<String, Object> pageMap = new HashMap<String, Object>();
		pageMap.put("telnum", telnum);
		return impl.getList(pageMap);
	}
	@RequestMapping(value = "/addSim", method = { RequestMethod.POST })
	@ResponseBody
	public boolean addModule(Sim sim) {
		int i = impl.insert(sim);
		if (i > 0) {
			return true;
		} else {
			return false;
		}

	}
}
