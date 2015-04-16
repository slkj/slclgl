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
package cn.slkj.slclgl.after.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.slkj.slclgl.after.bean.Maintain;
import cn.slkj.slclgl.after.mapper.MaintainMapper;

@Service
public class MaintainService {
	@Autowired
	private MaintainMapper dao;

	public List<Maintain> search(HashMap<String, Object> map) {
		
		return dao.list(map);
	}
	public int getCount(HashMap<String, Object> map) {
		return dao.total(map);
	}
	public Maintain One(Maintain u) {
		return dao.one(u);
	}

	public int add(Maintain obj) {
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

	public int edit(Maintain obj) {
		try {
			return dao.update(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}