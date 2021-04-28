package com.vdata.sagittarius;

import com.vdata.sagittarius.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SagittariusApplicationTests {

	@Test
	void contextLoads() {

		Client client1 = new PhysicalClient();
		Client client2 = new JuridicalClient();
		Contract contract = new Contract();
		InsuredPerson insuredPerson = new InsuredPerson();


	}

}
