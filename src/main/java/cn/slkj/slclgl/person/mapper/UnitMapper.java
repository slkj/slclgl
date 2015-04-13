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
package cn.slkj.slclgl.person.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.slkj.slclgl.person.bean.Server_unit;
@Repository
public interface UnitMapper{
	List<Server_unit> list(HashMap<String,Object> map);
	Server_unit one(Server_unit obj);
	Server_unit onebycard(HashMap<String,Object> map);
	int total(HashMap<String,Object> map);
	int insert(Server_unit obj);
	int delete(String ids[]);
	int update(Server_unit obj);
}