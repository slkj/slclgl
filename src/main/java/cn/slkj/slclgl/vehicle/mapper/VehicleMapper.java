package cn.slkj.slclgl.vehicle.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.slkj.slclgl.vehicle.bean.Vehicle;

/**
 * 车辆管理接口
 * 
 * @author maxh
 *
 */
@Repository
public interface VehicleMapper {
	/**
	 * 查询车辆管理列表
	 * 
	 * @param map
	 * @return
	 */
	public List<Vehicle> queryList(HashMap<String, Object> map);

	/**
	 * 查询车辆管理总记录数
	 * 
	 * @param map
	 * @return
	 */
	public int queryListCount(HashMap<String, Object> map);

	/**
	 * 根据条件获取车辆管理实体
	 * 
	 * @param vehicle
	 * @return
	 */
	public Vehicle queryOne(Vehicle vehicle);

	/**
	 * 添加车辆管理
	 * 
	 * @param vehicle
	 */
	public int save(Vehicle vehicle);

	/**
	 * 编辑车辆管理
	 * 
	 * @param vehicle
	 */
	public int edit(Vehicle vehicle);

	/**
	 * 根据ids批量删除车辆管理记录
	 * 
	 * @param id
	 */
	public int delete(String id);
}
