package zhinan.liang.interceptorS;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.drools.compiler.lang.DroolsSoftKeywords.RESULT;

/**
 * Created by liang on 2016/6/20.
 */
public class Myinterceptor extends AbstractInterceptor {
    private static final Logger logger = LogManager.getLogger(Myinterceptor.class);
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        long start=System.currentTimeMillis();
        actionInvocation.invoke();//让程序继续走
        long end=System.currentTimeMillis();
        System.out.println("使用时间："+(end-start)+"秒");
        logger.info("info","使用时间："+(end-start)+"秒");
        return RESULT;
    }
}
