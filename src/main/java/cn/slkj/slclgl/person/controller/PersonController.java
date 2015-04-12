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
package cn.slkj.slclgl.person.controller;

import java.util.HashMap;
import java.util.List;
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
import cn.slkj.slclgl.person.bean.Person;
import cn.slkj.slclgl.person.bean.Server_unit;
import cn.slkj.slclgl.person.service.PersonService;
import cn.slkj.slclgl.person.service.UnitService;
import cn.slkj.slclgl.user.bean.User;
import cn.slkj.slclgl.vehicle.bean.Vehicle;

@Controller
@RequestMapping(value = "/person")
public class PersonController {
	@Resource
	private PersonService service;
	@Resource
	UnitService unitservice;

	@ResponseBody
	@RequestMapping(value = "/list")
	public EPager<Person> list(@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer rows,
			@RequestParam(required = false, defaultValue = "") String idcard_no,
			@RequestParam(required = false, defaultValue = "") String qualification_no,
			@RequestParam(required = false, defaultValue = "") String qualification_type,
			@RequestParam(required = false, defaultValue = "") String fwcl,HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("endNum", page * rows);
		map.put("startNum", (page - 1) * rows);
		/*if (StringUtils.isNotEmpty(idcard_no)) {
			map.put("idcard_no", idcard_no);
		}
		User user = (User) session.getAttribute("userSession");
		if (user.getType().equals("1")) {
			map.put("depid", user.getCompanyid());
		}		
		if (StringUtils.isNotEmpty(qualification_no)) {
			map.put("qualification_no", qualification_no);
		}
		if (StringUtils.isNotEmpty(qualification_type)) {
			map.put("qualification_type", qualification_type);
		}
		if (StringUtils.isNotEmpty(fwcl)) {
			map.put("fwcl", fwcl);
		}*/
		int total = service.getCount(map);
		List<Person> list = service.search(map);
		return new EPager<Person>(total, list);
	}

	@ResponseBody
	@RequestMapping(value = "/one")
	public Person queryOne(String id) throws Exception {
		try {
			Person p = new Person();
			p.setId(id);
			return service.One(p);
		} catch (Exception e) {
			throw new Exception("this is the detail of ajax exception information");
		}
	}

	/** 添加 */
	@ResponseBody
	@RequestMapping(value = "/add", method = { RequestMethod.POST })
	public boolean save(Person p) throws Exception {
		try {
			p.setId(UUID.randomUUID().toString());

			if (!StringUtils.isNotBlank(p.getPhoto())) {
				p.setPhoto("default.jpg");
			}
			if (StringUtils.isNotBlank(p.getDriver_begin_time())) {
				String begin=p.getDriver_begin_time();
				p.setDriver_end_time(Integer.parseInt(begin.substring(0,4))
						+Integer.parseInt(p.getDriver_years())+begin.substring(4));
				
			}	
			if(StringUtils.isNotBlank(p.getUnit_name())){
			Server_unit unit=new Server_unit();
			unit.setUnit_id(UUID.randomUUID().toString());
			unit.setIdcard_no(p.getIdcard_no());
			unit.setUnit_address(p.getUnit_address());
			unit.setUnit_name(p.getUnit_name());
			unit.setUnit_tel(p.getUnit_tel());
			unit.setUnit_time(p.getUnit_time());
			unitservice.add(unit);
			}
			int i = service.add(p);
			
			if (i != -1) {
				return true;
			}
		} catch (Exception e) {
			throw new Exception("this is the detail of ajax exception information");
		}
		return false;
	}

	/** 编辑 */
	@ResponseBody
	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public boolean editSave(Person p) throws Exception {
		try {
			if (StringUtils.isNotBlank(p.getDriver_begin_time())) {
				String begin=p.getDriver_begin_time();
				p.setDriver_end_time(Integer.parseInt(begin.substring(0,4))
						+Integer.parseInt(p.getDriver_years())+begin.substring(4));
				
			}	
			if(StringUtils.isNotBlank(p.getUnit_name())){
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("idcard_no", p.getIdcard_no());
			Server_unit unit=unitservice.OneByCard(map);
			if(unit==null){
				unit=new Server_unit();
			unit.setUnit_id(UUID.randomUUID().toString());
			unit.setIdcard_no(p.getIdcard_no());
			unit.setUnit_address(p.getUnit_address());
			unit.setUnit_name(p.getUnit_name());
			unit.setUnit_tel(p.getUnit_tel());
			unit.setUnit_time(p.getUnit_time());
			unitservice.add(unit);
			}
			else{
				unit.setIdcard_no(p.getIdcard_no());
				unit.setUnit_address(p.getUnit_address());
				unit.setUnit_name(p.getUnit_name());
				unit.setUnit_tel(p.getUnit_tel());
				unit.setUnit_time(p.getUnit_time());
				unitservice.edit(unit);
			}
			}
			int i = service.edit(p);
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
}