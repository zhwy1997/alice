package serviceTest;
import org.springframework.stereotype.Service;

import serviceTest.MvcTest;

@Service
public class MvcTestImpl implements MvcTest {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("这是测试服务类");
	}

}
