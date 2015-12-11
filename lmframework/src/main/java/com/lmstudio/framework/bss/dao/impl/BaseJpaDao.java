/**
* TODO
* @Project: lmframework
* @Title: BaseJpaDao.java
* @Package com.lmstudio.framework.bss.dao.impl
* @author jason.liu
* @Date 2015年10月20日 下午5:19:03
* @Copyright
* @Version 
*/
package com.lmstudio.framework.bss.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lmstudio.framework.bss.bo.BaseBo;
import com.lmstudio.framework.bss.constants.ErrorCode;
import com.lmstudio.framework.bss.dao.IBaseJpaDao;
import com.lmstudio.framework.bss.exception.BssException;

/**
 * TODO
 * 
 * @ClassName: BaseJpaDao
 * @author json.liu
 */
@Repository(value = "baseDao")
public class BaseJpaDao implements IBaseJpaDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void persist(Object obj) {
		this.entityManager.persist(obj);
	}

	@Transactional(readOnly = false)
	public <T extends BaseBo> void persist(T entity) {
		entityManager.persist(entity);
	}

	@Transactional(readOnly = false)
	public <T extends BaseBo> void merge(T entity) {
		entityManager.merge(entity);
	}

	@Transactional(readOnly = false)
	public <T extends BaseBo> void remove(T entity) {
		entityManager.remove(entity);
	}

	@Transactional(readOnly = false)
	public <T extends BaseBo> void removeById(Class<T> entityClass, Object entityid) {
		remove(entityManager.find(entityClass, entityid));
	}

	public <T extends BaseBo> T findById(Class<T> entityClass, Object entityId) {
		return entityManager.find(entityClass, entityId);
	}

	/**
	 * 根据查询语句及参数得到唯一的查询结果。
	 * 
	 * @param entityClass
	 *            结果实体类型
	 * @param ql
	 *            查询语句
	 * @param params
	 *            查询参数，参数可以是数组或者Map，null表示没有参数
	 * @return 查询结果列表
	 */
	@SuppressWarnings("rawtypes")
	public <T> T findSingleByQL(Class<T> entityClass, String ql, Object params) {
		Query query = this.entityManager.createQuery(ql);
		QLBuilder.setQueryParams(query, params);
		List list = query.getResultList();

		if (list == null || list.size() < 1) {
			return null;
		} else if (list.size() == 1) {
			return (T) list.get(0);
		} else {
			throw new BssException(ErrorCode.DATA_QUERY_ERROR, "The query result is more than one.");
		}
	}

	@SuppressWarnings("rawtypes")
	public List findListByQL(String ql, Map params) {
		return findListByQLImpl(ql, params);
	}

	@SuppressWarnings("rawtypes")
	public List findListByQL(String ql, Object... params) {
		return findListByQLImpl(ql, params);
	}

	/**
	 * 根据查询语句及数组参数得到查询列表。
	 * 
	 * @param ql
	 *            查询语句
	 * @param params
	 *            查询参数，参数可以是数组或List，null表示没有参数
	 * @return 查询结果列表
	 */
	@SuppressWarnings("rawtypes")
	private List findListByQLImpl(String ql, Object params) {
		Query query = this.entityManager.createQuery(ql);
		QLBuilder.setQueryParams(query, params);
		return query.getResultList();
	}

}
