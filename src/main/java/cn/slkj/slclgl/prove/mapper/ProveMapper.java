package cn.slkj.slclgl.prove.mapper;

import java.util.List;
import java.util.Map;

import cn.slkj.slclgl.prove.bean.Prove;

public interface ProveMapper {
	List<Prove> getAll(Map<String, Object> map);

	int getAllCount(Map<String, Object> map);
	/**
	 * 根据id获取
	 * @param Insurance
	 * @return
	 */
	public Prove queryOne(Prove prove);
	
	/**
	 * 保存
	 * @param Insurance
	 */
	public int save(Prove prove);
	
	/**
	 * 编辑
	 * @param Insurance
	 */
	public int edit(Prove prove);
	/**
	 * 使用
	 * @param Insurance
	 */
	public int use(Prove prove);
	
	
	/**
	 * 根据id删除
	 * @param id
	 */
	public int delete(String id);
	

}
