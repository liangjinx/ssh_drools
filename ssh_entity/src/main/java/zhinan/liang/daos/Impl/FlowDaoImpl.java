package zhinan.liang.daos.Impl;

import org.springframework.stereotype.Repository;
import zhinan.liang.daos.FlowDao;
import zhinan.liang.entitys.Flow;

/**
 * Created by liang on 2016/6/1.
 */
@Repository("flowDao")
public class FlowDaoImpl extends PublicDaoImpl<Flow,Integer>  implements FlowDao {
}
