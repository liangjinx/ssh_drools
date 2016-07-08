package zhinan.liang.entitys;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Created by liang on 2016/6/7.
 */
@Entity
@Table
public class FlowEvent implements Serializable{
    private static final long serialVersionUID = 9080268225625336475L;
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="id_flowsEvent")
    @SequenceGenerator(name="id_flowsEvent",sequenceName = "flowsEvent_id"
            ,allocationSize = 25,schema="scott",initialValue=0)
    private Integer id;
    private String flowEventId;
    private String flowEventName;
    private String FlowEventValue;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFlowEventId() {
        return flowEventId;
    }
    public void setFlowEventId(String flowEventId) {
        this.flowEventId = flowEventId;
    }
    public String getFlowEventName() {
        return flowEventName;
    }
    public void setFlowEventName(String flowEventName) {
        this.flowEventName = flowEventName;
    }
    public String getFlowEventValue() {
        return FlowEventValue;
    }
    public void setFlowEventValue(String flowEventValue) {
        FlowEventValue = flowEventValue;
    }
}
