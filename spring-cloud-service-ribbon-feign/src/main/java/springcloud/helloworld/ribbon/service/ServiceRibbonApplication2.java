package springcloud.helloworld.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import springcloud.helloworld.ribbon.client.HelloService;
/**
 * @EnableDiscoveryClient向服务中心注册，并且注册了一个叫restTemplate的bean。
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@ComponentScan("springcloud.helloworld.ribbon.client")
public class ServiceRibbonApplication2 {
	
	@Autowired
	private RestTemplateBuilder builder;
	@Autowired
	private HelloService helloService;

    public static void main(String[] args) {
        SpringApplication.run(ServiceRibbonApplication2.class, args);
    }

    /**
     * @ LoadBalanced注册表明，这个restRemplate是需要做负载均衡的。
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
//        return new RestTemplate();
    	 return builder.build();
    }
    
	@RequestMapping("/")
	public String Hello() {
		return helloService.getHelloContent();
	}
}