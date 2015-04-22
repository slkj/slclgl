package cn.slkj.slclgl.driving.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.slkj.slclgl.driving.bean.Driving;

/**
 * 行驶证年检 接口
 * 
 * @author plf
 *
 */
@Repository
public interface DrivingMapper {

	/**
	 * 根据条件获取行驶证年检实体
	 * 
	 * @return
	 */
	public Driving queryOne(Driving driving);

	/**
	 * 添加行驶证年检
	 * 
	 * @param Agent
	 */
	public int save(Driving driving);

	/**
	 * 编辑行驶证年检
	 * 
	 * @param Agent
	 */
	public int edit(Driving driving);

	/**
	 * 根据ids批量删除行驶证年检记录
	 * 
	 * @param ids
	 */
	public int deletes(String id);

	/**
	 * 查询行驶证年检列表
	 * 
	 * @param map
	 * @return
	 */
	public List<Driving> queryList(HashMap<String, Object> map);

	public int queryListCount(HashMap<String, Object> map);

	

	/**
	 * 查询单个行驶证年检记录
	 * 
	 * @param map
	 * @return
	 */
	public List<Driving> listByVid(HashMap<String, Object> map);
	public int listByVidCount(HashMap<String, Object> map);
	/**
	 * 查询到期车辆
	 * @param map
	 * @return
	 */
	public List<Driving> getExpires(HashMap<String, Object> map);

	public int getExpiresCount(HashMap<String, Object> map);
}
