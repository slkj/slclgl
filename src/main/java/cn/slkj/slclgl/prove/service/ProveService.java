package cn.slkj.slclgl.prove.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.slkj.slclgl.prove.bean.Prove;
import cn.slkj.slclgl.prove.mapper.ProveMapper;

@Repository
public class ProveService{
	@Autowired
	private ProveMapper mapper;

	
	public List<Prove> getAll(Map<String, Object> map) {
		return mapper.getAll(map);
	}

	
	public int getAllCount(Map<String, Object> map) {
		return mapper.getAllCount(map);
	}

	
	
}
