package com.csquare.framework.search;

import java.util.HashMap;
import java.util.List;

import com.csquare.framework.util.StringUtil;


public class SearchCriteriaBuilder {

    public static String buildCriteria(String query, List<SearchCriteria> list, HashMap<String, String> paramsMap, String entityAlias) {

        StringBuilder queryBuilder = new StringBuilder(query);
        if (null != list && !list.isEmpty()) {
            StringUtil.append(queryBuilder, " where");

            for (SearchCriteria sc : list) {
                StringUtil.append(queryBuilder, " ");
                StringUtil.append(queryBuilder, entityAlias + ".");
                StringUtil.append(queryBuilder, sc.getFieldName());
                StringUtil.append(queryBuilder, "=:");
                StringUtil.append(queryBuilder, sc.getFieldName());
                StringUtil.append(queryBuilder, " ");

                paramsMap.put(sc.getFieldName(), sc.getFieldValue());

                StringUtil.append(queryBuilder, "AND");

            }

            int idxAnd = queryBuilder.lastIndexOf("AND");
            if (idxAnd > 0) {
                queryBuilder.delete(idxAnd, queryBuilder.length());
            }
        }
        return queryBuilder.toString();
    }
}
