package zhinan.liang;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zhinan.liang.servers.OrderService;

/**
 * Created by liang on 2016/6/30.
 */
public class Mytest {
    private static final Logger logger = LogManager.getLogger(Mytest.class);
    private OrderService orderService;
    @Before
    public void before() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:application-context.xml");
        orderService = (OrderService) ac.getBean("orderService");
    }
    @Test
    public void runtest(){
        orderService.orderListByQuery();
        logger.info("test success");
    }
}
