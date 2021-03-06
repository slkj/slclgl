package cn.slkj.slclgl.devices.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.slkj.slclgl.devices.bean.Devices;
import cn.slkj.slclgl.devices.bean.Devices_record;

public interface DevicesMapper {
	List<Devices> getAll(Map<String, Object> map);

	int getAllCount(Map<String, Object> map);

	int insert(Devices devices);

	int testing(Devices devices);

	int goBack(Devices devices);

	int outRepertory(Devices devices);

	List<Devices> getList(Map<String, Object> map);

	int insert_record(Devices devices);

	int getAllRecordCount(Map<String, Object> pageMap);

	List<Devices_record> getAllRecord(Map<String, Object> pageMap);

	Devices queryOne(Map<String, Object> map);

	int ckData(HashMap<String, Object> map);

	int deletes(String[] ids);

	int edit(Devices devices);

}
