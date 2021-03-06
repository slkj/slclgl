/**   
 * @Title: package-info.java 
 * @Package cn.slkj.clgl.driver.dao 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhangtc   
 */
package cn.slkj.slclgl.person.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.slkj.slclgl.person.bean.Person;
@Repository
public interface PersonMapper{
	List<Person> list(HashMap<String,Object> map);
	Person one(Person obj);
	int total(HashMap<String,Object> map);
	int insert(Person obj);
	int deletes(String ids[]);
	int delete(String id);
	int update(Person obj);
}