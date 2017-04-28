package tree;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tree on 2017/4/27.
 */
@Component
public class SequenceDataFlowDemo implements DataflowJob {
    protected static final Logger logger = LoggerFactory.getLogger(SequenceDataFlowDemo.class);

    @Override
    public List fetchData(ShardingContext shardingContext) {
//        logger.error("SequenceDataFlowDemo .....fetchData start");
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        List l = new ArrayList();
        l.add("fetchData..");
//        logger.error("SequenceDataFlowDemo .....fetchData end");
        return l;
    }

    @Override
    public void processData(ShardingContext shardingContext, List data) {
//        logger.error("DataFlow... \n SequenceDataFlowDemo .....processData start, data="+data+",ShardingItem="+shardingContext.getShardingItem());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.error("SequenceDataFlowDemo .....processData end, Sharding Items="+shardingContext.getShardingItem()+"\n");


    }
}
