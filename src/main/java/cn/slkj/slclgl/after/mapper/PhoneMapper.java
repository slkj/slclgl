/**   
 * @Title: package-info.java 
 * @Package cn.slkj.clgl.driver.dao 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhangtc   
 * @date 2014年12月9日 下午2:40:43 
 */
/** 
 * @ClassName: package-info 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author zhangtc
 * @date 2014年12月9日 下午2:40:43 
 *  
 */
package cn.slkj.slclgl.after.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.slkj.slclgl.after.bean.Phone;
@Repository
public interface PhoneMapper{
	List<Phone> list(HashMap<String,Object> map);
	Phone one(Phone obj);
	int total(HashMap<String,Object> map);
	int insert(Phone obj);
	int deletes(String ids[]);
	int delete(String id);
	int update(Phone obj);
}