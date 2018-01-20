package com.csquare.framework.entity;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;


//Hibernate comes with n+1 problems by default, which causes multiple queries to be fired for its children.
//Solution: 1. Use HQL fetch join 2. Criteria query
public abstract class BaseJpaRepository<T, ID extends Serializable> {

    @PersistenceContext
    private EntityManager entityManager;

    private final String clazzName;

    private final Class<T> clazz;

    @SuppressWarnings("unchecked")
    public BaseJpaRepository() {
        try {
            Class<?> subClazz = getClass();
            Type sooperClazzType = subClazz.getGenericSuperclass();

            Type clazzType = ((ParameterizedType) sooperClazzType).getActualTypeArguments()[0];
            this.clazzName = clazzType.toString().split(" ")[1];
            this.clazz = (Class<T>) Class.forName(clazzName);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    // -----------------------------------------------------------------------------------------------------
    @Transactional
    public <S extends T> S save(S entity) {

        if (null == entity) {
            return entity;
        }

        if (entityManager.contains(entity)) {
            return create(entity);
        } else {
            return update(entity);
        }
    }

    @Transactional
    public <S extends T> List<S> save(Iterable<S> entities) {

        List<S> result = new ArrayList<S>(0);

        if (entities == null) {
            return result;
        }

        for (S entity : entities) {
            result.add(save(entity));
        }

        return result;
    }

    // -----------------------------------------------------------------------------------------------------
    /**
     * Inserts/Creates an Entity
     *
     * @param entity - The Object
     * @return entity - The persisted Entity Object
     */
    @Transactional
    public <S extends T> S create(S entity) {

        if (null == entity) {
            return entity;
        }

        // entityManager.joinTransaction();
        setFlushMod();
        entityManager.persist(entity);
        return entity;
    }

    /**
     * Updates Entity
     *
     * @param entity - The Object
     * @return entity - The persisted Entity Object
     */
    @Transactional
    public <S extends T> S update(S entity) {

        if (null == entity) {
            return entity;
        }

        // entityManager.joinTransaction();
        setFlushMod();
        entity = entityManager.merge(entity);
        return entity;
    }

    // -----------------------------------------------------------------------------------------------------
    /**
     * Deletes Entity
     *
     * @param entity - The Object
     */
    @Transactional
    public void delete(T entity) {

        if (null == entity) {
            return;
        }

        // entityManager.joinTransaction();
        setFlushMod();
        if (!entityManager.contains(entity)) {
            entity = entityManager.merge(entity);
        }

        entityManager.remove(entity);
    }

    /**
     * Deletes an Entity by Query
     *
     * @param clazz - The Entity Class
     * @param id - The String
     * @param canDetach - The boolean to enforce the attached entity to be detached
     */
    @Transactional
    public void delete(ID id) {

        if (null == id) {
            return;
        }

        // entityManager.joinTransaction();

        T entity = findOne(id);
        delete(entity);
    }

    /**
     * Deletes all Entities
     *
     * @param entities - The Collection<Object>
     */
    @Transactional
    public void delete(Iterable<? extends T> entities) {

        if (null == entities) {
            return;
        }

        // entityManager.joinTransaction();
        for (T entity : entities) {
            delete(entity);
        }
    }

    @Transactional
    public void deleteAll(String namedQuery) {

        List<T> entities = findAll(namedQuery);
        for (T element : entities) {
            delete(element);
        }
    }

    // -----------------------------------------------------------------------------------------------------
    /**
     * Finds an Entity by Id
     *
     * @param clazz - The Entity Class
     * @param id - The String
     * @return entity - The Entity Object
     */
    public T findOne(ID id) {

        T entity = null;
        if (null == id) {
            return entity;
        }

        entity = entityManager.find(this.clazz, id);
        return entity;
    }

    /**
     * Finds an Entity by Id
     *
     * @param clazz - The Entity Class
     * @param id - The String
     * @return entity - The Entity Object
     */
    public List<T> findAll(String namedQuery) {

        return findByHQLNamedQuery(namedQuery, null, true, -1, -1);

    }

    /**
     * Finds an Entity by Id
     *
     * @param clazz - The Entity Class
     * @param id - The String
     * @return entity - The Entity Object
     */
    public List<T> findAll(String namedQuery, int offset, int limit) {

        return findByHQLNamedQuery(namedQuery, null, true, offset, limit);

    }

    // -----------------------------------------------------------------------------------------------------

    /**
     * @param hql - String
     * @param paramsMap - HashMap
     * @param canDetach - boolean
     */
    @Transactional
    public int cudByHQL(String hql, HashMap<String, ?> paramsMap) {

        // entityManager.joinTransaction();
        Query query = entityManager.createQuery(hql);
        setQueryArgument(paramsMap, query);

        int result = query.executeUpdate();
        return result;
    }

    /**
     * Deletes an Entity by NamedQuery
     *
     * @param namedQuery - The String
     * @param paramsMap - The HashMap<String, ?>
     * @param canDetach - The boolean to enforce the attached entity to be detached
     */
    @Transactional
    public int cudByHQLNamedQuery(String namedQuery, HashMap<String, ?> paramsMap) {

        // entityManager.joinTransaction();
        Query query = entityManager.createNamedQuery(namedQuery);
        setQueryArgument(paramsMap, query);

        int result = query.executeUpdate();
        return result;
    }

    /**
     * Finds Entities by query
     *
     * @param hql - The String
     * @param paramsMap - The HashMap<String, ?>
     * @param firstRow - The integer
     * @param endRow - The integer
     * @return resultList - The List of Entity Object
     */
    public List<T> findByHQL(String hql, HashMap<String, ?> paramsMap, boolean readOnly, int offset, int limit) {

        Query query = entityManager.createQuery(hql);

        List<T> resultList = find(query, paramsMap, readOnly, offset, limit);
        return resultList;
    }

    /**
     * Finds Entities by query
     *
     * @param namedQuery - The String
     * @param paramsMap - The HashMap<String, ?>
     * @param firstRow - The integer
     * @param endRow - The integer
     * @param canDetach boolean
     * @return resultList - The List of Entity Object
     */
    public List<T> findByHQLNamedQuery(String namedQuery, HashMap<String, ?> paramsMap, boolean readOnly, int offset, int limit) {

        Query query = entityManager.createNamedQuery(namedQuery);

        List<T> resultList = find(query, paramsMap, readOnly, offset, limit);
        return resultList;
    }

    /**
     * Finds objects by native query
     *
     * @param searchQuery - The String
     * @param paramList - List
     * @param firstRow - The integer
     * @param endRow - The integer
     * @return resultList - The List of Object
     */
    public List<T> findByNativeQuery(String searchQuery, HashMap<String, ?> paramsMap, boolean readOnly, int offset, int limit) {

        Query query = entityManager.createNativeQuery(searchQuery);

        List<T> resultList = find(query, paramsMap, readOnly, offset, limit);
        return resultList;
    }

    /**
     * Attach an Entity
     *
     * @param entity - The Object
     * @return entity - The merged Entity
     */
    public T attach(T entity) {

        if (null == entity) {
            return entity;
        }

        entityManager.merge(entity);

        return entity;
    }

    /**
     * Detach an Entity
     */
    public void detach() {

        entityManager.clear();

    }

    private void setFlushMod() {

        entityManager.setFlushMode(FlushModeType.COMMIT);
    }

    @SuppressWarnings("unchecked")
    private List<T> find(Query query, HashMap<String, ?> paramsMap, boolean readOnly, int offset, int limit) {

        List<T> resultList;
        if (-1 != offset) {
            query.setFirstResult(offset);
        }

        if (-1 != limit) {
            query.setMaxResults(limit);
        }

        setQueryArgument(paramsMap, query);

        query.setHint("org.hibernate.cacheable", true);
        query.setHint("org.hibernate.readOnly", readOnly);

        resultList = query.getResultList();
        return resultList;
    }

    /**
     * Sets Arguments to the query
     *
     * @param paramsMap - The HashMap<String, ?>
     * @param query - The Query
     */
    private void setQueryArgument(HashMap<String, ?> paramsMap, Query query) {

        if (null == paramsMap || paramsMap.isEmpty()) {
            return;
        }

        Set<String> keys = paramsMap.keySet();
        for (String key : keys) {
            query.setParameter(key, paramsMap.get(key));
        }
    }

}
