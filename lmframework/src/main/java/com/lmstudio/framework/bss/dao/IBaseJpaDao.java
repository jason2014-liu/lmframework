/**
* TODO
* @Project: lmframework
* @Title: IBaseJpaDao.java
* @Package com.lmstudio.framework.bss.dao
* @author jason.liu
* @Date 2015年10月20日 下午5:18:14
* @Copyright
* @Version 
*/
package com.lmstudio.framework.bss.dao;


import java.util.List;
import java.util.Map;

import com.lmstudio.framework.bss.bo.BaseBo;

/**
 * TODO
 * 
 * @ClassName: IBaseJpaDao
 * @author json.liu
 */
public interface IBaseJpaDao {

	/**
	 * 新增实体。
	 * 
	 * @param entity
	 *            实体
	 */
	public <T extends BaseBo> void persist(T entity);

	/**
	 * 更新实体。
	 * 
	 * @param entity
	 *            实体
	 */
	public <T extends BaseBo> void merge(T entity);


	/**
	 * 删除实体。
	 * 
	 * @param entity
	 *            实体
	 */
	public <T extends BaseBo> void remove(T entity);

	/**
	 * 根据主键删除实体。
	 * 
	 * @param entityClass
	 *            实体类
	 * @param entityid
	 *            实体id
	 */
	public <T extends BaseBo> void removeById(Class<T> entityClass, Object entityid);


	/**
	 * 根据主键获取实体。
	 * 
	 * @param entityClass
	 *            实体类
	 * @param entityId
	 *            实体id
	 * @return 实体，获取不到返回null
	 */
	public <T extends BaseBo> T findById(Class<T> entityClass, Object entityId);
	
	/**
	 * 根据查询语句及参数得到唯一的查询结果。
	 * 
	 * @param entityClass
	 *            结果实体类型
	 * @param ql
	 *            查询语句
	 * @param params
	 *            查询参数 map或object[]
	 * @return 查询结果列表
	 */
	public <T> T findSingleByQL(Class<T> entityClass, String ql, Object params);
	
	
	/**
	 * 根据查询语句及参数得到查询列表。
	 * 
	 * @param ql
	 *            查询语句
	 * @param params
	 *            查询参数
	 * @return 查询结果列表
	 */
	@SuppressWarnings("rawtypes")
	public List findListByQL(String ql, Map<Object, Object> params);

	/**
	 * 根据查询语句及数组参数得到查询列表。
	 * 
	 * @param ql
	 *            查询语句
	 * @param params
	 *            查询参数
	 * @return 查询结果列表
	 */
	@SuppressWarnings("rawtypes")
	public List findListByQL(String ql, Object... params);


}
