package com.hellodemo.hellodemo.configation;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author Niclas
 * @create 2019-03-27-17:49
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @RefreshScope
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource refreshDatasource(){
        return DataSourceBuilder.create().build();
    }
}
