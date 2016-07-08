package entitys;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zhinan.liang.servers.StudentService;

/**
 * Created by liang on 2016/6/21.
 */

public class TestService {
    private static final Logger logger = LogManager.getLogger(TestService.class);
    /*@Autowired
    private StudentService studentService;
    @Before
    public void before(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("application-context.xml");
       *//* studentService = (StudentService)ac.getBean("studentService");*//*
    }
    @Test
    public void runtest(){
        studentService.findAllStudent();
    }*/
    private StudentService studentService;
    @Before
    public void before(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:application-context.xml");
        studentService = (StudentService)ac.getBean("studentService");
    }
    @Test
    public void runtest(){
        studentService.findAllStudent();
        logger.info("test success");
    }
}
