package springcloud.helloworld.Hystrix.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springcloud.helloworld.Hystrix.service.CircuitBreakerService;
import springcloud.helloworld.Hystrix.service.HelloWorldService;

@RestController
public class WebController {
	
    @Autowired 
    private HelloWorldService helloWorldFeignService;
    
    @Autowired
    private CircuitBreakerService circuitBreakerService;
    
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String sayHello(){
        return helloWorldFeignService.sayHello();
    }
    
    @RequestMapping(value = "/breaker",method = RequestMethod.GET)
    public String sayBreaker(){
    	return circuitBreakerService.sayHello();
    }
    
}