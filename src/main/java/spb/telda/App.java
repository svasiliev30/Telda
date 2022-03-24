package spb.telda;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import spb.telda.dao.mapper.DirectoryMapper;

/**
 * Hello world!
 *
 */
//@MapperScan("spb.telda")
@SpringBootApplication
//@EnableTransactionManagement
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);

    }
    //        SqlSessionFactory sqlSessionFactory;
//        DirectoryMapper directoryMapper;
//        Reader reader = null;
//        Reader reader;
//        try {
//            reader = Resources
//                    .getResourceAsReader("mybatisConfig.xml"); //Читаем файл с настройками подключения и настройками MyBatis
//            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//            subscriberMapper = sqlSessionFactory.openSession().getMapper(SubscriberMapper.class); //Создаем маппер, из которого и будем вызывать методы getSubscriberById и getSubscribers
//            List<Flow.Subscriber> subscribers = subscriberMapper.getSubscribers();
//            Flow.Subscriber subscriber = subscriberMapper.getSubscriberById(101);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    jdbc:sqlite:C:\Users\Hp\Desktop\Test\Telda\db\Telda-sqlLite-directory.db
}
