package com.lsw.onbid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lsw.onbid.mapper")
public class OnbidProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(OnbidProject1Application.class, args);
	}

}
