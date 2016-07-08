package zhinan.liang.servers.Impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhinan.liang.daos.FlowDao;
import zhinan.liang.entitys.Flow;
import zhinan.liang.servers.FlowService;

import java.util.List;

/**
 * Created by liang on 2016/6/1.
 */
@Service
public class FlowServiceImpl implements FlowService {
    private static final Logger logger = LogManager.getLogger(FlowServiceImpl.class);
    @Autowired
    private FlowDao flowDao;
    @Transactional(readOnly = false)
    public boolean saveOrUpdateModel(Flow model) {
        if (flowDao.saveOrUpdate( model )==1)
            return true;
        return false;
    }

    public boolean deleteModel(Integer id) {
        if(flowDao.deleteByKey( id )==1)
            return true;
        return false;
    }

    public boolean saveModel(Flow model) {
        if(flowDao.save( model )==1){
            return true;
        }
        return false;
    }

    public boolean updateModel(Flow model) {
        List<Flow> flowlist=flowDao.find( "from Flow as flow where flow.flowName='"+model.getFlowName()+"'");
        if(flowlist!=null && flowlist.size()>0){
            flowlist.get( 0 ).setChildFlow( model.getChildFlow() );
            flowlist.get( 0 ).setFlowName(model.getFlowName()  );
            flowlist.get( 0 ).setFlowType( model.getFlowType() );
            flowlist.get( 0 ).setParentFlow( model.getParentFlow() );
            if(flowDao.update( flowlist.get( 0 ) )==1){
                return true;
            }
        }
        return false;
    }

    public Flow findModel(Integer id) {
        Flow f=(Flow) flowDao.get( id );
        return f;
    }

    public List<Flow> findAllFlow() {
        return flowDao.find( "from Flow" );
    }
}
