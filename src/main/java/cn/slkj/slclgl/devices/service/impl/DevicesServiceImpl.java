package cn.slkj.slclgl.devices.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.slkj.slclgl.devices.bean.Devices;
import cn.slkj.slclgl.devices.bean.Devices_record;
import cn.slkj.slclgl.devices.mapper.DevicesMapper;
import cn.slkj.slclgl.devices.service.DevicesService;
import cn.slkj.slclgl.sim.bean.Sim;

@Repository
public class DevicesServiceImpl implements DevicesService {
	@Autowired
	private DevicesMapper mapper;

	@Override
	public List<Devices> getAll(Map<String, Object> map) {
		return mapper.getAll(map);
	}

	@Override
	public int getAllCount(Map<String, Object> map) {
		return mapper.getAllCount(map);
	}

	@Override
	public int insert(Devices devices) {
		return mapper.insert(devices);
	}

	public int outRepertory(Devices devices) {
		// TODO Auto-generated method stub
		return mapper.outRepertory(devices);
	}
	public int outRepertory(HashMap<String, Object> map) {
		return mapper.ckData(map);
	}

	public int goBack(Devices devices) {
		// TODO Auto-generated method stub
		return mapper.goBack(devices);
	}

	public int testing(Devices devices) {
		// TODO Auto-generated method stub
		return mapper.testing(devices);
	}

	public List<Devices> getList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.getList(map);
	}
	
	public int insert_record(Devices devices) {
		return mapper.insert_record(devices);
	}

	public int getAllRecordCount(Map<String, Object> pageMap) {
		// TODO Auto-generated method stub
		return mapper.getAllRecordCount(pageMap);
	}

	public List<Devices_record> getAllRecord(Map<String, Object> pageMap) {
		// TODO Auto-generated method stub
		return mapper.getAllRecord(pageMap);
	}

	public Devices queryOne(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.queryOne(map);
	}

	public int deletes(String[] ids) {
		// TODO Auto-generated method stub
		return mapper.deletes(ids);
	}
	
}
