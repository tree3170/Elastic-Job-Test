import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tree on 2017/4/27.
 */
public class AppTest {

    public static void main( String[] args ) throws InterruptedException {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        System.out.println("开始。。。");
//        demo.execute();
        Thread.sleep(10000000);
    }
}
