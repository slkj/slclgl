package cn.slkj.slclgl.sim.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.slkj.slclgl.sim.bean.Sim;
import cn.slkj.slclgl.sim.mapper.SimMapper;
import cn.slkj.slclgl.sim.service.SimService;

@Repository
public class SimServiceImpl implements SimService {
	@Autowired
	private SimMapper mapper;

	@Override
	public List<Sim> getAll(Map<String, Object> map) {
		return mapper.getAll(map);
	}

	@Override
	public int getAllCount(Map<String, Object> map) {
		return mapper.getAllCount(map);
	}

	@Override
	public int insert(Sim sim) {
		return mapper.insert(sim);
	}

}
