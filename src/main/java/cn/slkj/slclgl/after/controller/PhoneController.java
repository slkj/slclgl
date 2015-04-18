/**   
 * @Title: package-info.java 
 * @Package cn.slkj.clgl.driver.contorller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhangtc   
 * @date 2014年12月9日 下午2:12:48 
 */
/** 
 * @ClassName: package-info 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author zhangtc
 * @date 2014年12月9日 下午2:12:48 
 *  
 */
package cn.slkj.slclgl.after.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.slkj.easyui.util.EPager;
import cn.slkj.slclgl.after.bean.Phone;
import cn.slkj.slclgl.after.service.PhoneService;
import cn.slkj.slclgl.person.service.UnitService;

@Controller
@RequestMapping(value = "/phone")
public class PhoneController {
	@Resource
	private PhoneService service;

	@ResponseBody
	@RequestMapping(value = "/list")
	public EPager<Phone> list(@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer rows,
			@RequestParam(required = false, defaultValue = "") String serviceMan,
			@RequestParam(required = false, defaultValue = "") String result,
			@RequestParam(required = false, defaultValue = "") String company,HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("endNum", page * rows);
		map.put("startNum", (page - 1) * rows);
		
		if (StringUtils.isNotEmpty(serviceMan)) {
			map.put("serviceMan", serviceMan);
		}
		if (StringUtils.isNotEmpty(company)) {
			map.put("company", company);
		}
		if (StringUtils.isNotEmpty(result)) {
			if(result.equals("0"))
				map.put("result", "未解决");
			if(result.equals("1"))
				map.put("result", "已解决");
		}
		int total = service.getCount(map);
		List<Phone> list = service.search(map);
		return new EPager<Phone>(total, list);
	}

	@ResponseBody
	@RequestMapping(value = "/one")
	public Phone queryOne(String id) throws Exception {
		try {
			Phone p = new Phone();
			p.setId(id);
			return service.One(p);
		} catch (Exception e) {e.printStackTrace();
			throw new Exception("this is the detail of ajax exception information");
		}
	}

	/** 添加 */
	@ResponseBody
	@RequestMapping(value = "/add", method = { RequestMethod.POST })
	public boolean save(Phone p) throws Exception {
		try {
			
			int i = service.add(p);
			
			if (i != -1) {
				return true;
			}
		} catch (Exception e) {e.printStackTrace();
			throw new Exception("this is the detail of ajax exception information");
		}
		return false;
	}

	/** 编辑 */
	@ResponseBody
	@RequestMapping(value = "/savePhone", method = { RequestMethod.POST })
	public boolean savePhone(Phone p) throws Exception {
		try {
			
			int i = service.updPhone(p);
			if (i != -1) {
				return true;
			}
		} catch (Exception e) {e.printStackTrace();
			throw new Exception("this is the detail of ajax exception information");
		}
		return false;
	}
	/** 编辑 */
	@ResponseBody
	@RequestMapping(value = "/saveService", method = { RequestMethod.POST })
	public boolean saveService(Phone p) throws Exception {
		try {
			
			int i = service.updService(p);
			if (i != -1) {
				return true;
			}
		} catch (Exception e) {e.printStackTrace();
			throw new Exception("this is the detail of ajax exception information");
		}
		return false;
	}
	/** 编辑 */
	@ResponseBody
	@RequestMapping(value = "/saveMaintain", method = { RequestMethod.POST })
	public boolean saveMaintain(Phone p) throws Exception {
		try {
			
			int i = service.updMaintain(p);
			if (i != -1) {
				return true;
			}
		} catch (Exception e) {e.printStackTrace();
			throw new Exception("this is the detail of ajax exception information");
		}
		return false;
	}

	/** 批量删除 */
	@ResponseBody
	@RequestMapping(value = "/deletes", method = { RequestMethod.POST })
	public boolean deletes(@RequestParam(value = "ids[]") String[] ids) {
		int i = service.remove(ids);
		if (i > 0) {
			return true;
		}
		return false;
	}
	/** 单条删除 */
	@ResponseBody
	@RequestMapping(value = "/delete")
	public boolean deletes(String id) {
		int i = service.delete(id);
		if (i > 0) {
			return true;
		}
		return false;
	}
	/** 单条删除 */
	@ResponseBody
	@RequestMapping(value = "/delService")
	public boolean delService(String id) {
		int i = service.delService(id);
		if (i > 0) {
			return true;
		}
		return false;
	}
}