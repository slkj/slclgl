package cn.slkj.slclgl.transport.service;

import java.util.HashMap;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.slkj.easyui.util.EPager;
import cn.slkj.slclgl.second.bean.SecondInsurance;
import cn.slkj.slclgl.transport.bean.Transport;
import cn.slkj.slclgl.transport.mapper.TransportMapper;

/**
 * 运输证年检信息
 * 
 * @author maxh
 *
 */
@Service
public class TransportService {

	private static Logger log = LoggerFactory.getLogger(TransportService.class);

	@Autowired
	private TransportMapper mapper;

	/**
	 * 根据条件获取运输证年检实体
	 * 
	 * @param Agent
	 * @return
	 */
	@SuppressWarnings("unused")
	public Transport queryOne(Transport transport) {
		log.info("查询单个信息，参数: {}", transport.toString());
		if (transport == null) {
			return null;
		}
		try {
			return mapper.queryOne(transport);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 添加运输证年检
	 * 
	 */
	public int save(Transport transport) {
		try {
			transport.setId(UUID.randomUUID().toString());
			log.info("保存单个信息，参数: {}", transport.toString());
			return mapper.save(transport);
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * 编辑运输证年检
	 * 
	 * @param Agent
	 */
	public int edit(Transport transport) {
		try {
			log.info("编辑单个信息，参数: {}", transport.toString());
			return mapper.edit(transport);
		} catch (Exception e) {e.printStackTrace();
			return -1;
		}
	}

	/**
	 * 根据ids批量删除运输证年检记录
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
	public EPager<Transport> queryResultPager(HashMap<String, Object> map) {
		log.info("查询分页类信息，参数: {}", map);
		return new EPager<Transport>(mapper.queryListCount(map), mapper.queryList(map));
	}

	public EPager<Transport> listByVid(HashMap<String, Object> map) {
		return new EPager<Transport>(mapper.listByVidCount(map), mapper.listByVid(map));
	}
	/**
	 * 查询到期记录
	 * 
	 * @param map
	 * @return
	 */
	public EPager<Transport> getExpires(HashMap<String, Object> map) {
		log.info("查询分页类信息，参数: {}", map);
		return new EPager<Transport>(mapper.getExpiresCount(map), mapper.getExpires(map));
	}
}
