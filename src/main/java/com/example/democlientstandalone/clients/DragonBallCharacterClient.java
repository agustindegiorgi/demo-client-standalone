package com.example.democlientstandalone.clients;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${service.name}") // Es el nombre del MS a consumir
@LoadBalancerClient(name = "${service.name}",  configuration = DemoLoadBalancerConfiguration.class)
/**
 * No es necesario realizar una implementación de la interfaz
 * ya que Feign lo hará automáticamente
 */
public interface DragonBallCharacterClient {

    @RequestMapping(method = RequestMethod.GET, value = "/application-name")
    ResponseEntity<String> getApplicationName();
}