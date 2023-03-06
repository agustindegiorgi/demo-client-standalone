package com.example.democlientstandalone;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class DemoClientStandaloneApplication implements ApplicationRunner {

	private static final Logger LOG = LoggerFactory.getLogger(DemoClientStandaloneApplication.class);
	@Autowired
	private EurekaClient eurekaClient;

	public static void main(String[] args) {
		SpringApplication.run(DemoClientStandaloneApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {
		/**
		 * Implementando la interfaz ApplicationRunner,
		 * nos va a permitir ejecutar una serie de lógica para
		 * simular llamadas a distintos endpoints.
		 */
		Application application = eurekaClient.getApplication("ms-demo-dragon-ball");
		LOG.info("Application name {}", application.getName());
		List<InstanceInfo> instances = application.getInstances();
		instances.forEach(instanceInfo -> LOG.info("IP Address {}:{}", instanceInfo.getIPAddr(), instanceInfo.getPort()));
	}
}
