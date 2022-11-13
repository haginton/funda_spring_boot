package com.fundamentosplatzi.springbootH.fundamentosH.configuration;

import com.fundamentosplatzi.springbootH.fundamentosH.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springbootH.fundamentosH.bean.MyBeanWithPropertiesImplement;
import com.fundamentosplatzi.springbootH.fundamentosH.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.apellido}")
    private String apellido;

    @Value("${value.random}")
    private String random;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${driver}")
    private String driver;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    @Bean
    public MyBeanWithProperties function(){
        return new MyBeanWithPropertiesImplement(name, apellido);
    }

    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driver); //Controlador (nombre clase controladora)
        dataSourceBuilder.url(jdbcUrl); //url jdbc, despues del h2 puedo definir un path para guardar la bd
        dataSourceBuilder.username(username) ;
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }
}
