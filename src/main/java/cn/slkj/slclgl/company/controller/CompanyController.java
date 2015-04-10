package cn.slkj.slclgl.company.controller;

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
import cn.slkj.easyui.util.Tree;
import cn.slkj.slclgl.company.bean.Company;
import cn.slkj.slclgl.company.service.CompanyService;

/**
 * @ClassName: 公司/车队companyController
 * @author maxh
 * @date 2014年10月23日 上午10:52:39
 * 
 */
@Controller
@RequestMapping(value = "/company")
public class CompanyController {
	private static Logger log = LoggerFactory.getLogger(CompanyController.class);
	@Resource
	private CompanyService companyService;

	/**
	 * 
	 * @param page
	 * @param rows
	 * @param gsmc
	 * @param location
	 * @param session
	 * @return 返回easyUI datagrid 数据格式
	 */
	@ResponseBody
	@RequestMapping(value = "/list")
	public EPager<Company> list(HttpServletRequest request) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		map.put("endNum", page * rows);
		map.put("startNum", (page - 1) * rows);
		int total = companyService.getAllCount(map);
		List<Company> list = companyService.getAll(map);
		return new EPager<Company>(total, list);
	}

	@RequestMapping(value ="getTreeList")
	@ResponseBody
	public List<Tree> getCombotree(HttpServletRequest request) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		return companyService.getComTree(map);
	}

	@ResponseBody
	@RequestMapping(value = "/queryComList")
	public List<Company> queryComList() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		return companyService.queryComList(map);
	}

	/**
	 * 获取公司/车队实体
	 * 
	 * @param classification
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryOne")
	public Company queryOne(String id) {
		return companyService.queryOne(id);
	}

	/** 保存公司/车队 */
	@ResponseBody
	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public boolean save(Company company) throws Exception {
		try {
			int i = companyService.save(company);
			if (i > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/** 编辑保存 */
	@ResponseBody
	@RequestMapping(value = "/editCompany")
	public boolean editCompany(Company company) throws Exception {
		try {
			int i = companyService.edit(company);
			if (i > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/** 批量删除 */
	@ResponseBody
	@RequestMapping(value = "/delete")
	public boolean deletes(String id) {
		int i = companyService.delete(id);
		try {
			if (i > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}
