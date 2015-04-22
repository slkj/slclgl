package cn.slkj.slclgl.xzqh.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.slkj.slclgl.xzqh.bean.Xzqh;

/**
 * 
* @ClassName: ComboboxMapper 
* @Description: ComboboxMapper 接口
* @author maxh
* @date 2014年7月22日 上午10:50:56 
*
 */
@Repository
public interface XzqhMapper {
	
	/**
	 * 查询省市县
	 * @param map
	 * @return
	 */
	public Xzqh queryOne(HashMap<String, Object> map);
	/**
	 * 
	 * @Title: findProvince
	 * @Description: 查询省
	 * @param @return
	 * @param @throws Exception 设定文件
	 * @return List 返回类型
	 * @throws
	 */
	public List<Xzqh> findProvince();

	/**
	 * 
	 * @Title: findCity
	 * @Description: 查询市
	 * @param @param code
	 * @param @return
	 * @param @throws Exception 设定文件
	 * @return List 返回类型
	 * @throws
	 */
	public List<Xzqh> findCity(HashMap<String, Object> map);

	/**
	 * 
	 * @Title: findCounty
	 * @Description: 县区
	 * @param @param city
	 * @param @return 设定文件
	 * @return List<CareaXZQH> 返回类型
	 * @throws
	 */
	public List<Xzqh> findCounty(HashMap<String, Object> map);
	/**
	 * 根据地区代码查询，该地区和下属地区
	 * @param map
	 * @return
	 */
	public List<Xzqh> queryList(String code);
	
}
