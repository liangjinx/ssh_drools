package zhinan.liang.model;

import zhinan.liang.entitys.Orders;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liang on 2016/6/28.
 */
public class RuleOrderTwo implements Serializable{
    public void RuleOrderTwo(){

    }
    private List<Orders> list;

    public List<Orders> getList() {
        return list;
    }

    public void setList(List<Orders> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "RuleOrderTwo{" +
                "list=" + list +
                '}';
    }
}
