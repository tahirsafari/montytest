package com.montytest.restapi.config.db;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ConditionalOnClass(DataSource.class)
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
@PropertySource(value= "classpath:mysql.properties")
public class DBConfiguration {
	@Value("${db.mysql.driver}")
	private String dbDriver;
	@Value("${db.mysql.url}")
	private String dbUrl;
	@Value("${db.mysql.username}")
	private String dbUsername;
	@Value("${db.mysql.password}")
	private String dbPassword;
	

    @Bean
    @ConditionalOnProperty(name = "usemysql", havingValue = "local")
    @ConditionalOnMissingBean
    public DataSource dataSource() {
    	
	    HikariConfig hikariConfig = new HikariConfig();
	    hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
	    hikariConfig.setJdbcUrl(dbUrl); 
	    hikariConfig.setUsername(dbUsername);
	    hikariConfig.setPassword(dbPassword);

	    hikariConfig.setMaximumPoolSize(500);
	    hikariConfig.setMinimumIdle(5);
	    hikariConfig.setConnectionTestQuery("SELECT 1");
	    hikariConfig.setPoolName("montyCP");

	    hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
	    hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "250");
	    hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
	    hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");
	    
	    hikariConfig.addDataSourceProperty("dataSource.connectionTimeout", "30000");
	    hikariConfig.addDataSourceProperty("dataSource.idleTimeout", "60000");
	    hikariConfig.addDataSourceProperty("dataSource.leakDetectionThreshold", "15000");


	    HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        return dataSource;
    }
    
	  @Bean("jdbcTemplate")
	  @ConditionalOnBean(name = "dataSource")
	  @ConditionalOnMissingBean
	  public JdbcTemplate jdbcTemplate() {
		  return new JdbcTemplate(dataSource());
	  }

}
