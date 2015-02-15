package cn.slkj.slclgl.devices.mapper;

import java.util.List;
import java.util.Map;

import cn.slkj.slclgl.devices.bean.Devices;

public interface DevicesMapper {
	List<Devices> getAll(Map<String, Object> map);

	int getAllCount(Map<String, Object> map);

	int insert(Devices devices);
}
