package cn.slkj.slclgl.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.slkj.slclgl.user.bean.User;
import cn.slkj.slclgl.user.mapper.UserMapper;

@Repository
public class UserServiceImpl{
	@Autowired
	private UserMapper usermapper;

	public User login(HashMap<String, Object> hashMap) {
		return usermapper.login(hashMap);
	}

	public List<User> getAllUsers(Map<String, Object> map) {
		return usermapper.getAllUsers(map);
	}

	public int getAllUsersCount(Map<String, Object> map) {
		return usermapper.getAllUsersCount(map);
	}
	
	public User queryOne(HashMap<String, Object> hashMap) {
		return usermapper.queryOne(hashMap);
	}
	public int save(User user) {
		return usermapper.save(user);
	}

}
