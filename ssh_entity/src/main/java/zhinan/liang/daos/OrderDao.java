package zhinan.liang.daos;
import zhinan.liang.entitys.Orders;

import java.util.List;

/**
 * Created by liang on 2016/6/6.
 */
public interface OrderDao extends PublicDao<Orders,Integer> {
    List<Orders> orderList();
}
