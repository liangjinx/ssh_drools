package zhinan.liang.daos.Impl;


import org.springframework.stereotype.Repository;
import zhinan.liang.daos.OrderDao;
import zhinan.liang.entitys.Orders;

import java.util.List;

/**
 * Created by liang on 2016/6/6.
 */
@Repository("orderDao")
public class OrderDaoImpl extends PublicDaoImpl<Orders,Integer>  implements OrderDao {
    public List<Orders> orderList() {
        List<Orders> list =this.find( "from Orders" );
        return list;
    }
}
