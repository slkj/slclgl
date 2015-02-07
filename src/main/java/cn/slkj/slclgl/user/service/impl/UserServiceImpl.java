package cn.slkj.slclgl.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.slkj.slclgl.user.bean.User;
import cn.slkj.slclgl.user.mapper.UserMapper;
import cn.slkj.slclgl.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper usermapper;

	@Override
	public User login(String name, String password) {
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		return usermapper.getAllUsers();
	}

}
