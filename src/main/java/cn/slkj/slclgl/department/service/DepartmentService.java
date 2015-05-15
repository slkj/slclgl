package cn.slkj.slclgl.department.service;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.slkj.slclgl.department.bean.Department;
import cn.slkj.slclgl.department.mapper.DepartmentMapper;

/**
 * 部门管理 实现层
 * 
 * @author maxh
 *
 */
@Service
public class DepartmentService {

	private static Logger log = LoggerFactory.getLogger(DepartmentService.class);

	@Autowired
	private DepartmentMapper mapper;

	public List<Department> queryList(HashMap<String, Object> map) {
		log.info("参数: {}", map.toString());
		return mapper.queryList(map);
	}

	/**
	 * 添加
	 */
	public int save(Department department) {
		try {
			log.info("保存单个信息，参数: {}", department.toString());
			return mapper.save(department);
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * 编辑
	 */
	public int edit(Department department) {
		try {
			log.info("编辑单个信息，参数: {}", department.toString());
			return mapper.edit(department);
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * 根据id 批量记录
	 */
	public int delete(String id) {
		try {
			log.info("删除信息，参数: {}", id);
			return mapper.delete(id);
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public Department queryOne(String id) {
		return mapper.queryOne(id);
	}

}
