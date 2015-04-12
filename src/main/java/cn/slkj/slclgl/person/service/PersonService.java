/**   
 * @Title: package-info.java 
 * @Package cn.slkj.clgl.driver.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhangtc   
 * @date 2014年12月9日 下午2:13:04 
 */
/** 
 * @ClassName: package-info 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author zhangtc
 * @date 2014年12月9日 下午2:13:04 
 *  
 */
package cn.slkj.slclgl.person.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.slkj.slclgl.company.bean.Company;
import cn.slkj.slclgl.person.bean.Person;
import cn.slkj.slclgl.person.mapper.PersonDao;

@Service
public class PersonService {
	@Autowired
	private PersonDao dao;

	public List<Person> search(HashMap<String, Object> map) {
		
		return dao.list(map);
	}
	public int getCount(HashMap<String, Object> map) {
		return dao.total(map);
	}
	public Person One(Person u) {
		return dao.one(u);
	}

	public int add(Person obj) {
		try {
			return dao.insert(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int remove(String ids[]) {
		try {
			return dao.deletes(ids);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	public int delete(String id) {
		try {
			return dao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int edit(Person obj) {
		try {
			return dao.update(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}