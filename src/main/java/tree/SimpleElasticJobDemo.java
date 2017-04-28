package tree;

/**
 * Created by tree on 2017/4/27.
 */
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * ${DESCRIPTION}
 *
 * @author liuzhenshu
 * @date 2017-04-27 11:15
 */
@Component
public class SimpleElasticJobDemo implements SimpleJob {
    protected static final Logger logger = LoggerFactory.getLogger(SimpleElasticJobDemo.class);

    @Override
    public void execute(ShardingContext context) {
//        logger.error("Simple...\n SimpleElasticJobDemo .....execute start,ShardingItem="+context.getShardingItem());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        switch (context.getShardingItem()) {
            case 0:
                // do something by sharding item 0
                break;
            case 1:
                // do something by sharding item 1
                break;
            case 2:
                // do something by sharding ite9m 2
                break;
            // case n: ...
        }
        logger.error("SimpleElasticJobDemo .....execute end, ShardingItem="+context.getShardingItem()+"\n");

    }
}