package cn.slkj.slclgl.company.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.slkj.easyui.util.Tree;
import cn.slkj.slclgl.company.bean.Company;
import cn.slkj.slclgl.company.mapper.CompanyMapper;

/**
 * @ClassName: AgentService
 * @Description: 公司/车队信息
 * @author maxh
 * @date 2014年10月24日 下午2:47:33
 * 
 */
@Service
public class CompanyService {

	private static Logger log = LoggerFactory.getLogger(CompanyService.class);

	@Autowired
	private CompanyMapper mapper;

	/**
	 * 查询分页记录
	 * 
	 * @param map
	 * @return
	 */
	public List<Company> getAll(HashMap<String, Object> map) {
		return mapper.queryList(map);
	}

	public int getAllCount(HashMap<String, Object> map) {
		return mapper.queryListCount(map);
	}

	public List<Tree> getComTree(HashMap<String, Object> map) {
		List<Company> list = mapper.queryComList(map);
		return toTree(list, "0");
	}

	private List<Tree> toTree(List<Company> list, String code) {
		List<Tree> trees = new ArrayList<Tree>();
		for (Company company : list) {
			Tree node = new Tree();
			node.setId(company.getId() + "");
			node.setText(company.getCompName());
			if (code.equals(company.getbCompany())) {
//				List<Tree> children = node.getChildren();
//				if (company.getLevel() <= 4) {
//					children = new ArrayList<Tree>();
//					node.setChildren(children);
//					node.setState("closed");
//				}
				node.setChildren(toTree(list, company.getId()));
				trees.add(node);
			}

		}
		return trees;
	}

	/**
	 * 查询公司/车队列表
	 * 
	 * @param map
	 * @return
	 */
	public List<Company> queryComList(HashMap<String, Object> map) {
		return mapper.queryComList(map);
	}

	/**
	 * 添加公司/车队
	 * 
	 * @param Agent
	 */
	public int save(Company company) {
		try {
			log.info("保存单个信息，参数: {}", company.toString());
			return mapper.save(company);
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * 编辑公司/车队
	 * 
	 * @param Agent
	 */
	public int edit(Company company) {
		try {
			log.info("编辑单个信息，参数: {}", company.toString());
			return mapper.edit(company);
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * 根据ids批量删除公司/车队记录
	 * 
	 * @param ids
	 */
	public int delete(String id) {
		try {
			log.info("批量删除信息，参数: {}", id);
			return mapper.delete(id);
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * 根据id查询公司信息
	 * 
	 * @param id
	 * @return
	 */
	public Company queryOne(String id) {
		return mapper.queryOne(id);
	}

}
