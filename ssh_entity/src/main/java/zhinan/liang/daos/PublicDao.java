package zhinan.liang.daos;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by liang on 2016/6/1.
 */
public interface PublicDao<T extends Serializable, PK extends Serializable> {
    /**
     * 根据主键获取实体。如果没有相应的实体，返回 null。
     * @param id
     * @return
     */
    T get(PK id);
    /**
     *  根据主键获取实体并加锁。如果没有相应的实体，返回 null。
     * @param id
     * @param lock
     * @return
     */
    public T getWithLock(PK id, LockMode lock);

    /**
     * 根据主键获取实体。如果没有相应的实体，抛出异常。
     * @param id
     * @return
     */
    T load(PK id);

    /**
     *  根据主键获取实体并加锁。如果没有相应的实体，抛出异常。
     * @param id
     * @param lock
     * @return
     */
    T loadWithLock(PK id, LockMode lock);

    /**
     * 获取全部实体。
     * @return
     */
    List<T> loadAll();

    /**
     *更新实体
     * @param entity
     */
    int update(T entity);

    /**
     * 更新实体并加锁
     * @param entity
     * @param lock
     */
     int updateWithLock(T entity, LockMode lock);

    /**
     * 存储实体到数据库
     * @param entity
     * @return
     */
    int save(T entity);

    /**
     * 增加或更新实体
     * @param entity
     * @return
     */
     int saveOrUpdate(T entity);

    /**
     * 增加或更新集合中的全部实体
     * @param entities
     */
    int saveOrUpdateAll(Collection<T> entities);

    /**
     * 删除指定的实体
     * @param entity
     * @return
     */
    int delete(T entity);

    /**
     * 加锁并删除指定的实体
     * @param entity
     * @param lock
     * @return
     */
    int deleteWithLock(T entity, LockMode lock);

    /**
     * 根据主键删除指定实体
     * @param id
     * @return
     */
    int deleteByKey(PK id);

    /**
     *  根据主键加锁并删除指定的实体
     * @param id
     * @param lock
     * @return
     */
    int deleteByKeyWithLock(PK id, LockMode lock);

    /**
     * 删除集合中的全部实体
     * @param entities
     * @return
     */
    int deleteAll(Collection<T> entities);

    // -------------------- HSQL ----------------------------------------------

    /**
     * 使用HSQL语句直接增加、更新、删除实体
     * @param queryString
     * @return
     */
    int bulkUpdate(String queryString);

    /**
     * 使用带参数的HSQL语句增加、更新、删除实体
     * @param queryString
     * @param values
     * @return
     */
    int bulkUpdate(String queryString, Object[] values);

    /**
     * 使用HSQL语句检索数据
     * @param queryString
     * @return
     */
    List find(String queryString);

    /**
     * 使用带参数的HSQL语句检索数据
     * @param queryString
     * @param values
     * @return
     */
    List find(String queryString, Object[] values);

    /**
     * 使用带命名的参数的HSQL语句检索数据
     * @param queryString
     * @param paramNames
     * @param values
     * @return
     */
    List findByNamedParam(String queryString, String[] paramNames,
                          Object[] values);

    /**
     * 使用命名的HSQL语句检索数据
     * @param queryName
     * @return
     */
    List findByNamedQuery(String queryName);

    /**
     * 使用带参数的命名HSQL语句检索数据
     * @param queryName
     * @param values
     * @return
     */
    List findByNamedQuery(String queryName, Object[] values);

    /**
     * 使用带命名参数的命名HSQL语句检索数据
     * @param queryName
     * @param paramNames
     * @param values
     * @return
     */
    List findByNamedQueryAndNamedParam(
            String queryName, String[] paramNames, Object[] values);

    /**
     *  使用HSQL语句检索数据，返回 Iterator
     * @param queryString
     * @return
     */
    Iterator iterate(String queryString);

    /**
     * 使用带参数HSQL语句检索数据，返回 Iterator
     * @param queryString
     * @param values
     * @return
     */
    Iterator iterate(String queryString, Object[] values);

    /**
     * 关闭检索返回的 Iterator
     * @param it
     */
    void closeIterator(Iterator it);

    // -------------------------------- Criteria ------------------------------

    /**
     * 创建与会话无关的检索标准对象
     * @return
     */
    DetachedCriteria createDetachedCriteria();

    /**
     *  创建与会话绑定的检索标准对象
     * @return
     */
    Criteria createCriteria();

    /**
     * 使用指定的检索标准检索数据
     * @param criteria
     * @return
     */
    List findByCriteria(DetachedCriteria criteria);

    /**
     * 使用指定的检索标准检索数据，返回部分记录
     * @param criteria
     * @param firstResult
     * @param maxResults
     * @return
     */
    List findByCriteria(
            DetachedCriteria criteria, int firstResult, int maxResults);

    /**
     * 使用指定的实体及属性检索（满足除主键外属性＝实体值）数据
     * @param entity
     * @param propertyNames
     * @return
     */
    List<T> findEqualByEntity(T entity, String[] propertyNames);

    /**
     * 使用指定的实体及属性(非主键)检索（满足属性 like 串实体值）数据
     * @param entity
     * @param propertyNames
     * @return
     */
    public List<T> findLikeByEntity(T entity, String[] propertyNames);

    /**
     * 使用指定的检索标准检索数据，返回指定范围的记录
     * @param criteria
     * @return
     */
    public Integer getRowCount(DetachedCriteria criteria);

    /**
     * 使用指定的检索标准检索数据，返回指定统计值
     * @param criteria
     * @param propertyName
     * @param StatName
     * @return
     */
    public Object getStatValue(DetachedCriteria criteria, String propertyName,
                               String StatName);

    // -------------------------------- Others --------------------------------

    /**
     * 加锁指定的实体
     * @param entity
     * @param lockMode
     */
    public void lock(T entity, LockMode lockMode);

    /**
     * 强制初始化指定的实体
     * @param proxy
     */
    public void initialize(Object proxy);

    /**
     * 强制立即更新缓冲数据到数据库（否则仅在事务提交时才更新）
     */
    public void flush();
}
