package zhinan.liang.action;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import zhinan.liang.entitys.Flow;
import zhinan.liang.servers.FlowService;
import zhinan.liang.servers.OrderService;
import zhinan.liang.servers.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liang on 2016/6/1.
 */
@ParentPackage("basePackage")
@Namespace("/flow")
@InterceptorRef("MyTimer")
public class FlowAction extends PublicAction{
    public String getBoolValues() {
        return boolValues;
    }

    public void setBoolValues(String boolValues) {
        this.boolValues = boolValues;
    }

    private static final Logger logger = LogManager.getLogger(FlowAction.class);
    //接收对象参数
    private Flow flow=new Flow();
    private String boolValues;
    //返回json数据数据
    private Map<String, Object> dataMap;
    JSONObject jsonObject=null;

    @Autowired
    private FlowService flowService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private StudentService studentService;
    //增加数据
    @Action(value="save")
    public String save(){
        if(flowService.saveModel( flow )){
            logger.info( "添加数据成功" );
            jsonObject=new JSONObject();
            jsonObject.put("status", "添加数据成功" );
            ServletActionContext.getRequest().setAttribute("data", jsonObject.toString());
            return  SUCCESS;
        }
     return ERROR;
    }


    @Action(value="update")  // 修改数据
    public String update(){
        if(flowService.updateModel( flow )){
            jsonObject=new JSONObject();
            jsonObject.put("status", "修改数据成功" );
            jsonObject.put("value", "修改后的数据："+flowService.findModel( 1100 ) );
            ServletActionContext.getRequest().setAttribute("data", jsonObject.toString());
            return  SUCCESS;
        }
        return ERROR;
    }
    //删除功能
    @Action(value="delete")
    public String delete(){
        if(flowService.deleteModel( flow.getId() )){
            jsonObject=new JSONObject();
            logger.info( "删除数据成功" );
            jsonObject.put("status", "删除数据成功" );
            ServletActionContext.getRequest().setAttribute("data", jsonObject.toString());
            return SUCCESS;
        }
        return ERROR;
    }
    //查找功能
    @Action(value="findAll",results = {@Result(name = "success",type = "json",params = {"root","dataMap"})})
    public String findAll(){
        List<Flow> flow= flowService.findAllFlow();
        logger.info( "查询数据成功" );
        dataMap=new HashMap();
        dataMap.put("status", true);
        dataMap.put( "rows",flow );
        return SUCCESS;
    }
    //查找功能
    @Action(value="findAllGuiZe",results = {@Result(name = "success",type = "json",params = {"root","dataMap"})})
    public String findAllGuiZe(){
        studentService.findAllStudent();
        String []v=boolValues.split(",");
        boolean[] boolv=new boolean[6];
        for (int i=0;i<v.length;i++){
            boolv[i]=Boolean.parseBoolean(v[i]);
        }
       /* orderService.orderList(boolv);
        logger.info( "查询数据成功" );
        dataMap=new HashMap();
        dataMap.put("status", true);
        dataMap.put( "rows",PublicServiceImpl.getOrder());*/
        logger.info( "查询数据成功" );
        dataMap=new HashMap();
        dataMap.put("status", true);
        dataMap.put( "rows", orderService.orderListByQuery(boolv));
        return SUCCESS;
    }
    public Object getModel() {
        return flow;
    }

    public Map<String, Object> getDataMap() {
        return dataMap;
    }

}