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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lmstudio.framework.bss.bo.BaseBo;
import com.lmstudio.framework.bss.constants.BssConstants;
import com.lmstudio.framework.bss.constants.ErrorCode;
import com.lmstudio.framework.bss.dao.IBaseJpaDao;
import com.lmstudio.framework.bss.dao.QueryResult;
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

	/**
	 * 根据JPQL语句分页查询，返回页对象
	 * 
	 * @param jpql
	 *            查询语句
	 * @param parameterMap
	 *            参数集合
	 * @param pageNo
	 *            当前页码
	 * @param pageSize
	 *            每页记录数
	 * @return
	 */
	public QueryResult<Object> findByJPQLWithPage(String jpql, Map<String, Object> parameterMap, int pageNo,
			int pageSize) {
		if (StringUtils.isBlank(jpql)) {
			throw new BssException(ErrorCode.DATA_QUERY_ERROR, "查询语句不能为空");
		}
		int start = (" " + jpql).toLowerCase().indexOf(" from ");
		int end = jpql.toLowerCase().lastIndexOf("order by");
		String countJPQL = "select count(*) " + (end < 0 ? jpql.substring(start) : jpql.substring(start, end));

		try {
			long count = this.countByJPQL(countJPQL, parameterMap);
			// 如果存在记录,才继续查询明细
			if (count > 0) {
				if (pageNo < 1) {
					pageNo = 1;
				}
				if (pageSize < 1) {
					pageSize = BssConstants.PageSize;
				}
				Query query = entityManager.createQuery(jpql);
				this.setParameters(query, parameterMap);

				// 设置查询结果的结束记录数
				query.setMaxResults(pageSize);
				// 设置查询结果的开始记录数（从0开始计数）
				int firstResult = (pageNo - 1) * pageSize;
				query.setFirstResult(firstResult);

				return new QueryResult<Object>(query.getResultList(), count, pageNo, pageSize);
			} else {
				return new QueryResult<Object>(new ArrayList<Object>(), count, pageNo, pageSize);
			}
		} catch (HibernateException ex) {
			throw new BssException(ErrorCode.DATA_QUERY_ERROR, ex);
		}
	}

	/**
	 * 根据JPQL语句（使用聚合函数count）获取记录数
	 * 
	 * @param countJPQL
	 * @param parameterMap
	 *            参数集合
	 * @return
	 */
	public int countByJPQL(String countJPQL, Map<String, Object> parameterMap) {
		try {
			Query query = entityManager.createQuery(countJPQL);
			this.setParameters(query, parameterMap);
			return Integer.parseInt(query.getSingleResult().toString());
		} catch (HibernateException ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * 内部方法，设置参数
	 * 
	 * @param query
	 * @param parameterMap
	 */
	private void setParameters(Query query, Map<String, Object> parameterMap) {
		if (parameterMap != null) {
			for (String parameterName : parameterMap.keySet()) {
				Object parameterValue = parameterMap.get(parameterName);
				query.setParameter(parameterName, parameterValue);
			}
		}
	}

}
