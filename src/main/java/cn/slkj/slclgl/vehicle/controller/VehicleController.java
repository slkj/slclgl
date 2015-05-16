package cn.slkj.slclgl.vehicle.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
		pageMap.put("companyId", request.getParameter("companyId"));
		pageMap.put("listnum", request.getParameter("listnum"));
		pageMap.put("phone", request.getParameter("phone"));
		pageMap.put("carNumber", request.getParameter("carNumber"));
		pageMap.put("carUseNatu", request.getParameter("carUseNatu"));
		String sort = request.getParameter("sort");
		pageMap.put("sort", sort != null ? sort : "id");
		String order = request.getParameter("order");
		pageMap.put("order", order != null ? order : "desc");
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
	@RequestMapping(value = "/update", method = { RequestMethod.POST })
	public boolean update(Vehicle vehicle) throws Exception {
		try {
			int i = vehicleService.update(vehicle);
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
	@RequestMapping(value = "/uploadCarImg", method = { RequestMethod.POST })
	public String uploadCarImg(@RequestParam MultipartFile[] myfiles,
			HttpServletResponse response, HttpServletRequest request, @RequestParam("carNumber") String carNumber)
			throws Exception {
		String jstr = "{";
		// 如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\upload\\文件夹中
		// 这里实现文件上传操作用的是commons.io.FileUtils类,它会自动判断/upload是否存在,不存在会自动创建
//		String realPath = request.getSession().getServletContext()
//				.getRealPath("/carimg/" + carNumber);
		
		String realPath =  "D:/carimg/" + carNumber+"/";
		String originalFilename = null;
		for (int i = 0; i < myfiles.length; i++) {
			MultipartFile multipartFile = myfiles[i];
			if (!multipartFile.isEmpty()) {
				originalFilename = generateFileName(multipartFile.getOriginalFilename());
				switch (i) {
				case 0:
					jstr += "'djFile':'"+originalFilename+"'";
					break;
				case 1:
					jstr += ",'xsFile':'"+originalFilename+"'";
					break;
				case 2:
					jstr += ",'carimg':'"+originalFilename+"'";
					break;
				}
				try {
					FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), new File(
							realPath, originalFilename));
				} catch (IOException e) {
					System.out.println("文件[" + originalFilename + "]上传失败,堆栈轨迹如下");
					e.printStackTrace();
				}
			}

		}
		jstr +="}";
		return jstr;
	}

	/**
	 * 用日期和随机数格式化文件名避免冲突
	 * 
	 * @param fileName
	 * @return
	 */
	private String generateFileName(String fileName) {
		// System.out.println(fileName);
		SimpleDateFormat sf = new SimpleDateFormat("yyMMddHHmmss");
		String formatDate = sf.format(new Date());
		int random = new Random().nextInt(10000);
		int position = fileName.lastIndexOf(".");
		String extension = fileName.substring(position);
		return formatDate + random + extension;
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
		map.put("id", id);
		return vehicleService.queryOne(map);
	}
}
