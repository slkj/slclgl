package cn.slkj.slclgl.second.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.slkj.slclgl.second.bean.SecondInsurance;

/**
 * 
 * @ClassName: SecondInsuranceMapper
 * @Description: 二保接口
 * @author wangling
 * @date 2014年12月12日下午2:39:34
 */
@Repository
public interface SecondInsuranceMapper {
	
	/**
	 * 根据条件获取保险实体
	 * @param Insurance
	 * @return
	 */
	public SecondInsurance queryOne(SecondInsurance secondInsurance);
	
	/**
	 * 保存二保记录
	 * @param Insurance
	 */
	public int save(SecondInsurance secondInsurance);
	
	/**
	 * 编辑二保记录
	 * @param Insurance
	 */
	public int edit(SecondInsurance secondInsurance);
	
	/**
	 * 根据ids批量删除二保记录
	 * @param ids
	 */
	public int deletes(String[] ids);
	/**
	 * 根据id删除二保记录
	 * @param id
	 */
	public int delete(String id);

	/**
	 * 查询二保列表
	 * @param map
	 * @return
	 */
	public List<SecondInsurance> queryList(HashMap<String, Object> map);
	
	/**
	 * 查询二保总记录数
	 * @param map
	 * @return
	 */
	public int queryListCount(HashMap<String, Object> map);
	/**
	 * 查询二保列表
	 * @param map
	 * @return
	 */
	public List<SecondInsurance> queryList1(HashMap<String, Object> map);
	
	/**
	 * 查询二保总记录数
	 * @param map
	 * @return
	 */
	public int queryListCount1(HashMap<String, Object> map);
	
	/**
	 * 查询到期车辆
	 * @param map
	 * @return
	 */
	public List<SecondInsurance> getExpires(HashMap<String, Object> map);

	public int getExpiresCount(HashMap<String, Object> map);
	/**
	 * 查询单个车辆二保记录
	 * 
	 * @param map
	 * @return
	 */
	public List<SecondInsurance> listByVid(HashMap<String, Object> map);
	public int listByVidCount(HashMap<String, Object> map);
}
