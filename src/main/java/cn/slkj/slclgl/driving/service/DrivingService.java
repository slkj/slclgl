package cn.slkj.slclgl.driving.service;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.slkj.easyui.util.EPager;
import cn.slkj.slclgl.driving.bean.Driving;
import cn.slkj.slclgl.driving.mapper.DrivingMapper;
import cn.slkj.slclgl.person.bean.Person;

/**
 * 行驶证年检信息
 * 
 * @author maxh
 *
 */
@Service
public class DrivingService {

	private static Logger log = LoggerFactory.getLogger(DrivingService.class);

	@Autowired
	private DrivingMapper mapper;

	/**
	 * 根据条件获取行驶证年检实体
	 * 
	 * @param Agent
	 * @return
	 */
	@SuppressWarnings("unused")
	public Driving queryOne(Driving driving) {
		log.info("查询单个信息，参数: {}", driving.toString());
		if (driving == null) {
			return null;
		}
		try {
			return mapper.queryOne(driving);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 添加行驶证年检
	 * 
	 */
	public int save(Driving driving) {
		try {
			log.info("保存单个信息，参数: {}", driving.toString());
			return mapper.save(driving);
		} catch (Exception e) {e.printStackTrace();
			return -1;
		}
	}

	/**
	 * 编辑行驶证年检
	 * 
	 * @param Agent
	 */
	public int edit(Driving driving) {
		try {
			log.info("编辑单个信息，参数: {}", driving.toString());
			return mapper.edit(driving);
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * 根据ids批量删除行驶证年检记录
	 * 
	 * @param ids
	 */
	public int deletes(String id) {
		try {
			log.info("删除信息，参数: {}", id);
			return mapper.deletes(id);
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * 查询分页记录
	 * 
	 * @param map
	 * @return
	 */
	public EPager<Driving> queryResultPager(HashMap<String, Object> map) {
		log.info("查询分页类信息，参数: {}", map);
		return new EPager<Driving>(mapper.queryListCount(map), mapper.queryList(map));
	}

	public EPager<Driving> listByVid(HashMap<String, Object> map) {
		return new EPager<Driving>(mapper.listByVidCount(map), mapper.listByVid(map));
	}
	/**
	 * 查询到期记录
	 * 
	 * @param map
	 * @return
	 */
	public EPager<Driving> getExpires(HashMap<String, Object> map) {
		log.info("查询分页类信息，参数: {}", map);
		return new EPager<Driving>(mapper.getExpiresCount(map), mapper.getExpires(map));
	}
}
