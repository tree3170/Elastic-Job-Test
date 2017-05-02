import com.alibaba.fastjson.JSON;
import com.util.JedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tree on 2017/5/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class JedisUtilTest {


    protected static final Logger logger = LoggerFactory.getLogger(JedisUtilTest.class);

    @Autowired
    protected JedisUtil redisConfig;

    @Test
    public void test(){
//            redisConfig.delBatch("*task");
//            redisConfig.del("save_contract_doc_task");
    }

    @Test
    public void testSetString(){
        redisConfig.set("tree1","2");
    }

//    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
//        map.put("vinCode", "asdfa");
//        System.out.println(JSON.toJSONString(map));
//    }



}
