package com.example;

import com.example.config.MyBatisConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@Import(MyBatisConfig.class)
@SpringBootApplication
//@MapperScan(basePackages = "com.example.repository.mybatis")
public class TaekApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaekApplication.class, args);
	}

}
