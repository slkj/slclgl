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
	 * @param prove
	 */
	public int edit(Prove prove);
	/**
	 * 使用
	 * @param prove
	 */
	public int use(Map<String, Object> map);
	/**
	 * 作废
	 * @param ids
	 */
	int tovoid(String[] ids);
	/**
	 * 根据id删除
	 * @param id
	 */
	public int delete(String id);
	

}
