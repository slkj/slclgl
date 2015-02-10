package cn.slkj.slclgl.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.slkj.slclgl.user.bean.User;
import cn.slkj.slclgl.user.mapper.UserMapper;
import cn.slkj.slclgl.user.service.UserService;

@Repository
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper usermapper;

	@Override
	public User login(String name, String password) {
		return null;
	}

	@Override
	public List<User> getAllUsers(Map<String, Object> map) {
		return usermapper.getAllUsers(map);
	}

	@Override
	public int getAllUsersCount(Map<String, Object> map) {
		return usermapper.getAllUsersCount(map);
	}

}
