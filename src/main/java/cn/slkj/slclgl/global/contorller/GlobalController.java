package cn.slkj.slclgl.global.contorller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.slkj.easyui.util.EPager;
import cn.slkj.easyui.util.JsonResult;
import cn.slkj.slclgl.global.bean.Global;
import cn.slkj.slclgl.global.service.GlobalService;

/**
 * 卫星定位服务
 * 
 * @author maxh
 *
 */
@Controller
@RequestMapping(value = "/global")
public class GlobalController {
	@Resource
	private GlobalService globalService;

	@ResponseBody
	@RequestMapping(value = "/list")
	public EPager<Global> list(
			@RequestParam(required = false, defaultValue = "1") Integer page,// 第几页
			@RequestParam(required = false, defaultValue = "15") Integer rows,// 每页显示多少行
			String carNumber, String companName,
			@RequestParam(required = false, defaultValue = "") String endDate,
			@RequestParam(required = false, defaultValue = "") String endDate1, HttpSession session)
			throws UnsupportedEncodingException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(carNumber)) {
			map.put("carNumber", carNumber);
		}
		if (StringUtils.isNotBlank(companName)) {
			map.put("companName", companName);
		}
		if (StringUtils.isNotBlank(endDate)) {
			map.put("endDate", endDate);
		}
		if (StringUtils.isNotBlank(endDate1)) {
			map.put("endDate1", endDate1);
		}
		map.put("endNum", page * rows);
		map.put("startNum", (page - 1) * rows);

		return globalService.queryResultPager(map);

	}

	/**
	 * 查询到期车辆
	 */
	@ResponseBody
	@RequestMapping(value = "/getExpires", method = { RequestMethod.POST, RequestMethod.GET })
	public EPager<Global> getExpires(
			@RequestParam(required = false, defaultValue = "1") Integer page,// 第几页
			@RequestParam(required = false, defaultValue = "10") Integer rows,// 每页显示多少行
			HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("endNum", page * rows);
		map.put("startNum", (page - 1) * rows);
		return globalService.getExpires(map);
	}

	/**
	 * 获取实体
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryOne")
	public Global queryOne(String id) {
		Global global = new Global();
		global.setId(id);
		return globalService.queryOne(global);
	}

	/**
	 * 添加
	 * 
	 * @param global
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveGlobal", method = { RequestMethod.POST })
	public JsonResult save(Global global) {
		try {
			// global.setId(UUID.randomUUID().toString());
			int i = globalService.save(global);
			if (i > 0) {
				return new JsonResult(true, "");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JsonResult(false, "保存失败！");
	}

	/**
	 * 编辑
	 * 
	 * @param global
	 * @return @
	 */
	@ResponseBody
	@RequestMapping(value = "/editGlobal", method = { RequestMethod.POST })
	public JsonResult editGlobal(Global global) {
		try {

			int i = globalService.edit(global);
			if (i > 0) {
				return new JsonResult(true, "");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JsonResult(false, "保存失败！");
	}

	/** 批量删除 */
	@ResponseBody
	@RequestMapping(value = "/delete")
	public boolean delete(String id) {
		int i = globalService.delete(id);
		if (i > 0) {
			return true;
		}
		return false;
	}

	@ResponseBody
	@RequestMapping(value = "/listByVid", method = { RequestMethod.POST })
	public EPager<Global> listByVid(
			@RequestParam(required = false, defaultValue = "1") Integer page,// 第几页
			@RequestParam(required = false, defaultValue = "10") Integer rows,// 每页显示多少行
			@RequestParam(required = false, defaultValue = "") String vId, String operId,
			HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(vId)) {
			map.put("vId", vId);
		}
		map.put("endNum", page * rows);
		map.put("startNum", (page - 1) * rows);
		return globalService.listByVid(map);
	}
}
