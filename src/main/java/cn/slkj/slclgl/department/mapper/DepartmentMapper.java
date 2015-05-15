package cn.slkj.slclgl.department.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.slkj.slclgl.department.bean.Department;

/**
 * 部门管理 dao
 * @author maxh
 *
 */
@Repository
public interface DepartmentMapper {
 

	/**
	 * 查询列表
	 * @param map
	 * @return
	 */

	List<Department> queryList(HashMap<String, Object> map);
	/**
	 *  根据id查询
	 * @param id
	 * @return
	 */
	Department queryOne(String id);
	/**
	 * 添加 
	 * 
	 */
	int save(Department department);

	/**
	 * 编辑 
	 * 
	 */
	int edit(Department department);

	/**
	 * 根据id删除记录
	 */

	int delete(String id);


}
