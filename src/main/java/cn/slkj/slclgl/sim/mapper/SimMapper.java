package cn.slkj.slclgl.sim.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.slkj.slclgl.sim.bean.Sim;

public interface SimMapper {
	List<Sim> getAll(Map<String, Object> map);

	int getAllCount(Map<String, Object> map);

	List<Sim> getList(Map<String, Object> map);

	int insert(Sim sim);

	int edit(Sim sim);

	int simPay(HashMap<String, Object> map);
}
