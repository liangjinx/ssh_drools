package zhinan.liang.servers;

import zhinan.liang.entitys.Orders;

import java.util.List;

/**
 * Created by liang on 2016/6/6.
 */
public interface OrderService extends PublicService<Orders,Integer>{
    List<Orders> orderList(boolean[] isUse);
    List<Orders> orderListByQuery(boolean[] isUse);
    List<Orders> orderListByQuery();
}
