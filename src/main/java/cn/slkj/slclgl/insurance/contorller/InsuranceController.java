package cn.slkj.slclgl.insurance.contorller;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

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
import cn.slkj.easyui.util.JsonResult;
import cn.slkj.slclgl.insurance.bean.Insurance;
import cn.slkj.slclgl.insurance.bean.InsuranceCompany;
import cn.slkj.slclgl.insurance.bean.InsuranceType;
import cn.slkj.slclgl.insurance.service.InsuranceService;
import cn.slkj.slclgl.user.bean.User;



/**
 * 
 * @ClassName: InsuranceController
 * @Description: 保险年检
 * @author wangling
 * @date 2014年12月12日下午3:39:52
 */
@Controller
@RequestMapping(value = "/insurance")
public class InsuranceController {
	private static Logger log = LoggerFactory.getLogger(InsuranceController.class);
	@Resource
	private InsuranceService insuranceService;

	/**
	 * 获取实体
	 * @param insurance
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryOne")
	public Insurance queryOne(Insurance insurance) {
		return insuranceService.queryOne(insurance);
	}
	
	/**
	 * 查询列表
	 * @param page
	 * @param rows
	 * @param username
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = { RequestMethod.POST })
	public EPager<Insurance> list(
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
		/*if (StringUtils.isNotBlank(operId)) {
			map.put("operId", operId);
		} else {
			User user = (User) session.getAttribute("userSession");
			map.put("operId", user.getU_id());
		}*/
		map.put("endNum", page * rows);
		map.put("startNum", (page - 1) * rows);
		return insuranceService.queryResultPager(map);
	}
	
	
	/** 添加*/
	@ResponseBody
	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public JsonResult save(Insurance insurance)
			throws Exception {
		try {
			insurance.setId(UUID.randomUUID().toString());
			int i = insuranceService.save(insurance);
			if (i != -1) {
				return new JsonResult(true, "");
			}
		} catch (Exception e) {e.printStackTrace();
			throw new Exception(
					"this is the detail of ajax exception information");
		}
		return new JsonResult(false, "保存失败！");
	}
	
	
	
	
	/** 编辑*/
	@ResponseBody
	@RequestMapping(value = "/editSave", method = { RequestMethod.POST })
	public JsonResult editSave(Insurance insurance)
			throws Exception {
		try {

			int i = insuranceService.edit(insurance);
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
		int i = insuranceService.delete(id);
		if (i > 0) {
			return new JsonResult(true, "");
		}
		return new JsonResult(false, "删除失败！");
	}
	/** 批量删除*/
	@ResponseBody
	@RequestMapping(value = "/deletes", method = { RequestMethod.POST })
	public JsonResult deletes(@RequestParam(value = "ids[]") String[] ids) {
		int i = insuranceService.deletes(ids);
		if (i > 0) {
			return new JsonResult(true, "");
		}
		return new JsonResult(false, "删除失败！");
	}
 
	
	/** 加载ComboTree*/
	@ResponseBody
	@RequestMapping(value = "/queryComboTreeOfInsuranceType")
	public List<InsuranceType> queryComboTreeOfInsuranceType() {
		try {
			
			return insuranceService.queryAllTypeList();
		} catch (Exception e) {

		}
		return null;

	}
	@ResponseBody
	@RequestMapping(value = "/queryComboTreeOfInsuranceCompany")
	public List<InsuranceCompany> queryComboTreeOfInsuranceCompany() {
		try {
			
			return insuranceService.queryAllInsuranceCompanyList();
		} catch (Exception e) {

		}
		return null;

	}
	
	/**
	 * 查询到期车辆
	 */
	@ResponseBody
	@RequestMapping(value = "/getExpires", method = { RequestMethod.POST, RequestMethod.GET })
	public EPager<Insurance> getExpires(@RequestParam(required = false, defaultValue = "1") Integer page,// 第几页
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
		return insuranceService.getExpires(map);
	}
	@ResponseBody
	@RequestMapping(value = "/listByVid", method = { RequestMethod.POST })
	public EPager<Insurance> listByVid(
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
		return insuranceService.listByVid(map);
	}
}
