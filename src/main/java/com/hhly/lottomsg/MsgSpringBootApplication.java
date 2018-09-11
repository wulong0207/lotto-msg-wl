package com.hhly.lottomsg;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;


@SpringBootApplication
@EnableEncryptableProperties
@EnableScheduling
@Configuration
@MapperScan("com.hhly.lottomsg.mapper")
@ImportResource("classpath:transaction.xml")
public class MsgSpringBootApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(MsgSpringBootApplication.class, args);
    }

}
 