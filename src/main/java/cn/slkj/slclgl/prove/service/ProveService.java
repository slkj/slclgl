package cn.slkj.slclgl.prove.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.slkj.slclgl.prove.bean.Prove;
import cn.slkj.slclgl.prove.mapper.ProveMapper;

@Repository
public class ProveService{
	@Autowired
	private ProveMapper mapper;

	
	public List<Prove> getAll(Map<String, Object> map) {
		return mapper.getAll(map);
	}

	
	public int getAllCount(Map<String, Object> map) {
		return mapper.getAllCount(map);
	}

	/**
	 * 根据id获取
	 * @param Agent
	 * @return
	 */
	public Prove queryOne(Prove prove) {
		
		if (prove == null) {
			return null;
		}
		try {
			return mapper.queryOne(prove);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 添加
	 * @param Agent
	 */
	public int save(Prove prove) {
		try {
			
			return mapper.save(prove);
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * 编辑
	 * @param Agent
	 */
	public int edit(Prove prove) {
		try {
			
			return mapper.edit(prove);
		} catch (Exception e) {
			return -1;
		}
	}
	/**
	 * 使用
	 * @param Agent
	 */
	public int use(Map<String, Object> map) {
		try {
			
			return mapper.use(map);
		} catch (Exception e) {e.printStackTrace();
			return -1;
		}
	}
	/**
	 * 作废
	 * @param Agent
	 */
	public int tovoid(Map<String, Object> map){
		try {
			
			return mapper.tovoid(map);
		} catch (Exception e) {
			return -1;
		}
	}


	/**
	 * 根据id删除
	 * @param id
	 */
	public int delete(String id) {
		try {
			
			return mapper.delete(id);
		} catch (Exception e) {
			return -1;
		}
	}
	
}
