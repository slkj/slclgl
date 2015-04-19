package cn.slkj.slclgl.role.contorller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.slkj.easyui.util.EPager;
import cn.slkj.slclgl.role.bean.Role;
import cn.slkj.slclgl.role.service.RoleService;

/**
 * 
 * @ClassName: RoleController
 * @Description: 角色管理控制类
 * @author maxh
 * @date 2014年12月14日 上午10:16:51
 *
 */
@Controller
@RequestMapping(value = "/role")
public class RoleController {
	private static Logger log = LoggerFactory.getLogger(RoleController.class);
	@Resource
	private RoleService service;

	@RequestMapping("/list")
	@ResponseBody
	public EPager<Role> getAll(HttpServletRequest request) throws Exception {
		Map<String, Object> pageMap = new HashMap<String, Object>();
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		// String order =request.getParameter("order");
		// pageMap.put("order", order != null ? order : "desc");
		pageMap.put("startPage", (page - 1) * rows);
		pageMap.put("endPage", rows);
		int total = service.getAllCount(pageMap);
		List<Role> list = service.getAll(pageMap);
		return new EPager<Role>(total, list);
	}

	@ResponseBody
	@RequestMapping(value = "/queryOne")
	public Role queryOne(String id) {
		return service.queryByid(id);
	}

	@ResponseBody
	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public boolean save(Role role) throws Exception {
		try {
			int i = service.saveRole(role);
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

	@ResponseBody
	@RequestMapping(value = "/edit")
	public boolean edit(Role role) throws Exception {
		try {
			int i = service.editRole(role);
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

	@ResponseBody
	@RequestMapping(value = "/delete")
	public boolean deletes(String id) {
		int i = service.deleteRole(id);
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

	/**
	 * 保存角色和资源之间的关系
	 * 
	 * @param member
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveRoleRes", method = RequestMethod.POST)
	private boolean intoRole(@RequestParam(required = false, defaultValue = "") String roleid,
			@RequestParam(value = "ids[]") String[] ids) {
		if (StringUtils.isNotBlank(roleid)) {
			service.deleteRoleRes(roleid, ids);
			int i = service.saveRoleRes(roleid, ids);
			if (i != -1) {
				return true;
			}
		}
		log.debug("{}，角色id为空");
		return false;
	}
}
