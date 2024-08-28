package com.example.demo10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Demo10Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo10Application.class, args);
	}

	/**
	 * 자동주입 받기 위해 Bean 으로 등록
	 * 
	 * 우리가 만든 소스의 경우, 클래스의 상단에 어노테이션을 적용해서 Bean 으로 등록이 가능
	 * 라이브러리에서 제공하는 객체의 경우에는 Bean 으로 등록후 사용가능
	 * 
	 *
	 * @return
	 */
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
