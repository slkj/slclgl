package cn.slkj.slclgl.module.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.slkj.easyui.util.Tree;
import cn.slkj.slclgl.module.bean.Module;
import cn.slkj.slclgl.module.bean.Permission;
import cn.slkj.slclgl.module.service.impl.ModuleServiceImpl;
import cn.slkj.slclgl.user.bean.User;

@Controller
@RequestMapping("/module")
public class ModuleController {
	@Autowired
	private ModuleServiceImpl moduleServiceImpl;

	@RequestMapping(value = "/queryOne/{id}")
	@ResponseBody
	public Module queryOne(@PathVariable String id) {
		return moduleServiceImpl.queryOne(id);
	}

	@RequestMapping(value = "/list")
	@ResponseBody
	public List<Module> list() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<Module> list = moduleServiceImpl.getAll(map);
		return makeTree(list);
	}

	@RequestMapping(value = "/list/user")
	@ResponseBody
	public List<Module> listByUser(String id, HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		if (StringUtils.isNotBlank(id)) {
			map.put("id", id);
		} else {
			User user = (User) session.getAttribute("userSession");
			map.put("id", user.getId());
		}

		List<Module> list = moduleServiceImpl.listByUser(map);
		return makeTree(list);
	}

	@RequestMapping(value = "/getCombotree")
	@ResponseBody
	public List<Tree> getCombotree() {
		return moduleServiceImpl.getCombotree("");
	}

	@RequestMapping(value = "/addModule", method = { RequestMethod.POST })
	@ResponseBody
	public boolean addModule(Module module) {
		int i = moduleServiceImpl.insert(module);
		if (i > 0) {
			return true;
		} else {
			return false;
		}

	}

	@RequestMapping(value = "/editModule", method = { RequestMethod.POST })
	@ResponseBody
	public boolean editModule(Module module) {
		int i = moduleServiceImpl.update(module);
		if (i > 0) {
			return true;
		} else {
			return false;
		}

	}

	@RequestMapping(value = "/deleteModule/{id}")
	@ResponseBody
	public boolean deleteModule(@PathVariable String id) {
		int i = moduleServiceImpl.delete(id);
		if (i > 0) {
			return true;
		} else {
			return false;
		}

	}

	@RequestMapping(value = "/role2Module")
	@ResponseBody
	public List<Tree> role2Module(String roleId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("roleid", roleId);
		List<Module> allList = moduleServiceImpl.getAll(map);
		List<Module> checkList = moduleServiceImpl.getModuleByRoleId(map);
		return initCheckBoxTree(allList, "0", checkList);
	}

	@RequestMapping(value = "/getPermission")
	@ResponseBody
	public List<Permission> getPermission(String id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return moduleServiceImpl.getPermission(map);
	}

	@RequestMapping(value = "/getRolePer")
	@ResponseBody
	public List<Permission> getRolePer(String roleid, String modlueid) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("roleid", roleid);
		map.put("modlueid", modlueid);
		return moduleServiceImpl.getRolePer(map);
	}

	// 将list转换为需要的json格式
	private List<Tree> initCheckBoxTree(List<Module> list, String id, List<Module> list1) {
		List<Tree> trees = new ArrayList<Tree>();
		for (Module menus : list) {
			Tree node = new Tree();
			node.setId(menus.getId());
			node.setText(menus.getName());
			// node.setIconCls(menus.getRes_icon());
			if (list1 != null) {
				// 循环判断该角色拥有的资源，如果拥有的话，设置为选择中
				for (int i = 0; i < list1.size(); i++) {
					String oid = list1.get(i).getId();
					String nid = menus.getId();
					if (oid.equals(nid)) {
						node.setChecked(true);
					}
				}
			}
			if (id.equals(menus.getParent_id())) {
				node.setChildren(initCheckBoxTree(list, node.getId(), list1));
				if (!node.getChildren().isEmpty()) {
					node.setChecked(false);
				}

				trees.add(node);
			}
		}
		return trees;
	}

	private List<Module> makeTree(List<Module> list) {
		List<Module> parent = new ArrayList<Module>();
		// get parentId = null;
		for (Module e : list) {
			if (e.getParent_id().equals("0")) {
				e.setChildren(new ArrayList<Module>(0));
				parent.add(e);
			}
		}
		list.removeAll(parent);
		makeChildren(parent, list);
		return parent;
	}

	private void makeChildren(List<Module> parent, List<Module> children) {
		if (children.isEmpty()) {
			return;
		}
		List<Module> tmp = new ArrayList<Module>();
		for (Module c1 : parent) {
			for (Module c2 : children) {
				c2.setChildren(new ArrayList<Module>(0));
				if (c1.getId().equals(c2.getParent_id())) {
					c1.getChildren().add(c2);
					tmp.add(c2);
				}
			}
		}
		children.removeAll(tmp);
		makeChildren(tmp, children);
	}
}
