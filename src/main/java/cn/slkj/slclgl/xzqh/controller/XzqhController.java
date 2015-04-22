package cn.slkj.slclgl.xzqh.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.slkj.slclgl.xzqh.bean.Xzqh;
import cn.slkj.slclgl.xzqh.service.XzqhService;

/**
 * 
 * @ClassName: XzqhController
 * @Description: 行政区划
 * @author maxh
 * @date 2014年7月18日 上午8:55:47
 * 
 */
@Controller
@RequestMapping(value = "/xzqh")
public class XzqhController {
	@Autowired
	private XzqhService xzqhService;

	@ResponseBody
	@RequestMapping(params = "method=queryOne")
	public Xzqh queryOne(@RequestParam(required = false, defaultValue = "") String code) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("code", code);
		return xzqhService.queryOne(map);
	}

	// 查询全国行政区代码省
	@ResponseBody
	@RequestMapping(value = "/province.do")
	public List<Xzqh> provinceCombobox() {
		return xzqhService.findProvince();
	}

	// 查询全国行政区代码市
	@ResponseBody
	@RequestMapping(value = "/city.do")
	public List<Xzqh> cityCombobox(
			@RequestParam(required = false, defaultValue = "") String province) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", province.substring(0, 2));
		map.put("code", province);
		return xzqhService.findCity(map);
	}

	// 查询全国行政区代码县区
	@ResponseBody
	@RequestMapping(value = "/county.do")
	public List<Xzqh> countyCombobox(@RequestParam(required = false, defaultValue = "") String city) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", city.substring(0, 4));
		map.put("code", city);
		return xzqhService.findCounty(map);
	}

	// 查询全国行政区代码省
	@ResponseBody
	@RequestMapping(value = "/xzqh/province.do")
	public List<Xzqh> provinceCombobox1() {
		return xzqhService.findProvince();
	}
}
