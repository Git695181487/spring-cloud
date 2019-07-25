package springcloud.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope //开启refresh机制(配置自动刷新)
/**
 * <artifactId>spring-boot-starter-actuator</artifactId>	
 * 请求http://127.0.0.1:8881/toRefresh时，自动刷新当前项目的配置文件
 */
public class ConfigClientApplication {

	
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    /**
     * 访问文件规则，application当前应用的名字，本应用为config-client
     * 先从spring.cloud.config.label获取代码分支，spring.cloud.config.profile就是下面的profile
     * /{application}/{profile}[/{label}]
     * /{application}-{profile}.properties
	 * /{label}/{application}-{profile}.properties
     */
    
    @Value("${nba}")
    String hello;
    @RequestMapping(value = "/hello")
    public String hello(){
        return hello;
    }
}