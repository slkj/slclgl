package cn.slkj.slclgl.transport.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.slkj.slclgl.transport.bean.Transport;

/**
 * 运输证年检 接口
 * 
 * @author plf
 *
 */
@Repository
public interface TransportMapper {

	/**
	 * 根据条件获取运输证年检实体
	 * 
	 * @return
	 */
	public Transport queryOne(Transport transport);

	/**
	 * 添加运输证年检
	 * 
	 * @param Agent
	 */
	public int save(Transport transport);

	/**
	 * 编辑运输证年检
	 * 
	 * @param Agent
	 */
	public int edit(Transport transport);

	/**
	 * 根据ids批量删除运输证年检记录
	 * 
	 * @param ids
	 */
	public int deletes(String id);

	/**
	 * 查询运输证年检列表
	 * 
	 * @param map
	 * @return
	 */
	public List<Transport> queryList(HashMap<String, Object> map);

	public int queryListCount(HashMap<String, Object> map);

	

	/**
	 * 查询单个运输证年检记录
	 * 
	 * @param map
	 * @return
	 */
	public List<Transport> listByVid(HashMap<String, Object> map);
	public int listByVidCount(HashMap<String, Object> map);
	/**
	 * 查询到期车辆
	 * @param map
	 * @return
	 */
	public List<Transport> getExpires(HashMap<String, Object> map);

	public int getExpiresCount(HashMap<String, Object> map);
}
