package springcloud.helloworld.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *  其中registerWithEureka：false和fetchRegistry：false表明自己是一个eureka server
 * @author kongml
 * @date 2019年7月25日 
 * @version 1.0.1
 */

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}