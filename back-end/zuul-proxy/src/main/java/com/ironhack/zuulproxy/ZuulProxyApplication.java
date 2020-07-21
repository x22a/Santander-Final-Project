package com.ironhack.zuulproxy;

import com.netflix.zuul.constants.ZuulHeaders;
import com.netflix.zuul.http.ZuulServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Zuul Proxy Application
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulProxyApplication {
	/**
	 * Main
	 * @param args Array of Strings
	 */
	public static void main(String[] args) {
		SpringApplication.run(ZuulProxyApplication.class, args);
	}
}
