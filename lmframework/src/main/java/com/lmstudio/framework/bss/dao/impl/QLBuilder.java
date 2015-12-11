/**
* TODO
* @Project: lmframework
* @Title: QLBuilder.java
* @Package com.lmstudio.framework.bss.dao.impl
* @author jason.liu
* @Date 2015年10月27日 下午4:43:14
* @Copyright
* @Version 
*/
package com.lmstudio.framework.bss.dao.impl;

import java.util.Iterator;
import java.util.Map;

import javax.persistence.Query;

/**
* TODO
* @ClassName: QLBuilder
* @author json.liu
*/
public class QLBuilder {

   /**
    * 设置查询参数
   * TODO
   * @Title: setQueryParams
   * @param query
   * @param queryParams
   * @return
    */
    @SuppressWarnings("unchecked")
    public static Query setQueryParams(Query query, Object queryParams) {
        if (queryParams != null) {
            if (queryParams instanceof Object[]) {
                Object[] params = (Object[]) queryParams;
                if (params.length > 0) {
                    for (int i = 0; i < params.length; i++) {
                    		query.setParameter(i + 1, params[i]);
                    }
                }
            } else if (queryParams instanceof Map) {
                Map params = (Map) queryParams;
                Iterator<String> it = params.keySet().iterator();
                while (it.hasNext()) {
                    String key = it.next();
                    query.setParameter(key, params.get(key));
                }
            }
        }
        return query;
    }
}
