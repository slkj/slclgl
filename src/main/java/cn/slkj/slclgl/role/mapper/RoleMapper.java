package cn.slkj.slclgl.role.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.slkj.slclgl.role.bean.Role;

/**
 * 
* @ClassName: RoleMapper 
* @Description: 角色mapper接口
* @author maxh
* @date 2014年12月14日 上午10:14:51 
*
 */
public interface RoleMapper {

	Role queryByid(String id);

	int editRole(Role role);

	int saveRole(Role role);

	int deleteRole(String id);

	List<Role> getAll(Map<String, Object> map);

	int getAllCount(Map<String, Object> map);

	int saveRoleRes(HashMap<String, Object> map);
	int deleteRoleRes(HashMap<String, Object> map);
 
}
