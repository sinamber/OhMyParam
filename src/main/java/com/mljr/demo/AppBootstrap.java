package com.mljr.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.mljr.demo.consts.BeanAlias;

@Configuration
@Import({ AppInitListener.class })
@ComponentScan(basePackages = { BeanAlias.BASE_PACKAGE })
@EnableAutoConfiguration
public class AppBootstrap {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(AppBootstrap.class, args);
	}
}
