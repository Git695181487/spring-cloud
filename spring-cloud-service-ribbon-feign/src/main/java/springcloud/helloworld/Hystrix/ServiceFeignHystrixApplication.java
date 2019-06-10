package springcloud.helloworld.Hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 使用@EnableDiscoveryClient开启服务自动发现	
 */
@SpringBootApplication
@EnableDiscoveryClient  
@EnableFeignClients

@EnableCircuitBreaker  
@EnableHystrixDashboard
//注意的是我们之前的Feign服务由于内置断路器支持， 所以没有@EnableCircuitBreaker注解，但要使用Dashboard则必须加
public class ServiceFeignHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceFeignHystrixApplication.class, args);
    }
}