package springcloud.helloworld.hystrix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {
	
    @Autowired 
    RestTemplate restTemplate;

    /**
     * 开启熔断器功能
     * 当底层服务失败后，fallbackMethod替换的不是整个被@HystrixCommand注解的方法（getHelloContent方法依然会被调用), 
     * 替换的只是通过restTemplate去访问的具体服务
     */
    @HystrixCommand(fallbackMethod="serviceFailure") 
    public String getHelloContent() {
    	System.out.println("HelloService.getHelloContent().........................");
        return restTemplate.getForObject("http://SERVICE-HELLOWORLD/",String.class);
    }
    
    public String getHelloContent(String str) {
    	return restTemplate.getForObject("http://SERVICE-HELLOWORLD/",String.class);
    }
    
    /**
     *  @HystrixCommand(fallbackMethod="serviceFailure")注释访问的服务出现问题的时候执行该方法
     *  fallbackMethod的返回值和参数类型需要和被@HystrixCommand注解的方法完全一致。否则会在运行时抛出异常
     */
    public String serviceFailure(){
    	return "hello world service is not available !";
    }
    
}