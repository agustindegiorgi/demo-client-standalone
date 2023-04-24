package com.example.democlientstandalone.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoLoadBalancerConfiguration {
    private static final Logger LOG = LoggerFactory.getLogger(DemoLoadBalancerConfiguration.class);

    @Bean
    public ServiceInstanceListSupplier discoveryClientServiceInstanceListSupplier(
            ConfigurableApplicationContext context) {
        LOG.info("Configuring Load balancer to prefer same instance");
        return ServiceInstanceListSupplier.builder()
                .withBlockingDiscoveryClient()
                //.withSameInstancePreference()
                .build(context);
    }
}