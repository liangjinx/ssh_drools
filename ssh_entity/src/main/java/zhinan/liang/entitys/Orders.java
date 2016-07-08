package zhinan.liang.entitys;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Created by liang on 2016/6/6.
 */
@Entity
@Table
public class Orders implements Serializable{
    private static final long serialVersionUID = 9050268225625336412L;
    //主键编号
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="id_order")
    @SequenceGenerator(name="id_order",sequenceName = "orderSequence")
    private Integer id;
    //订单编号
   /* @Column(columnDefinition="varchar2(20) not null",
            updatable = false,insertable = true,unique = true)*/
    private String orderId;
    //订单类型
    private Integer type;
    //订单创建时间
   /* @Column(updatable = false,insertable = true)*/
    private Date createTime;
    //订单总量
  /*  @Column(precision = 12,scale = 2,insertable = true,updatable = true)*/
    private Double sum;
    //订单单位
    private Integer unit;
    //订单状态
   /* @Column(length = 1,nullable = false)*/
    private Integer status;
    //订单更新时间
/*    @Temporal(TemporalType.DATE)*/
    private Date updateTime;
    //是否已经创建交货单
    private Integer IsCreateDelivery;
    //是否交货单都已经生成装运单
    private Integer IsADCSO;
    //是否所有交货单已经发货到账
    private Integer IsADToA;
    //是否所有装运单完成第一次扫描
    private Integer IsASFFS;
    //是否所有装运单完成签收评价
    private Integer IsASFS;
    //是否所有装运单完成入库到账
    private Integer IsASFIAl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsCreateDelivery() {
        return IsCreateDelivery;
    }

    public void setIsCreateDelivery(Integer isCreateDelivery) {
        IsCreateDelivery = isCreateDelivery;
    }

    public Integer getIsADCSO() {
        return IsADCSO;
    }

    public void setIsADCSO(Integer isADCSO) {
        IsADCSO = isADCSO;
    }

    public Integer getIsADToA() {
        return IsADToA;
    }

    public void setIsADToA(Integer isADToA) {
        IsADToA = isADToA;
    }

    public Integer getIsASFFS() {
        return IsASFFS;
    }

    public void setIsASFFS(Integer isASFFS) {
        IsASFFS = isASFFS;
    }

    public Integer getIsASFS() {
        return IsASFS;
    }

    public void setIsASFS(Integer isASFS) {
        IsASFS = isASFS;
    }

    public Integer getIsASFIAl() {
        return IsASFIAl;
    }

    public void setIsASFIAl(Integer isASFIAl) {
        IsASFIAl = isASFIAl;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orders)) return false;

        Orders orders = (Orders) o;

        if (!id.equals(orders.id)) return false;
        if (id!=orders.id) return false;
        if (!orderId.equals(orders.orderId)) return false;
        if (type != null ? !type.equals(orders.type) : orders.type != null) return false;
        if (createTime != null ? !createTime.equals(orders.createTime) : orders.createTime != null) return false;
        if (sum != null ? !sum.equals(orders.sum) : orders.sum != null) return false;
        if (unit != null ? !unit.equals(orders.unit) : orders.unit != null) return false;
        if (status != null ? !status.equals(orders.status) : orders.status != null) return false;
        if (updateTime != null ? !updateTime.equals(orders.updateTime) : orders.updateTime != null) return false;
        if (IsCreateDelivery != null ? !IsCreateDelivery.equals(orders.IsCreateDelivery) : orders.IsCreateDelivery != null)
            return false;
        if (IsADCSO != null ? !IsADCSO.equals(orders.IsADCSO) : orders.IsADCSO != null) return false;
        if (IsADToA != null ? !IsADToA.equals(orders.IsADToA) : orders.IsADToA != null) return false;
        if (IsASFFS != null ? !IsASFFS.equals(orders.IsASFFS) : orders.IsASFFS != null) return false;
        if (IsASFS != null ? !IsASFS.equals(orders.IsASFS) : orders.IsASFS != null) return false;
        return IsASFIAl != null ? IsASFIAl.equals(orders.IsASFIAl) : orders.IsASFIAl == null;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + orderId.hashCode();
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (sum != null ? sum.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (IsCreateDelivery != null ? IsCreateDelivery.hashCode() : 0);
        result = 31 * result + (IsADCSO != null ? IsADCSO.hashCode() : 0);
        result = 31 * result + (IsADToA != null ? IsADToA.hashCode() : 0);
        result = 31 * result + (IsASFFS != null ? IsASFFS.hashCode() : 0);
        result = 31 * result + (IsASFS != null ? IsASFS.hashCode() : 0);
        result = 31 * result + (IsASFIAl != null ? IsASFIAl.hashCode() : 0);
        return result;
    }
}
