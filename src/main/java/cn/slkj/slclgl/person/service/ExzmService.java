package cn.slkj.slclgl.person.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.slkj.slclgl.company.bean.Company;
import cn.slkj.slclgl.person.bean.Driver_exzm;
import cn.slkj.slclgl.person.mapper.ExzmDao;
@Service
public class ExzmService {
	@Autowired
	private ExzmDao dao;
	public List<Driver_exzm> search(HashMap<String, Object> map){
		
		return dao.list(map);
		}
	public int getCount(HashMap<String, Object> map) {
		return dao.total(map);
	}
	public Driver_exzm One(Driver_exzm u){return dao.one(u);}
	public int add(Driver_exzm obj){
		try{return dao.insert(obj);}catch(Exception e){e.printStackTrace();return -1;}
		}
	public int remove(String ids[]){
		try{return dao.delete(ids);}catch(Exception e){e.printStackTrace();return -1;}
		}
	public int edit(Driver_exzm obj){
		try{return dao.update(obj);}catch(Exception e){e.printStackTrace();return -1;}
		}
}
