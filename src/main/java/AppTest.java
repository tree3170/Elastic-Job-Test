import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tree on 2017/4/27.
 */
public class AppTest {

    public static void main( String[] args ) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:spring-config.xml");
    }
}
