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
public class Delivery implements Serializable{
    private static final long serialVersionUID = 9050278225625336475L;
    //id
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="id_delivery")
    @SequenceGenerator(name="id_delivery",sequenceName = "deliverySequence",initialValue=1)
    private Integer id;
    //交货单编号
    private String deliveryId;
    //交货单创建时间
    private Date cteateTime;
    //交货单总量
    private Double sum;
    // 单价
    private Integer unit;
    //交货单状态
    private Integer status;
    //发货过账时间
    private Date deliveryPostingTime;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getCteateTime() {
        return cteateTime;
    }
    public void setCteateTime(Date cteateTime) {
        this.cteateTime = cteateTime;
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
    public Date getDeliveryPostingTime() {
        return deliveryPostingTime;
    }
    public void setDeliveryPostingTime(Date deliveryPostingTime) {
        this.deliveryPostingTime = deliveryPostingTime;
    }
    public String getDeliveryId() {
        return deliveryId;
    }
    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }
    public Double getSum() {
        return sum;
    }
    public void setSum(Double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", deliveryId='" + deliveryId + '\'' +
                ", cteateTime=" + cteateTime +
                ", sum=" + sum +
                ", unit=" + unit +
                ", status=" + status +
                ", deliveryPostingTime=" + deliveryPostingTime +
                '}';
    }
}
