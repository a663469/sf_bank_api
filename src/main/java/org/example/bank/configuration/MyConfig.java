package org.example.bank.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.example.bank.util.JSONGetValueByKey;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import org.apache.commons.io.IOUtils;

@Configuration
@ComponentScan(basePackages = "org.example.bank")
@EnableWebMvc
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class MyConfig {
    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            ClassPathResource staticDataResource = new ClassPathResource("dbcfg.json");
            String staticDataString = IOUtils.toString(staticDataResource.getInputStream(), StandardCharsets.UTF_8);

            dataSource.setDriverClass(JSONGetValueByKey.getValueByKeyInJSONArray(staticDataString, "setDriverClass"));
            dataSource.setJdbcUrl(JSONGetValueByKey.getValueByKeyInJSONArray(staticDataString, "setJdbcUrl"));
            dataSource.setUser(JSONGetValueByKey.getValueByKeyInJSONArray(staticDataString, "setUser"));
            dataSource.setPassword(JSONGetValueByKey.getValueByKeyInJSONArray(staticDataString, "setPassword"));

        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("org.example.bank.entity");

        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");

        sessionFactory.setHibernateProperties(hibernateProperties);

        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());

        return transactionManager;
    }
}
