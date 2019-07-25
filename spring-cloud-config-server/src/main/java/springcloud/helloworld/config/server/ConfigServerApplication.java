package springcloud.helloworld.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableConfigServer     //@EnableConfigServer注解说明了一个Config Server 
@SpringBootApplication	
@EnableEurekaServer     //@EnableEurekaServer，启动一个服务注册中心提供给其他应用进行对话
public class ConfigServerApplication {
	/**
	 * 访问http://127.0.0.1:8888/config-client-test.properties就能访问到
	 * spring-cloud-config\config\config-client-test.properties的信息
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}

