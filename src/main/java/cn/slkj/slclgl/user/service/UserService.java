package cn.slkj.slclgl.user.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.slkj.slclgl.user.bean.User;

public interface UserService {

	// value 必须与Bean 属性一致！
	User login(@Param(value = "name") String name, @Param(value = "password") String password);

	List<User> getAllUsers();
}
