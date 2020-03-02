package springcloud.helloworld.feign.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springcloud.helloworld.feign.service.CircuitBreakerService;
import springcloud.helloworld.feign.service.HelloWorldService;

@RestController
public class WebController {
	
    @Autowired 
    private HelloWorldService helloWorldFeignService;
    
    @Autowired
    private CircuitBreakerService circuitBreakerService;
    
    
    /**
     * 多次刷新，轮询访问各个服务器，
     * @return
     */
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String sayHello(){
        return helloWorldFeignService.sayHello()+" I from feign";
    }
    
    @RequestMapping(value = "/breaker",method = RequestMethod.GET)
    public String sayBreaker(){
    	return circuitBreakerService.sayHello();
    }
    
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String Hello(){
    	return helloWorldFeignService.sayHello()+"I from feign";
    }
    
    
    
    
}