package cn.slkj.slclgl.role.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.slkj.slclgl.role.bean.Role;
import cn.slkj.slclgl.role.mapper.RoleMapper;
@Repository
public class RoleService {
	@Autowired
	private RoleMapper mapper;
	
	public List<Role> getAll(Map<String, Object> map) {
		return mapper.getAll(map);
	}
	public int getAllCount(Map<String, Object> map) {
		return mapper.getAllCount(map);
	}
	/**
	 * 
	 * @Title: queryByid
	 * @Description: 根据角色id查询
	 * @param role
	 * @return Role 返回类型
	 */
	public Role queryByid(String id) {
		return mapper.queryByid(id);
	};

	/**
	 * 
	 * @Title: editRole
	 * @Description: 编辑角色信息
	 * @param role
	 * @return int 返回类型
	 */
	public int editRole(Role role) {
		return mapper.editRole(role);
	}

	/**
	 * 
	 * @Title: saveRole
	 * @Description: 保存角色信息
	 * @param role
	 * @return int 返回类型
	 */
	public int saveRole(Role role) {
		return mapper.saveRole(role);
	}

	/**
	 * 
	 * @Title: deleteRole
	 * @Description: 删除角色数据
	 * @param ids
	 * @return int 返回类型
	 */
	public int deleteRole(String id) {
		return mapper.deleteRole(id);
	}
	public int saveRoleRes(String roleid, String[] ids) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("roleid", roleid);
		map.put("ids", ids);
		return mapper.saveRoleRes(map);
	}
	public int deleteRoleRes(String roleid, String[] ids) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("roleid", roleid);
		map.put("ids", ids);
		return mapper.deleteRoleRes(map);
	}

}
