package zhinan.liang.daos.Impl;

import org.springframework.stereotype.Repository;
import zhinan.liang.daos.DeliveryDao;
import zhinan.liang.entitys.Delivery;

/**
 * Created by liang on 2016/6/6.
 */
@Repository("deliveryDao")
public class DeliveryDaoImpl extends PublicDaoImpl<Delivery,Integer>  implements DeliveryDao {
}
