package cn.slkj.slclgl.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestController {
	@RequestMapping("/holle")
	public String holle() {
		System.out.println("sssss");
		return "index.jsp";
	}
}
