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
import cn.slkj.easyui.util.JsonResult;
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
		pageMap.put("number", request.getParameter("number"));
		pageMap.put("address", request.getParameter("address"));
		pageMap.put("usman", request.getParameter("usman"));
		pageMap.put("endDate", request.getParameter("endDate"));
		pageMap.put("endDate1", request.getParameter("endDate1"));
		pageMap.put("state", request.getParameter("state"));
		pageMap.put("startPage", (page - 1) * rows);
		pageMap.put("endPage", rows);
		int total = proveService.getAllCount(pageMap);
		List<Prove> list = proveService.getAll(pageMap);
		return new EPager<Prove>(total, list);
	}
	/**
	 * 获取实体
	 * @param insurance
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryOne")
	public Prove queryOne(Prove prove) {
		return proveService.queryOne(prove);
	}
	/** 添加*/
	@ResponseBody
	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public JsonResult save(Prove prove)
			throws Exception {
		try {
			
			int i = proveService.save(prove);
			if (i != -1) {
				return new JsonResult(true, "");
			}
		} catch (Exception e) {
			throw new Exception(
					"this is the detail of ajax exception information");
		}
		return new JsonResult(false, "保存失败！");
	}
	
	
	
	
	/** 编辑*/
	@ResponseBody
	@RequestMapping(value = "/editSave", method = { RequestMethod.POST })
	public JsonResult editSave(Prove prove)
			throws Exception {
		try {

			int i = proveService.edit(prove);
			if (i != -1) {
				return new JsonResult(true, "");
			}
		} catch (Exception e) {
			throw new Exception(
					"this is the detail of ajax exception information");
		}
		return new JsonResult(false, "编辑失败！");
	}
	/** 使用*/
	@ResponseBody
	@RequestMapping(value = "/useSave", method = { RequestMethod.POST })
	public JsonResult useSave(Prove prove)
			throws Exception {
		try {

			int i = proveService.use(prove);
			if (i != -1) {
				return new JsonResult(true, "");
			}
		} catch (Exception e) {
			throw new Exception(
					"this is the detail of ajax exception information");
		}
		return new JsonResult(false, "编辑失败！");
	}
	
	/** 单条删除*/
	@ResponseBody
	@RequestMapping(value = "/delete")
	public JsonResult delete(String id) {
		int i = proveService.delete(id);
		if (i > 0) {
			return new JsonResult(true, "");
		}
		return new JsonResult(false, "删除失败！");
	}
}
