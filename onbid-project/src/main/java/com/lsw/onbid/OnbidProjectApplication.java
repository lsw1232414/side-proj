package com.lsw.onbid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.lsw.onbid.mapper")
public class OnbidProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnbidProjectApplication.class, args);
	}

}
