package cn.slkj.slclgl.prove.mapper;

import java.util.List;
import java.util.Map;

import cn.slkj.slclgl.prove.bean.Prove;

public interface ProveMapper {
	List<Prove> getAll(Map<String, Object> map);

	int getAllCount(Map<String, Object> map);

	

}
