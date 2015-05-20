/**   
 * @Title: package-info.java 
 * @Package cn.slkj.clgl.driver.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhangtc   
 */
package cn.slkj.slclgl.person.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.slkj.slclgl.company.bean.Company;
import cn.slkj.slclgl.person.bean.Server_unit;
import cn.slkj.slclgl.person.mapper.UnitMapper;
@Service
public class UnitService{
	@Autowired
	private UnitMapper dao;
	
	public List<Server_unit> search(HashMap<String,Object> map){


		return dao.list(map);
		}
	public int getCount(HashMap<String, Object> map) {
		return dao.total(map);
	}
	public Server_unit One(Server_unit u){return dao.one(u);}
	public Server_unit OneByCard(HashMap<String,Object> map){return dao.onebycard(map);}
	public int add(Server_unit obj){
		try{return dao.insert(obj);}catch(Exception e){e.printStackTrace();return -1;}
		}
	public int remove(String ids[]){
		try{return dao.delete(ids);}catch(Exception e){e.printStackTrace();return -1;}
		}
	public int edit(Server_unit obj){
		try{return dao.update(obj);}catch(Exception e){e.printStackTrace();return -1;}
		}
}