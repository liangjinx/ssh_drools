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
public class Shipment implements Serializable{
    private static final long serialVersionUID = 9050245625612336475L;
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="id_shipment")
    @SequenceGenerator(name="id_shipment",sequenceName = "deliverySequence",initialValue=1)
    private Integer id;
    //装运单编号
    private String shipmentId;
    //装运单创建时间
    private Date createTime;
    //封装单状态
    private Integer status;
    //装运扫码状态
    private Integer scannerStatus;
    //第一次扫码时间
    private Date firstScannerTime;
    //签收及评价状态
    private Integer signevaluationStatus;
    //签收及评价时间
    private Date signevaluationTime;
    //入库且过账状态
    private Integer incomingArrivalStatus;
    //入库且过账时间
    private Date incomingArrivalTime;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getShipmentId() {
        return shipmentId;
    }
    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getScannerStatus() {
        return scannerStatus;
    }
    public void setScannerStatus(Integer scannerStatus) {
        this.scannerStatus = scannerStatus;
    }
    public Date getFirstScannerTime() {
        return firstScannerTime;
    }
    public void setFirstScannerTime(Date firstScannerTime) {
        this.firstScannerTime = firstScannerTime;
    }
    public Integer getSignevaluationStatus() {
        return signevaluationStatus;
    }
    public void setSignevaluationStatus(Integer signevaluationStatus) {
        this.signevaluationStatus = signevaluationStatus;
    }
    public Date getSignevaluationTime() {
        return signevaluationTime;
    }
    public void setSignevaluationTime(Date signevaluationTime) {
        this.signevaluationTime = signevaluationTime;
    }
    public Integer getIncomingArrivalStatus() {
        return incomingArrivalStatus;
    }
    public void setIncomingArrivalStatus(Integer incomingArrivalStatus) {
        this.incomingArrivalStatus = incomingArrivalStatus;
    }
    public Date getIncomingArrivalTime() {
        return incomingArrivalTime;
    }
    public void setIncomingArrivalTime(Date incomingArrivalTime) {
        this.incomingArrivalTime = incomingArrivalTime;
    }
}
