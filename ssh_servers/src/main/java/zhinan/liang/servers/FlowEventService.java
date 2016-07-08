package zhinan.liang.servers;


import zhinan.liang.entitys.FlowEvent;

/**
 * Created by liang on 2016/6/7.
 */
public interface FlowEventService extends PublicService<FlowEvent,Integer> {
    void startStorm();
}
