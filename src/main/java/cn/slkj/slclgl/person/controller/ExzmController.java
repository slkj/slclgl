package cn.slkj.slclgl.person.controller;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.slkj.easyui.util.EPager;
import cn.slkj.slclgl.person.bean.Driver_exzm;
import cn.slkj.slclgl.person.bean.Person;
import cn.slkj.slclgl.person.service.ExzmService;
import cn.slkj.slclgl.vehicle.bean.Vehicle;
@Controller
@RequestMapping(value = "/exzm")
public class ExzmController {
	@Resource
	private ExzmService service;
	
	@ResponseBody
	@RequestMapping(value = "/list")
	public EPager<Driver_exzm> list( @RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer rows,String idcard_no)
			throws Exception {
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("endNum", page * rows);
			map.put("startNum", (page - 1) * rows);
			if(StringUtils.isNotEmpty(idcard_no)){
				map.put("idcard_no", idcard_no);
			}
			int total = service.getCount(map);
			List<Driver_exzm> list = service.search(map);
			return new EPager<Driver_exzm>(total, list);
		} catch (Exception e) {
			throw new Exception(
					"this is the detail of ajax exception information");
		}
	}
	@ResponseBody
	@RequestMapping(value = "/one")
	public Driver_exzm queryOne( String id)
			throws Exception {
		try {
			Driver_exzm d=new Driver_exzm();
			d.setExzm_id(id);
			return service.One(d);
		} catch (Exception e) {
			throw new Exception(
					"this is the detail of ajax exception information");
		}
	}
	/** 添加*/
	@ResponseBody
	@RequestMapping(value = "/add", method = { RequestMethod.POST })
	public boolean save(Driver_exzm d)
			throws Exception {
		try {
			d.setExzm_id(UUID.randomUUID().toString());
			int i = service.add(d);
			if (i != -1) {
				return true;
			}
		} catch (Exception e) {
			throw new Exception(
					"this is the detail of ajax exception information");
		}
		return false;
	}
	
	/** 编辑*/
	@ResponseBody
	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public boolean editSave(Driver_exzm p)
			throws Exception {
		try {

			int i = service.edit(p);
			if (i != -1) {
				return true;
			}
		} catch (Exception e) {
			throw new Exception(
					"this is the detail of ajax exception information");
		}
		return false;
	}
	
	/** 批量删除*/
	@ResponseBody
	@RequestMapping(value = "/deletes", method = { RequestMethod.POST })
	public boolean deletes(@RequestParam(value = "ids[]") String[] ids) {
		int i = service.remove(ids);
		if (i > 0) {
			return true;
		}
		return false;
	}
}
