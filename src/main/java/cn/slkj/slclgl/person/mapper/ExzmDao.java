package cn.slkj.slclgl.person.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.slkj.slclgl.person.bean.Driver_exzm;

@Repository
public interface ExzmDao {
	List<Driver_exzm> list(HashMap<String,Object> map);
	Driver_exzm one(Driver_exzm obj);
	int total(HashMap<String,Object> map);
	int insert(Driver_exzm obj);
	int delete(String ids[]);
	int update(Driver_exzm obj);
}
