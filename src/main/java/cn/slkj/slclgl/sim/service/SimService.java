package cn.slkj.slclgl.sim.service;

import java.util.List;
import java.util.Map;

import cn.slkj.slclgl.sim.bean.Sim;

public interface SimService {
	List<Sim> getAll(Map<String, Object> map);

	int getAllCount(Map<String, Object> map);

	int insert(Sim sim);

	List<Sim> getList(Map<String, Object> map);
}
