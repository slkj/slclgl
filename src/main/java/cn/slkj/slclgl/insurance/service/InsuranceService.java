package cn.slkj.slclgl.insurance.service;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.slkj.easyui.util.EPager;
import cn.slkj.slclgl.driving.bean.Driving;
import cn.slkj.slclgl.insurance.bean.Insurance;
import cn.slkj.slclgl.insurance.bean.InsuranceCompany;
import cn.slkj.slclgl.insurance.bean.InsuranceType;
import cn.slkj.slclgl.insurance.mapper.InsuranceMapper;


/**
 * 
 * @ClassName: InsuranceService
 * @Description: 保险年检方法
 * @author wangling
 * @date 2014年12月12日下午3:12:26
 */
@Service
public class InsuranceService {
	
private static Logger log = LoggerFactory.getLogger(InsuranceService.class);
	
	@Autowired
	private InsuranceMapper mapper;
	
	/**
	 * 根据条件获取保险年检实体
	 * @param Agent
	 * @return
	 */
	public Insurance queryOne(Insurance insurance) {
		log.info("查询单个信息，参数: {}", insurance.toString());
		if (insurance == null) {
			return null;
		}
		try {
			return mapper.queryOne(insurance);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 添加保险年检
	 * @param Agent
	 */
	public int save(Insurance insurance) {
		try {
			log.info("保存单个信息，参数: {}", insurance.toString());
			return mapper.save(insurance);
		} catch (Exception e) {e.printStackTrace();
			return -1;
		}
	}

	/**
	 * 编辑保险年检
	 * @param Agent
	 */
	public int edit(Insurance insurance) {
		try {
			log.info("编辑单个信息，参数: {}", insurance.toString());
			return mapper.edit(insurance);
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * 根据ids批量删除保险年检记录
	 * @param ids
	 */
	public int deletes(String[] ids) {
		try {
			log.info("批量删除信息，参数: {}", ids);
			return mapper.deletes(ids);
		} catch (Exception e) {
			return -1;
		}
	}
	/**
	 * 根据id删除保险年检记录
	 * @param id
	 */
	public int delete(String id) {
		try {
			log.info("批量删除信息，参数: {}", id);
			return mapper.delete(id);
		} catch (Exception e) {
			return -1;
		}
	}
	
	
	/**
	 * 查询分页记录
	 * @param map
	 * @return
	 */
	public EPager<Insurance> queryResultPager(HashMap<String, Object> map) {
		log.info("查询分页类信息，参数: {}", map);
		return new EPager<Insurance>(mapper.queryListCount(map), mapper.queryList(map));
	}
	
	/**
	 * 查询保险类型
	 * @param map
	 * @return
	 */
	public List<InsuranceType> queryAllTypeList() {
		return  mapper.queryAllTypeList();
	}
	/**
	 * 查询承保单位
	 * @param map
	 * @return
	 */
	public List<InsuranceCompany> queryAllInsuranceCompanyList() {
		return  mapper.queryAllInsuranceCompanyList();
	}
	/**
	 * 查询到期记录
	 * 
	 * @param map
	 * @return
	 */
	public EPager<Insurance> getExpires(HashMap<String, Object> map) {
		log.info("查询分页类信息，参数: {}", map);
		return new EPager<Insurance>(mapper.getExpiresCount(map), mapper.getExpires(map));
	}
	/**
	 * 保险历史记录
	 * @param map
	 * @return
	 */
	public EPager<Insurance> listByVid(HashMap<String, Object> map) {
		return new EPager<Insurance>(mapper.listByVidCount(map), mapper.listByVid(map));
	}
	/**
	 * 添加保险类型
	 * @param Agent
	 */
	public int saveType(InsuranceType insuranceType) {
		try {
			
			return mapper.saveType(insuranceType);
		} catch (Exception e) {e.printStackTrace();
			return -1;
		}
	}
	/**
	 * 添加保险公司
	 * @param Agent
	 */
	public int saveCompany(InsuranceCompany insuranceCompany) {
		try {
			
			return mapper.saveCompany(insuranceCompany);
		} catch (Exception e) {e.printStackTrace();
			return -1;
		}
	}
	
}
