package zhinan.liang.servers.Impl;


import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.IRichSpout;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Tuple;
import org.springframework.stereotype.Service;
import zhinan.liang.entitys.FlowEvent;
import zhinan.liang.servers.FlowEventService;

import java.util.Map;

/**
 * Created by liang on 2016/6/7.
 */
@Service
public class FlowEventServiceImpl implements FlowEventService {
    public boolean saveOrUpdateModel(FlowEvent model) {
        return false;
    }

    public boolean deleteModel(Integer id) {
        return false;
    }

    public boolean saveModel(FlowEvent model) {
        return false;
    }

    public boolean updateModel(FlowEvent model) {
        return false;
    }

    public FlowEvent findModel(Integer id) {
        return null;
    }
    //开始storm 分发处理操作
    public void startStorm() {
        TopologyBuilder builder=new TopologyBuilder();
        builder.setSpout( "order-spout-reader", new IRichSpout() {
            public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {

            }

            public void close() {

            }

            public void activate() {

            }

            public void deactivate() {

            }

            public void nextTuple() {

            }

            public void ack(Object msgId) {

            }

            public void fail(Object msgId) {

            }

            public void declareOutputFields(OutputFieldsDeclarer declarer) {

            }

            public Map<String, Object> getComponentConfiguration() {
                return null;
            }
        }, 1 );
        builder.setBolt( "", new IRichBolt() {
            public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {

            }

            public void execute(Tuple input) {

            }

            public void cleanup() {

            }

            public void declareOutputFields(OutputFieldsDeclarer declarer) {

            }

            public Map<String, Object> getComponentConfiguration() {
                return null;
            }
        } );
    }
}
