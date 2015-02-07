package cn.slkj.slclgl.user.mapper;

import java.util.List;

import cn.slkj.slclgl.user.bean.User;

//userMapper只能传入一个参数,多个的话需要注解
public interface UserMapper {
	User login(String name, String password);

	List<User> getAllUsers();
}