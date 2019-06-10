package springcloud.helloworld.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author kongml
 * @date 2019年4月25日 
 * @version 1.0.1
 * 
 * @FeignClient用于通知Feign组件对该接口进行代理(不需要编写接口实现)，使用者可直接通过@Autowired注入;
 * 该接口通过value定义了需要调用的SERVICE-HELLOWORLD服务（通过服务中心自动发现机制会定位具体URL）;  
 */
@FeignClient(value = "SERVICE-HELLOWORLD")
public interface HelloWorldService {
	
	/**
	 * Spring Cloud应用在启动时，Feign会扫描标有@FeignClient注解的接口，生成代理，并注册到Spring容器中。
	 * 生成代理时Feign会为每个接口方法创建一个RequetTemplate对象，该对象封装了HTTP请求需要的全部信息，
	 * 请求参数名、请求方法等信息都是在这个过程中确定的，Feign的模板化就体现在这里
	 */
	
	
	//@RequestMapping定义了Feign需要访问的SERVICE-HELLOWORLD服务的URL（本例中为根“/”）
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String sayHello();
    
   
    /**
     *  注意，如果在@RequetMapping中的method将请求方式指定为POST，那么所有未标注解的参数将会被忽略
     *  此时因为声明的是GET请求没有请求体，所以obj参数就会被忽略。
     */
    @RequestMapping(value = "/group/{groupId}", method = RequestMethod.GET)
    void update(@PathVariable("groupId") Integer groupId, @RequestParam("groupName") String groupName, Object obj);
}