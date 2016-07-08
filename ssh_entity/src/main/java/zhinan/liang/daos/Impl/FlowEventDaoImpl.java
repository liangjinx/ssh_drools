package zhinan.liang.daos.Impl;


import org.springframework.stereotype.Repository;
import zhinan.liang.daos.FlowEventDao;
import zhinan.liang.entitys.FlowEvent;

/**
 * Created by liang on 2016/6/7.
 */
@Repository("flowEventDao")
public class FlowEventDaoImpl extends PublicDaoImpl<FlowEvent,Integer>  implements FlowEventDao {
}
