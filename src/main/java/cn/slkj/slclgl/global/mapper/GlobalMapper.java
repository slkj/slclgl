package cn.slkj.slclgl.global.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import cn.slkj.slclgl.global.bean.Global;

/**
 * 定位服务接口
 * 
 * @author maxh
 *
 */
@Repository
public interface GlobalMapper {
	/**
	 * 查询定位服务列表 和  总记录数
	 * 
	 * @param map
	 * @return
	 */
	public List<Global> queryList(HashMap<String, Object> map);

	public int queryListCount(HashMap<String, Object> map);
	/**
	 * 查询到期车辆
	 * @param map
	 * @return
	 */
	public List<Global> getExpires(HashMap<String, Object> map);

	public int getExpiresCount(HashMap<String, Object> map);
	
	/**
	 * 根据条件获取定位服务实体
	 * 
	 * @param Global
	 * @return
	 */
	public Global queryOne(Global global);

	/**
	 * 保存定位服务
	 * 
	 * @param Insurance
	 */
	public int save(Global global);

	/**
	 * 编辑定位服务
	 * 
	 * @param Insurance
	 */
	public int edit(Global global);

	/**
	 * 根据id删除定位服务记录
	 * 
	 * @param id
	 */
	public int delete(String id);
	/**
	 * 查询单个车辆安装记录
	 * 
	 * @param map
	 * @return
	 */
	public List<Global> listByVid(HashMap<String, Object> map);
	public int listByVidCount(HashMap<String, Object> map);
	

}
