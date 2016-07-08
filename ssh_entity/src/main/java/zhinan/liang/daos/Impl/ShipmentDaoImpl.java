package zhinan.liang.daos.Impl;


import org.springframework.stereotype.Repository;
import zhinan.liang.daos.ShipmentDao;
import zhinan.liang.entitys.Shipment;

/**
 * Created by liang on 2016/6/6.
 */
@Repository("shipmentDao")
public class ShipmentDaoImpl extends PublicDaoImpl<Shipment,Integer>  implements ShipmentDao {
}
