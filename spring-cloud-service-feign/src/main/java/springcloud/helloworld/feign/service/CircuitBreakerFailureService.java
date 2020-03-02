package springcloud.helloworld.feign.service;

import org.springframework.stereotype.Service;

@Service
public class CircuitBreakerFailureService implements CircuitBreakerService{

	@Override
	public String sayHello() {
		return "hello world service is not available !";
	}

}
