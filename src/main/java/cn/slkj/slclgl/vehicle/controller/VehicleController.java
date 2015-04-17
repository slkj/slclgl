package cn.slkj.slclgl.vehicle.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.slkj.easyui.util.EPager;
import cn.slkj.slclgl.vehicle.bean.Vehicle;
import cn.slkj.slclgl.vehicle.service.VehicleService;

/**
 * 车辆管理VehicleController
 * 
 * @author maxh
 * 
 */
@Controller
@RequestMapping(value = "/vehicle")
public class VehicleController {
	private static Logger log = LoggerFactory.getLogger(VehicleController.class);

	@Resource
	private VehicleService vehicleService;

	/**
	 * 查询车辆管理列表
	 * 
	 * @param page
	 * @param rows
	 * @param username
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = { RequestMethod.POST })
	public EPager<Vehicle> list(HttpServletRequest request) {
		HashMap<String, Object> pageMap = new HashMap<String, Object>();
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		pageMap.put("companyName", request.getParameter("companyName"));
		pageMap.put("listnum", request.getParameter("listnum"));
		pageMap.put("phone", request.getParameter("phone"));
		pageMap.put("carNumber", request.getParameter("carNumber"));
		String sort =request.getParameter("sort");
		pageMap.put("sort", sort != null ? sort : "id");
		String order =request.getParameter("order");
		pageMap.put("order", order != null  ? order : "desc");
		pageMap.put("startPage", (page - 1) * rows);
		pageMap.put("endPage", rows);
		int total = vehicleService.getAllCount(pageMap);
		List<Vehicle> list = vehicleService.getAll(pageMap);
		return new EPager<Vehicle>(total, list);
	}

	/**
	 * 保存车辆管理
	 * 
	 * @param vehicle
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public boolean save(Vehicle vehicle) throws Exception {
		try {
			int i = vehicleService.save(vehicle);
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	@ResponseBody
	@RequestMapping(value = "/activated", method = { RequestMethod.POST })
	public boolean activated(Vehicle vehicle) {
		try {
			int i = vehicleService.activated(vehicle);
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	/** 编辑保存 */
	@ResponseBody
	@RequestMapping(value = "/editVehicle", method = { RequestMethod.POST })
	public boolean editVehicle(Vehicle vehicle) {
		try {
			int i = vehicleService.edit(vehicle);
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@ResponseBody
	@RequestMapping(value = "/delete")
	public boolean delete(String id) {
		int i = vehicleService.delete(id);
		if (i > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 获取车辆管理实体
	 * 
	 * @param classification
	 * @return
	 */

	@ResponseBody
	@RequestMapping(value = "/queryOne")
	public Vehicle queryOne(String id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id",id);
		return vehicleService.queryOne(map);
	}
}
