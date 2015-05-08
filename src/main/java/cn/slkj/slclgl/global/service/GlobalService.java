package cn.slkj.slclgl.global.service;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.slkj.easyui.util.EPager;
import cn.slkj.slclgl.global.bean.Global;
import cn.slkj.slclgl.global.mapper.GlobalMapper;
import cn.slkj.slclgl.insurance.bean.Insurance;

/**
 * 定位服务方法
 * 
 * @author maxh
 *
 */
@Service
public class GlobalService {

	private static Logger log = LoggerFactory.getLogger(GlobalService.class);

	@Autowired
	private GlobalMapper mapper;

	/**
	 * 查询到期记录
	 * 
	 * @param map
	 * @return
	 */
	public EPager<Global> getExpires(HashMap<String, Object> map) {
		log.info("查询分页类信息，参数: {}", map);
		return new EPager<Global>(mapper.getExpiresCount(map), mapper.getExpires(map));
	}
	/**
	 * 查询分页记录
	 * 
	 * @param map
	 * @return
	 */
	public EPager<Global> queryResultPager(HashMap<String, Object> map) {
		log.info("查询分页类信息，参数: {}", map);
		return new EPager<Global>(mapper.queryListCount(map), mapper.queryList(map));
	}
	/**
	 * 根据条件获取定位服务实体
	 * 
	 * @return
	 */
	public Global queryOne(Global global) {
		log.info("查询单个信息，参数: {}", global.toString());
		try {
			return mapper.queryOne(global);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 添加定位服务
	 */
	public int save(Global global) {
		try {
			log.info("保存单个信息，参数: {}", global.toString());
			return mapper.save(global);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * 编辑定位服务
	 * 
	 * @param Agent
	 */
	public int edit(Global global) {
		try {
			log.info("编辑单个信息，参数: {}", global.toString());
			return mapper.edit(global);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * 根据ids批量删除定位服务记录
	 * 
	 * @param ids
	 */
	public int delete(String id) {
		try {
			log.info("删除信息，参数: {}", id);
			return mapper.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	/**
	 * 定位历史记录
	 * @param map
	 * @return
	 */
	public EPager<Global> listByVid(HashMap<String, Object> map) {
		return new EPager<Global>(mapper.listByVidCount(map), mapper.listByVid(map));
	}
}
