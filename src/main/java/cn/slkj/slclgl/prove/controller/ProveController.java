package cn.slkj.slclgl.prove.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.slkj.easyui.util.EPager;
import cn.slkj.slclgl.devices.bean.Devices;
import cn.slkj.slclgl.devices.bean.Devices_record;
import cn.slkj.slclgl.prove.bean.Prove;
import cn.slkj.slclgl.prove.service.ProveService;
import cn.slkj.slclgl.util.LocationUtil;

@Controller
@RequestMapping("/prove")
public class ProveController {
	@Autowired
	private ProveService proveService;

	@RequestMapping("/list")
	@ResponseBody
	public EPager<Prove> getAll(HttpServletRequest request) throws Exception {
		Map<String, Object> pageMap = new HashMap<String, Object>();
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		pageMap.put("rktime", request.getParameter("rktime"));
		pageMap.put("rktime1", request.getParameter("rktime1"));
		pageMap.put("lytime", request.getParameter("lytime"));
		pageMap.put("lytime1", request.getParameter("lytime1"));
		pageMap.put("fhtime", request.getParameter("fhtime"));
		pageMap.put("fhtime1", request.getParameter("fhtime1"));
		pageMap.put("state", request.getParameter("state"));
		pageMap.put("lyr", request.getParameter("lyr"));
		pageMap.put("firm", request.getParameter("firm"));
		// TODO 处理地区代码，如果后面有0的要like
		String area = request.getParameter("area");
		pageMap.put("area", area != null ? LocationUtil.toLocation(area) : area);
		pageMap.put("listnum", request.getParameter("listnum"));
		pageMap.put("phone", request.getParameter("phone"));
		pageMap.put("carNumber", request.getParameter("carNumber"));
		String sort = request.getParameter("sort");
		// if(StringUtils.isNotBlank(sort)){
		pageMap.put("sort", sort != null ? sort : "rktime");
		// }
		String order = request.getParameter("order");
		// if(StringUtils.isNotBlank(order)){
		pageMap.put("order", order != null ? order : "desc");
		// }
		pageMap.put("startPage", (page - 1) * rows);
		pageMap.put("endPage", rows);
		int total = proveService.getAllCount(pageMap);
		List<Prove> list = proveService.getAll(pageMap);
		return new EPager<Prove>(total, list);
	}

}
