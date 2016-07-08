package zhinan.liang.entitys;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zhinan.liang.daos.OrderDao;

import java.util.List;

/**
 * Created by liang on 2016/6/16.
 * hibernate jpa 测试
 */
public class OrderHibernateTest {
    private static Logger logger= LogManager.getLogger(OrderHibernateTest.class);
    @Test
    public void runtest() {

        /**
         * jpa hibernamte test
         */
        try {

            //通过Configuration获得一个SessionFactory对象
            SessionFactory sf
                    = new Configuration().configure().buildSessionFactory();
            //打开一个Session
            Session session = sf.openSession();
            //开始一个事务
            Transaction tx = session.beginTransaction();
            //创建一个Student对象
            Orders order = new Orders();
            order.setOrderId("0001");
            order.setType(1);
            order.setUnit(1);
            //通过session的save()方法将Student对象保存到数据库中
            session.save(order);
            //提交事务
            tx.commit();
            //关闭会话
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private OrderDao orderDao;
    @Test
    public void jpaDaoTest() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:application-context.xml");
        orderDao = (OrderDao)ac.getBean("orderDao");
        List<Orders> l=orderDao.orderList();
        for(Orders o:l){
            logger.info("logger-test"+o.getOrderId());
        }
    }
}