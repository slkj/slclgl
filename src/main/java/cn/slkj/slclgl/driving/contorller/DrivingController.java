package cn.slkj.slclgl.driving.contorller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.slkj.easyui.util.EPager;
import cn.slkj.slclgl.driving.bean.Driving;
import cn.slkj.slclgl.driving.service.DrivingService;
import cn.slkj.slclgl.user.bean.User;

/**
 * @ClassName: 行驶证年检
 * @author
 * @date
 * 
 */
@Controller
@RequestMapping(value = "/driving")
public class DrivingController {
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(DrivingController.class);

	@Resource
	private DrivingService drivingService;

	/**
	 * 查询行驶证年检列表
	 * 
	 * @param page
	 * @param rows
	 * @param username
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = { RequestMethod.POST })
	public EPager<Driving> list(
			@RequestParam(required = false, defaultValue = "1") Integer page,// 第几页
			@RequestParam(required = false, defaultValue = "10") Integer rows,// 每页显示多少行
			String carNumber, String regCompanyId, String vId, String operId, String endDate,
			String endDate1, HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(carNumber)) {
			map.put("carNumber", carNumber);
		}
		if (StringUtils.isNotBlank(regCompanyId)) {
			map.put("regCompanyId", regCompanyId);
		}
		if (StringUtils.isNotBlank(vId)) {
			map.put("vId", vId);
		}
		if (StringUtils.isNotBlank(endDate)) {
			map.put("endDate", endDate);
		}
		if (StringUtils.isNotBlank(endDate1)) {
			map.put("endDate1", endDate1);
		}
		/*User user = (User) session.getAttribute("userSession");
		if(user.getType().equals("2")){
			map.put("depId", user.getDepartcode());
		}
		else if(user.getType().equals("1")){
			map.put("companyId", user.getCompanyid());
		}*/
//		if (StringUtils.isNotBlank(operId)) {
//			map.put("operId", operId);
//		} else {
//			User user = (User) session.getAttribute("userSession");
//			map.put("operId", user.getU_id());
//		}
		map.put("endNum", page * rows);
		map.put("startNum", (page - 1) * rows);
		return drivingService.queryResultPager(map);
	}

	@ResponseBody
	@RequestMapping(value = "/saveDriving", method = { RequestMethod.POST })
	public boolean saveDriving(Driving driving) {
		int i = drivingService.save(driving);
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/editDriving", method = { RequestMethod.POST })
	public boolean editDriving(Driving driving) {
		int i = drivingService.edit(driving);
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/listByVid", method = { RequestMethod.POST })
	public EPager<Driving> listByVid(
			@RequestParam(required = false, defaultValue = "1") Integer page,// 第几页
			@RequestParam(required = false, defaultValue = "10") Integer rows,// 每页显示多少行
			@RequestParam(required = false, defaultValue = "") String vId, String operId,
			HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(vId)) {
			map.put("vId", vId);
		}
		/*if (StringUtils.isNotBlank(operId)) {
			map.put("operId", operId);
		} else {
			User user = (User) session.getAttribute("userSession");
			map.put("operId", user.getU_id());
		}*/
		map.put("endNum", page * rows);
		map.put("startNum", (page - 1) * rows);
		return drivingService.listByVid(map);
	}

	@ResponseBody
	@RequestMapping(value = "/queryOne")
	public Driving queryOne(String id) {
		Driving driving = new Driving();
		driving.setId(id);
		return drivingService.queryOne(driving);
	}

	@ResponseBody
	@RequestMapping(value = "/delete")
	public boolean delete(String id) {
		int i = drivingService.deletes(id);
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 查询到期车辆
	 */
	@ResponseBody
	@RequestMapping(value = "/getExpires", method = { RequestMethod.POST, RequestMethod.GET })
	public EPager<Driving> getExpires(@RequestParam(required = false, defaultValue = "1") Integer page,// 第几页
			@RequestParam(required = false, defaultValue = "10") Integer rows,// 每页显示多少行
			HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		/*User user = (User) session.getAttribute("userSession");
		if(user.getType().equals("2")){
			map.put("depId", user.getDepartcode());
		}
		else if(user.getType().equals("1")){
			map.put("companyId", user.getCompanyid());
		}*/
		map.put("endNum", page * rows);
		map.put("startNum", (page - 1) * rows);
		return drivingService.getExpires(map);
	}
}
