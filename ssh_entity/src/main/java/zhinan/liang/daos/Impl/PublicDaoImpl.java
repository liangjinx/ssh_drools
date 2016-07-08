package zhinan.liang.daos.Impl;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.criterion.*;
import org.yaml.snakeyaml.introspector.PropertyUtils;
import zhinan.liang.daos.PublicDao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
/**
 * Created by liang on 2016/6/1.
 */
public class PublicDaoImpl<T extends Serializable, PK extends Serializable>
extends MyHibernateDaoSupport implements PublicDao<T,PK> {
    private Class<T> entityClass;
    // 构造方法，根据实例类自动获取实体类类型
    public PublicDaoImpl() {
        this.entityClass = null;
        Class c = getClass();
        Type t = c.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
            this.entityClass = (Class<T>) p[0];
        }
    }
//    从数据库获取数据对象，不存在的时候返回null

    public T get(PK id) {
        Class c = getClass();
        Type t = c.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
            this.entityClass = (Class<T>) p[0];
        }
        return (T)getHibernateTemplate().get(entityClass,id );
    }

    public T getWithLock(PK id, LockMode lock) {
        T t = (T) getHibernateTemplate().get(entityClass, id, lock);
        if (t != null) {
            this.flush(); // 立即刷新，否则锁不会生效。
        }
        return t;
    }
    public Criteria createCriteria() {
        return this.createDetachedCriteria().getExecutableCriteria(
                this.getSessionFactory().getCurrentSession());
    }
    public T load(PK id) {
        return (T) getHibernateTemplate().load(entityClass, id);
    }

    public T loadWithLock(PK id, LockMode lock) {
        T t = (T) getHibernateTemplate().load(entityClass, id, lock);
        if (t != null) {
            this.flush(); // 立即刷新，否则锁不会生效。
        }
        return t;
    }

    public List loadAll() {
        return (List<T>) getHibernateTemplate().loadAll(entityClass);
    }
    public int update(T entity) {
        getHibernateTemplate().update(entity);
        return 1;
    }

    public int updateWithLock(T entity, LockMode lock) {
        getHibernateTemplate().update(entity, lock);
        this.flush(); // 立即刷新，否则锁不会生效。
        return 1;
    }
    public int save(T entity) {
        // 存储实体到数据库
        getHibernateTemplate().save(entity);
        return 1;
    }
    public List findLikeByEntity(T entity, String[] propertyNames) {
        Criteria criteria = this.createCriteria();
        PropertyUtils proper=new PropertyUtils();
        for (String property : propertyNames) {
            try {
                Object value =proper.getProperty((Class<? extends Object>) entity, property);
                if (value instanceof String) {
                    criteria.add(Restrictions.like(property, (String) value,
                            MatchMode.ANYWHERE));
                    criteria.addOrder(Order.asc(property));
                } else {
                    criteria.add(Restrictions.eq(property, value));
                    criteria.addOrder(Order.asc(property));
                }
            } catch (Exception ex) {
                // 忽略无效的检索参考数据。
            }
        }
        return (List<String>) criteria.list();
    }
    public int saveOrUpdate(T entity) {
        getHibernateTemplate().saveOrUpdate(entity);
        return 1;
    }
    public int saveOrUpdateAll(Collection entities) {
        Iterator iter= entities.iterator();
        while (iter.hasNext()){
            getHibernateTemplate().saveOrUpdate(iter.next());
        }
        return 1;
    }
    public int delete(T entity) {
        getHibernateTemplate().delete(entity);
        return 1;
    }
    public int deleteWithLock(T entity, LockMode lock) {
        getHibernateTemplate().delete(entity, lock);
        this.flush(); // 立即刷新，否则锁不会生效。
        return 1;
    }
    public int deleteByKey(PK id) {
        this.delete(this.load(id));
        return 1;
    }
    public int deleteByKeyWithLock(PK id, LockMode lock) {
        this.deleteWithLock(this.load(id), lock);
        return 1;
    }
    public int deleteAll(Collection entities) {
        getHibernateTemplate().deleteAll(entities);
        return 1;
    }

    public int bulkUpdate(String queryString) {
        return getHibernateTemplate().bulkUpdate(queryString);
    }

    public int bulkUpdate(String queryString, Object[] values) {
        return getHibernateTemplate().bulkUpdate(queryString, values);
    }

    public List find(String queryString) {
        return getHibernateTemplate().find(queryString);
    }

    public List find(String queryString, Object[] values) {
        return getHibernateTemplate().find(queryString, values);
    }

    public List findByNamedParam(String queryString, String[] paramNames, Object[] values) {
        return getHibernateTemplate().findByNamedParam(queryString, paramNames,
                values);
    }

    public List findByNamedQuery(String queryName) {
        return getHibernateTemplate().findByNamedQuery(queryName);
    }

    public List findByNamedQuery(String queryName, Object[] values) {
        return getHibernateTemplate().findByNamedQuery(queryName, values);
    }

    public List findByNamedQueryAndNamedParam(String queryName, String[] paramNames, Object[] values) {
        return getHibernateTemplate().findByNamedQueryAndNamedParam(queryName,
                paramNames, values);
    }

    public Iterator iterate(String queryString) {
        return getHibernateTemplate().iterate(queryString);
    }

    public Iterator iterate(String queryString, Object[] values) {
        return getHibernateTemplate().iterate(queryString, values);
    }

    public void closeIterator(Iterator it) {
        getHibernateTemplate().closeIterator(it);
    }

    public DetachedCriteria createDetachedCriteria() {
        return DetachedCriteria.forClass(this.entityClass);
    }

    public List findByCriteria(DetachedCriteria criteria) {
        return getHibernateTemplate().findByCriteria(criteria);
    }

    public List findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults) {
        return getHibernateTemplate().findByCriteria(criteria, firstResult,
                maxResults);
    }

    public List findEqualByEntity(T entity, String[] propertyNames) {
        Criteria criteria = this.createCriteria();
        Example exam = Example.create(entity);
        exam.excludeZeroes();
        String[] defPropertys = getSessionFactory().getClassMetadata(
                entityClass).getPropertyNames();
        for (String defProperty : defPropertys) {
            int ii = 0;
            for (ii = 0; ii < propertyNames.length; ++ii) {
                if (defProperty.equals(propertyNames[ii])) {
                    criteria.addOrder(Order.asc(defProperty));
                    break;
                }
            }
            if (ii == propertyNames.length) {
                exam.excludeProperty(defProperty);
            }
        }
        criteria.add(exam);
        return (List<T>) criteria.list();
    }
    public Integer getRowCount(DetachedCriteria criteria) {
        criteria.setProjection(Projections.rowCount());
        List list = this.findByCriteria(criteria, 0, 1);
        return (Integer) list.get(0);
    }

    public Object getStatValue(DetachedCriteria criteria, String propertyName, String StatName) {
        if (StatName.toLowerCase().equals("max"))
            criteria.setProjection(Projections.max(propertyName));
        else if (StatName.toLowerCase().equals("min"))
            criteria.setProjection(Projections.min(propertyName));
        else if (StatName.toLowerCase().equals("avg"))
            criteria.setProjection(Projections.avg(propertyName));
        else if (StatName.toLowerCase().equals("sum"))
            criteria.setProjection(Projections.sum(propertyName));
        else
            return null;
        List list = this.findByCriteria(criteria, 0, 1);
        return list.get(0);
    }

    public void lock(T entity, LockMode lockMode) {
        getHibernateTemplate().lock(entity, lockMode);
    }

    public void initialize(Object proxy) {
        getHibernateTemplate().initialize(proxy);
    }

    public void flush() {
        getHibernateTemplate().flush();
    }
}
