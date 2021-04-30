package com.vdata.sagittarius;


import com.vdata.sagittarius.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

//	@Test
//	public void create() {
//
//
//		try (AbstractApplicationContext context =
//					 new FileSystemXmlApplicationContext("./src/main/resources/spring-context.xml")) {
//
//			//ContractBeanService contrService = context.getBean("contract-bean-service", ContractBeanService.class);
//			//Contract bean = context.getBean("contract-bean", Contract.class);
//			//contrService.doCreate2(bean);
//		}
//
//
//	}

}
