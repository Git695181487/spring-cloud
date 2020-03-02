package springcloud.helloworld.Hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 使用@EnableDiscoveryClient开启服务自动发现	
 * Feign内部已经支持了断路器
 */
@SpringBootApplication
@EnableDiscoveryClient  
@EnableFeignClients



public class ServiceFeignHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceFeignHystrixApplication.class, args);
    }
}