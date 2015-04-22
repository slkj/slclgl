package cn.slkj.slclgl.second.contorller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
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
import cn.slkj.slclgl.second.bean.SecondInsurance;
import cn.slkj.slclgl.second.service.SecondInsuranceService;
import cn.slkj.slclgl.user.bean.User;



/**
 * 
 * @ClassName: SeoncInsuranceController
 * @Description: 二保
 * @author wangling
 * @date 2014年12月12日下午3:39:52
 */
@Controller
@RequestMapping(value = "/second")
public class SeoncInsuranceController {
	private static Logger log = LoggerFactory.getLogger(SeoncInsuranceController.class);
	@Resource
	private SecondInsuranceService secondInsuranceService;

	/**
	 * 获取实体
	 * @param insurance
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryOne")
	public SecondInsurance queryOne(SecondInsurance secondInsurance) {
		return secondInsuranceService.queryOne(secondInsurance);
	}
	
	/**
	 * 查询列表	
	 * @throws UnsupportedEncodingException 
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = { RequestMethod.POST })
	public EPager<SecondInsurance> list(
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
		return secondInsuranceService.queryResultPager(map);
	}
	/**
	 * 查询列表	
	 * @throws UnsupportedEncodingException 
	 */
	@ResponseBody
	@RequestMapping(value = "/list1", method = { RequestMethod.POST })
	public EPager<SecondInsurance> list1(
			@RequestParam(required = false, defaultValue = "1") Integer page,// 第几页
			@RequestParam(required = false, defaultValue = "10") Integer rows,// 每页显示多少行
			@RequestParam(required = false, defaultValue = "") String carnumber,
			@RequestParam(required = false, defaultValue = "") String sel,
			@RequestParam(required = false, defaultValue = "") String startDate,
			@RequestParam(required = false, defaultValue = "") String endDate,HttpSession session) throws UnsupportedEncodingException {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		/*if(session.getAttribute("userSession") != null){
			User user = (User) session.getAttribute("userSession");
			if(user.getType().equals("1")){ //非超级管理员
					map.put("companyId", user.getCompanyid());
			}
		}*/
		if (StringUtils.isNotBlank(carnumber)) {
			//carnumber = new String((carnumber).getBytes("ISO-8859-1"),"UTF-8");
			carnumber = new String((carnumber).getBytes("ISO-8859-1"),"UTF-8");
			map.put("carnumber", carnumber);
		}
		if (StringUtils.isNotBlank(sel)) {
			map.put("carnumber", sel);
		}
		if (StringUtils.isNotBlank(startDate)) {
			map.put("startDate", startDate);
		}
		if (StringUtils.isNotBlank(endDate)) {
			map.put("endDate", endDate);
		}
		map.put("endNum", page * rows);
		map.put("startNum", (page - 1) * rows);
		return secondInsuranceService.queryResultPager1(map);
	}
	
	/** 添加*/
	@ResponseBody
	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public JsonResult save(SecondInsurance secondInsurance)
			throws Exception {
		try {
			
			int i = secondInsuranceService.save(secondInsurance);
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
	public JsonResult editSave(SecondInsurance secondInsurance)
			throws Exception {
		try {

			int i = secondInsuranceService.edit(secondInsurance);
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
		int i = secondInsuranceService.delete(id);
		if (i > 0) {
			return new JsonResult(true, "");
		}
		return new JsonResult(false, "删除失败！");
	}
	/** 批量删除*/
	@ResponseBody
	@RequestMapping(value = "/deletes", method = { RequestMethod.POST })
	public JsonResult deletes(@RequestParam(value = "ids[]") String[] ids) {
		int i = secondInsuranceService.deletes(ids);
		if (i > 0) {
			return new JsonResult(true, "");
		}
		return new JsonResult(false, "删除失败！");
	}
 
	/**
	 * 查询到期车辆
	 */
	@ResponseBody
	@RequestMapping(value = "/getExpires", method = { RequestMethod.POST, RequestMethod.GET })
	public EPager<SecondInsurance> getExpires(@RequestParam(required = false, defaultValue = "1") Integer page,// 第几页
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
		return secondInsuranceService.getExpires(map);
	}
	@ResponseBody
	@RequestMapping(value = "/listByVid", method = { RequestMethod.POST })
	public EPager<SecondInsurance> listByVid(
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
		return secondInsuranceService.listByVid(map);
	}
}
