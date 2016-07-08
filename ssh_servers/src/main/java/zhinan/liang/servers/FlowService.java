package zhinan.liang.servers;


import zhinan.liang.entitys.Flow;

import java.util.List;

/**
 * Created by liang on 2016/6/1.
 */
public interface FlowService extends PublicService<Flow,Integer>{
    List<Flow> findAllFlow();
}
