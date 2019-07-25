package springcloud.helloworld.Hystrix.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springcloud.helloworld.Hystrix.service.CircuitBreakerService;

@RestController
public class WebController {
	
    
    @Autowired
    private CircuitBreakerService circuitBreakerService;
    
    @RequestMapping(value = "/breaker",method = RequestMethod.GET)
    public String sayBreaker(){
    	System.out.println("WebController.sayBreaker().............");
    	return circuitBreakerService.sayHello();
    }
    
}