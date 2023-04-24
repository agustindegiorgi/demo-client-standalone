package com.example.democlientstandalone;

import com.example.democlientstandalone.clients.DragonBallCharacterClient;
import com.netflix.discovery.EurekaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
@EnableFeignClients
public class DemoClientStandaloneApplication implements ApplicationRunner {

    private static final Logger LOG = LoggerFactory.getLogger(DemoClientStandaloneApplication.class);
    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DragonBallCharacterClient dbcClient;

    public static void main(String[] args) {
        SpringApplication.run(DemoClientStandaloneApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        for (int i = 0; i < 10; i++) {
            ResponseEntity<String> responseEntity = dbcClient.getApplicationName();
            LOG.info("Status {}", responseEntity.getStatusCode());
            LOG.info("Body {}", responseEntity.getBody());
        }
    }

	/*@Override
	public void run(ApplicationArguments args) {
		*//**
     * Implementando la interfaz ApplicationRunner,
     * nos va a permitir ejecutar una serie de lógica para
     * simular llamadas a distintos endpoints.
     *//*
		Application application = eurekaClient.getApplication("ms-demo-dragon-ball");
		LOG.info("Application name {}", application.getName());
		List<InstanceInfo> instances = application.getInstances();
		instances.forEach(instanceInfo ->
				LOG.info("IP Address {}:{}",
						instanceInfo.getIPAddr(),
						instanceInfo.getPort())
		);
	}*/
}
