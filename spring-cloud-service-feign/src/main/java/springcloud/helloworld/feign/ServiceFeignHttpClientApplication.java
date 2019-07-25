package springcloud.helloworld.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 在Feign中使用Apache HTTP Client替换Feign原始的http client
 * 从而获取连接池、超时时间等与性能息息相关的控制能力
 */
@SpringBootApplication
@EnableDiscoveryClient  
@EnableFeignClients
public class ServiceFeignHttpClientApplication {
	
	/**
	 * Feign在默认情况下使用的是JDK原生的URLConnection发送HTTP请求，没有连接池，但是对每个地址gwai会保持一个长连接
	 * @param args
	 */
    public static void main(String[] args) {
        SpringApplication.run(ServiceFeignHttpClientApplication.class, args);
    }
}