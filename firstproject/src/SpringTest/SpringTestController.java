package SpringTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import SpringTest.SpringTestService;;
@Controller
public class SpringTestController {
	@Autowired
	private SpringTestService springTestService;
	
	public void test() {
		System.out.println("ÕâÊÇ¿ØÖÆÆ÷");
		springTestService.test();
	}
}
