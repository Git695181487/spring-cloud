package springcloud.helloworld.eureka.client;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

	@RequestMapping("/getName")
	public String getName() {
		return "这里是获取名称方法getName()";
	}
	@RequestMapping("/getNameById")
	public String getName(@RequestParam("id")String id) {
		return "这里是获取名称方法getName()"+id;
	}
}
