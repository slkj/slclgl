package cn.slkj.slclgl.devices.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.slkj.slclgl.devices.bean.Devices;
import cn.slkj.slclgl.devices.mapper.DevicesMapper;
import cn.slkj.slclgl.devices.service.DevicesService;

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

	public int goBack(Devices devices) {
		// TODO Auto-generated method stub
		return mapper.goBack(devices);
	}

	public int testing(Devices devices) {
		// TODO Auto-generated method stub
		return mapper.testing(devices);
	}

	public int netIn(Devices devices) {
		// TODO Auto-generated method stub
		return mapper.netIn(devices);
	}

}
