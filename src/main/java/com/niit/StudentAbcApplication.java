package com.niit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

@SpringBootApplication(scanBasePackages = "com..niit")
@ComponentScan(basePackages = "com.niit")
public class StudentAbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentAbcApplication.class, args);
	}

	@Bean
	public HibernateJpaSessionFactoryBean SessionFactory()
	{
		return new HibernateJpaSessionFactoryBean();
	}
}
