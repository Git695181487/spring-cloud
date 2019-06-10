package springcloud.helloworld.Hystrix.service;

import org.springframework.stereotype.Service;

@Service
public class CircuitBreakerFailureService implements CircuitBreakerService{

	@Override
	public String sayHello() {
		System.out.println("CircuitBreakerFailureService is not available !");
		return "hello world service is not available !";
	}

}
