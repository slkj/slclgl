package cn.slkj.slclgl.xzqh.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.slkj.slclgl.xzqh.bean.Xzqh;
import cn.slkj.slclgl.xzqh.mapper.XzqhMapper;



/**
 * 
 * @ClassName: ComboboxService
 * @Description: 行政区划
 * @author maxh
 * @date 2014年7月18日 上午8:59:43
 * 
 */
@Service
public class XzqhService {
	@Autowired
	private XzqhMapper mapper;
	
	/**
	 * 查询省市县
	 * @param map
	 * @return
	 */
	public Xzqh queryOne(HashMap<String, Object> map){
		try {
			return mapper.queryOne(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @Title: findProvince
	 * @Description: 查询省 直辖市
	 * @param @return 设定文件
	 * @return List<CareaXZQH> 返回类型
	 * @throws
	 */
	public List<Xzqh> findProvince() {
		try {
			return mapper.findProvince();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @Title: findCity
	 * @Description: 根据省 直辖市级id 查询子项
	 * @param @param map
	 * @param @return 设定文件
	 * @return List<CareaXZQH> 返回类型
	 * @throws
	 */
	public List<Xzqh> findCity(HashMap<String, Object> map) {
		try {
			return mapper.findCity(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @Title: findCounty
	 * @Description: 根据市级 id 查询子项
	 * @param @param map
	 * @param @return 设定文件
	 * @return List<CareaXZQH> 返回类型
	 * @throws
	 */
	public List<Xzqh> findCounty(HashMap<String, Object> map) {
		try {
			return mapper.findCounty(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据地区代码查询，该地区和下属地区
	 * @param map
	 * @return
	 */
	public List<Xzqh> queryList(String code) {
		try {
			return mapper.queryList(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
