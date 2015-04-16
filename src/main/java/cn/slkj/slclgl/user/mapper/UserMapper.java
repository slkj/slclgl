package cn.slkj.slclgl.user.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.slkj.slclgl.user.bean.User;

//userMapper只能传入一个参数,多个的话需要注解
public interface UserMapper {
	User login(HashMap<String, Object> hashMap);

	List<User> getAllUsers(Map<String, Object> map);

	int getAllUsersCount(Map<String, Object> map);

	User queryOne(HashMap<String, Object> hashMap);

	int save(User user);

	int delete(String id);

	int edit(User user);

	int resetPwd(String[] ids);

	int valid(HashMap<String, Object> hashMap);
}