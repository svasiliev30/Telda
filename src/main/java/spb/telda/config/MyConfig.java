package spb.telda.config;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.sqlite.SQLiteDataSource;
import spb.telda.dao.entity.Directory;
import javax.sql.DataSource;


@Configuration
@MappedTypes(Directory.class)
@MapperScan(basePackages = "spb.telda")
@PropertySource("application.properties")
public class MyConfig {

    /**
     * url bd
     */
    private String url;

    /**
     * Присваивает урл базы данных
     * @param url
     */
    @Value("${datasource.url}")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Присваиваем url для коннекта к бд через SQLiteDataSource
     * @return
     */
    @Bean
    public DataSource dataSource() {

        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(url);

        return dataSource;
    }

    /**
     * Присваиваем настройки коннекта к SqlSessionFactoryBean
     * для управления транзакциями.
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());

        return factoryBean.getObject();
    }
}

