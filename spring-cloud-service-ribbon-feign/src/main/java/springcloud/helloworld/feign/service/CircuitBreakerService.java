package springcloud.helloworld.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author kongml
 * @date 2019年4月25日 
 * @version 1.0.1
 */
@FeignClient(value = "SERVICE-HELLOWORLD",fallback=CircuitBreakerFailureService.class)
/**
 * 请求SERVICE-HELLOWORLD出现问题的时候，
 * 执行CircuitBreakerFailureService类里的实现方法
 */
public interface CircuitBreakerService {
	
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String sayHello();
   
}