package zhinan.liang.daos.Impl;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import javax.annotation.Resource;

/**
 * Created by liang on 2016/6/1.
 */

/**
 * 为了实现注解，需要这样做*/
public class MyHibernateDaoSupport extends HibernateDaoSupport {
    @Resource
    public void setSuperSessionFactory(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }
}
