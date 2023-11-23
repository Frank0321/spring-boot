package com.example.springboot;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.example.springboot.config.BeanNameGenerator;

@SpringBootApplication
@EnableScheduling
@ServletComponentScan
@ComponentScan(nameGenerator = BeanNameGenerator.class)
public class Application {

	@Value("${spring.h2.console.port:9090}")
	private String port;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
    /**
     * Start internal H2 server so we can query the DB from IDE
     *
     * @return H2 Server instance
     * @throws SQLException
     */
    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2Server() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", port);
    }

}
