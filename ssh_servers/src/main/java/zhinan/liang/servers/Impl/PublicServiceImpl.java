package zhinan.liang.servers.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import zhinan.liang.daos.OrderDao;
import zhinan.liang.entitys.Orders;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liang on 2016/6/2.
 */

public  class PublicServiceImpl{
    @Autowired
    private static OrderDao orderDao;
    static List<Orders> list=new ArrayList<Orders>();
    public static void guizeNext(Orders order){
        System.out.println("list:"+list.size()+",order:"+order.toString());
        if(!list.contains( order )){
            list.add( order );
        }
    }
    public static List<Orders> getOrder(){
        if(list==null || list.size()<1){
            list=orderDao.orderList();
        }
        return list;
    }
    public static void clear(){
        list.clear();
    }
}
