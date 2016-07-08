package zhinan.liang.servers.Impl;

import com.opensymphony.xwork2.inject.Inject;
import org.kie.api.KieServices;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.kie.internal.runtime.StatefulKnowledgeSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhinan.liang.daos.OrderDao;
import zhinan.liang.entitys.Orders;
import zhinan.liang.model.RuleOrder;
import zhinan.liang.servers.OrderService;

import java.util.List;

/**
 * Created by liang on 2016/6/6.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    private Orders order=new Orders();

    @Autowired
    private OrderDao orderDao;
    public boolean saveOrUpdateModel(Orders model) {
        return false;
    }

    public boolean deleteModel(Integer id) {
        return false;
    }

    public boolean saveModel(Orders model) {
        if(orderDao.save( model )==1){
            return true;
        }
        return false;
    }

    public boolean updateModel(Orders model) {
        return false;
    }

    public Orders findModel(Integer id) {
        return null;
    }
    public List<Orders> orderList(boolean[] b) {
        StatefulKnowledgeSession session=null;
        List<Orders> listOrder=orderDao.orderList();
        try {
            PublicServiceImpl.clear();
            // 执行规则
//           session = kbase.newStatefulKnowledgeSession();
            // 用于判断规则执行否

            RuleOrder ruleUse=new RuleOrder();
            ruleUse.setList(b);
            session.insert(ruleUse);
            // 用于判断规则执行否  end
            // 插入数据到规则文件中
            for (Orders order : listOrder) {
                session.insert( order );
                session.fireAllRules();
            }
        } finally {
            // 最后释放资源
            session.dispose();
        }
        return null;
    }

    /**
     * 测试查询
     * @param b
     * @return
     */
    public List<Orders> orderListByQuery(boolean[] b) {
        StatefulKnowledgeSession session=null;
        List<Orders> listOrder=orderDao.orderList();
        try {
            // 执行规则
//            session = kbase.newStatefulKnowledgeSession();
            // 用于判断规则执行否
            RuleOrder ruleUse=new RuleOrder();
            ruleUse.setList(b);
            session.insert(ruleUse);
            // 用于判断规则执行否  end
            // 插入数据到规则文件中
            for (Orders order : listOrder) {
                session.insert( order );
                session.fireAllRules();
            }
            //得到执行结果
            QueryResults queryResults=session.getQueryResults("testQueryP",
                    new Object[]{1,true});
            /*QueryResults queryResults=session.getQueryResults("testQuery");*/
            listOrder.clear();
            for(QueryResultsRow qr:queryResults){
                for(int i=0;i<b.length;i++){
                    if (b[i]==true){
                        Orders orders=(Orders)qr.get("ruleOrder"+i); //打印查询结果
                        listOrder.add(orders);
                    }
                }
                session.fireAllRules();
            }
        } finally {
            // 最后释放资源
            session.dispose();
        }
        return listOrder;
    }
    /**
     * 使用注解
     */
    @Inject
    @KSession("ksession2")
    private StatelessKieSession statelessKieSession;
    @Inject
    @KSession("ksession1")
    private KieSession kieSession;
    public List<Orders> orderListByQuery() {
        List<Orders> listOrder=orderDao.orderList();
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession( "ksession1" );
        // 插入数据到规则文件中
        for (Orders order : listOrder) {
            /*ksession.insert( order );
            ksession.fireAllRules();*/
        }
        return listOrder;
    }
}
