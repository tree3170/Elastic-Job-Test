import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tree.SimpleElasticJobDemo;

/**
 * Created by tree on 2017/4/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class SimpleElasticJobDemoTest {
//    @Autowired
//    private SimpleElasticJobDemo demo ;

    @Test
    public void test() throws InterruptedException {
        System.out.println("开始。。。");
//        demo.execute();
        Thread.sleep(10000000);
    }
}
