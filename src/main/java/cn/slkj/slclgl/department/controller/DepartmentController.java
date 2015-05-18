package cn.slkj.slclgl.department.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.slkj.easyui.util.JsonResult;
import cn.slkj.easyui.util.Tree;
import cn.slkj.slclgl.department.bean.Department;
import cn.slkj.slclgl.department.service.DepartmentService;
/**
 * 部门管理 控制层
 * @author maxh
 *
 */
@Controller
@RequestMapping(value = "/dep")
public class DepartmentController {
	private static Logger log = LoggerFactory.getLogger(DepartmentController.class);
	@Resource
	private DepartmentService departmentService;

	 
	
	//获取实体
	@ResponseBody
	@RequestMapping(value = "/queryOneDep")
	public Department queryOne(String id) {
		return departmentService.queryOne(id);
	}
	/// 保存
	@ResponseBody
	@RequestMapping(value = "/saveDep", method = { RequestMethod.POST })
	public JsonResult saveDep(Department department) throws Exception {
		try {
			int i = departmentService.save(department);
			if (i != -1) {
				return new JsonResult(true, "");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JsonResult(false, "保存失败！");
	}

	//编辑
	@ResponseBody
	@RequestMapping(value = "/editDep")
	public JsonResult editDep(Department department) throws Exception {
		try {
			int i = departmentService.edit(department);
			if (i != -1) {
				return new JsonResult(true, "");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JsonResult(false, "编辑失败！");
	}

	//删除
	@ResponseBody
	@RequestMapping(value = "/delDep")
	public JsonResult delDep(String id) {
		int i = departmentService.delete(id);
		if (i > 0) {
			return new JsonResult(true, "");
		}
		return new JsonResult(false, "删除失败！");
	}
	//查询树
	@ResponseBody
	@RequestMapping(value = "/getDepTree")
	public List<Tree> getComTree() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<Department> list = departmentService.queryList(map);
		return toTree(list, "0");
	}
	//组装树
	private List<Tree> toTree(List<Department> list, String code) {
		List<Tree> trees = new ArrayList<Tree>();
		for (Department c : list) {
			Tree t = new Tree();
			t.setId(c.getId() + "");
			t.setText(c.getD_name());
			t.setAttributes(c);
			if (code.equals(c.getParentid())) {
				t.setChildren(toTree(list, c.getId()));
				trees.add(t);
			}
		}
		return trees;
	}
}
