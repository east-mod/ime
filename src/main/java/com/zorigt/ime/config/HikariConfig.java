package com.zorigt.ime.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class HikariConfig {
    @Value("${eastmod.mysql.url}")
    private String url;
    @Value("${eastmod.mysql.user}")
    private String user;
    @Value("${eastmod.mysql.password}")
    private String password;
    @Value("${eastmod.hikari.connectionTimeout}")
    private long connectionTimeout;
    @Value("${eastmod.hikari.maximum-pool-size}")
    private int maximumPoolSize;

    @Bean
    public DataSource createDataSource() {
        com.zaxxer.hikari.HikariConfig config = new com.zaxxer.hikari.HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(password);
        config.setConnectionTimeout(connectionTimeout);
        config.setMaximumPoolSize(maximumPoolSize);
        return new HikariDataSource(config);
    }
}
