package zhinan.liang.entitys;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Created by liang on 2016/5/18.
 */
@Entity
@Table
public class Flow implements Serializable {
    private static final long serialVersionUID = 9050268225625336475L;
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="id_flows")
    @SequenceGenerator(name="id_flows",sequenceName = "eventFlows_id"
            ,allocationSize = 25,schema="scott",initialValue=0)
    private Integer id;
    private String flowName;
    private Integer flowType;
    private String parentFlow;
    private String childFlow;
    private Integer status;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }
    public Integer getFlowType() {
        return flowType;
    }

    public void setFlowType(Integer flowType) {
        this.flowType = flowType;
    }
    public String getParentFlow() {
        return parentFlow;
    }

    public void setParentFlow(String parentFlow) {
        this.parentFlow = parentFlow;
    }
    public String getChildFlow() {
        return childFlow;
    }

    public void setChildFlow(String childFlow) {
        this.childFlow = childFlow;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String toString() {
        return "Flow{" +
                "id=" + id +
                ", flowName='" + flowName + '\'' +
                ", flowType=" + flowType +
                ", parentFlow='" + parentFlow + '\'' +
                ", childFlow='" + childFlow + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flow)) return false;

        Flow flow = (Flow) o;

        if (!id.equals(flow.id)) return false;
        if (flowName != null ? !flowName.equals(flow.flowName) : flow.flowName != null) return false;
        if (flowType != null ? !flowType.equals(flow.flowType) : flow.flowType != null) return false;
        if (parentFlow != null ? !parentFlow.equals(flow.parentFlow) : flow.parentFlow != null) return false;
        if (childFlow != null ? !childFlow.equals(flow.childFlow) : flow.childFlow != null) return false;
        return status != null ? status.equals(flow.status) : flow.status == null;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (flowName != null ? flowName.hashCode() : 0);
        result = 31 * result + (flowType != null ? flowType.hashCode() : 0);
        result = 31 * result + (parentFlow != null ? parentFlow.hashCode() : 0);
        result = 31 * result + (childFlow != null ? childFlow.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
