package springcloud.helloworld.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 使用@EnableDiscoveryClient开启服务自动发现	
 */
@SpringBootApplication
@EnableDiscoveryClient  
@EnableFeignClients
public class ServiceFeignApplication {
	
	/**
	 * HelloWorldService:使用@FeignClient配置访问的项目；
	 * 通过@RequestMapping，配置访问服务方法的具体路径
	 * 
	 * Feign访问服务已经缺省使用了Ribbon负载均衡。
	 * @param args
	 */
    public static void main(String[] args) {
        SpringApplication.run(ServiceFeignApplication.class, args);
    }
}