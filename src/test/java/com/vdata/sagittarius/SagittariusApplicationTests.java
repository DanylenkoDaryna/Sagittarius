package com.vdata.sagittarius;

import com.vdata.sagittarius.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.sql.*;
import java.time.LocalDate;

@SpringBootTest
class SagittariusApplicationTests {

	@Test
	void contextLoads() {

		Client client1 = new PhysicalClient();
		Client client2 = new JuridicalClient();
		Contract contract = new Contract();
		InsuredPerson insuredPerson = new InsuredPerson();


	}

	@Test
	public void create() {


		try (AbstractApplicationContext context =
					 new FileSystemXmlApplicationContext("./src/main/resources/spring-context.xml")) {

			ContractBeanService contrService = context.getBean("contract-bean-service", ContractBeanService.class);
			Contract bean = context.getBean("contract-bean", Contract.class);
			contrService.doCreate2(bean);
		}


	}

	@Test
	public void createConn(){

		ConnectionFactory cf=new ConnectionFactory();
		//cf.init();
		try(Connection c=ConnectionFactory.getMySQLConnection();){
			PreparedStatement ps=c.prepareStatement("SELECT accept_date FROM contract");
			//ps.addBatch();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// Напечатать значения в текущей строке.
				Date d= rs.getDate("accept_date");
				LocalDate acceptDate=d.toLocalDate();
				System.out.println("acceptDate = " + acceptDate);
			}
			ps.close();
		}catch(SQLException s){
			s.printStackTrace();
		}

	}

	@Test
	public void outFIO() {

		InsuredPerson actual = new InsuredPerson(3, "Kovalenko", "Ivan", "Nikolaevich", LocalDate.of(1993,
				12, 9), 45);
		String expected = "Kovalenko I.N.";

		Assert.assertEquals(expected, actual.outFIO(actual.getSurname(),actual.getName(),actual.getMiddleName()));
	}


	@Before
	public void initTest() {

		first = new Client(Type.NATURAL, "Vasilyev", "Vasilyi", "Vasilyevich", "Kyiv","Poetry", "35", 1);
		actual = new ArrayList<>();

		Director director = new Director();
		ContractBuilder contractBuilder=new ContractBuilder();

		director.constructContract(contractBuilder);


		contractBuilder.setId(93);
		contractBuilder.setAcceptDate(LocalDate.of(2018, 11, 11));
		contractBuilder.setStartDate(LocalDate.of(2018, 12, 11));
		contractBuilder.setEndDate(LocalDate.of(2020, 12, 11));
		contractBuilder.setClient(first);
		contractBuilder.setPersons(actual);

		c =contractBuilder.getResult();





		second = new Client(Type.NATURAL, "Vasilyev","Vasilyi", "Vasilyevich", "Kyiv","Poetry", "35", 2);
		expects = new ArrayList<>();

		contractBuilder.setId(93);
		contractBuilder.setAcceptDate(LocalDate.of(2018, 11, 11));
		contractBuilder.setStartDate(LocalDate.of(2018, 12, 11));
		contractBuilder.setEndDate(LocalDate.of(2020, 12, 11));
		contractBuilder.setClient(second);
		contractBuilder.setPersons(expects);

		b =contractBuilder.getResult();




	}

	@After
	public void afterTest() {

		first = null;
		second = null;
		actual = null;
		expects = null;
		c = null;
		b = null;

	}

	@Test
	public void getTotalCost() {
		actual.add(new InsuredPerson(1, "Ivanov", "Ivan", "Ivanovich", LocalDate.of(1991, 1, 6), 150.50));
		actual.add(new InsuredPerson(2, "Petrov", "Peter", "Petrovich", LocalDate.of(1980, 7, 26), 1000.50));

		Assert.assertEquals("good", "1151.0", String.valueOf(c.getTotalCost()));

	}




	@Test
	public void sortPersonsByDate() {

		ArrayList<InsuredPerson> expected = new ArrayList<>(4);

		expected.add(new InsuredPerson(2, "Petrov", "Peter", "Petrovich", LocalDate.of(1980, 7, 26), 1000.50));
		expected.add(new InsuredPerson(3, "Petrov", "Ivan", "Ivanovich", LocalDate.of(2000, 1, 2), 150.50));
		expected.add(new InsuredPerson(1, "Ivanov", "Ivan", "Ivanovich", LocalDate.of(2000, 1, 6), 150.50));
		expected.add(new InsuredPerson(4, "Ankirov", "Peter", "Petrovich", LocalDate.of(2000, 7, 26), 1000.50));

		actual.add(new InsuredPerson(1, "Ivanov", "Ivan", "Ivanovich", LocalDate.of(2000, 1, 6), 150.50));
		actual.add(new InsuredPerson(2, "Petrov", "Peter", "Petrovich", LocalDate.of(1980, 7, 26), 1000.50));
		actual.add(new InsuredPerson(3, "Petrov", "Ivan", "Ivanovich", LocalDate.of(2000, 1, 2), 150.50));
		actual.add(new InsuredPerson(4, "Ankirov", "Peter", "Petrovich", LocalDate.of(2000, 7, 26), 1000.50));

		Assert.assertEquals(expected.toString(), (c.sortPersonsByDate(c.getPersonList())).toString());

	}

	@Test
	public void sortPersonsByName() {

		ArrayList<InsuredPerson> expected = new ArrayList<>(4);

		expected.add(new InsuredPerson(4, "Ankirov", "Peter", "Petrovich", LocalDate.of(1980, 7, 26), 1000.50));
		expected.add(new InsuredPerson(1, "Ivanov", "Ivan", "Ivanovich", LocalDate.of(1991, 1, 6), 150.50));
		expected.add(new InsuredPerson(3, "Petrov", "Ivan", "Ivanovich", LocalDate.of(1991, 1, 6), 150.50));
		expected.add(new InsuredPerson(2, "Petrov", "Peter", "Petrovich", LocalDate.of(1980, 7, 26), 1000.50));

		actual.add(new InsuredPerson(1, "Ivanov", "Ivan", "Ivanovich", LocalDate.of(1991, 1, 6), 150.50));
		actual.add(new InsuredPerson(2, "Petrov", "Peter", "Petrovich", LocalDate.of(1980, 7, 26), 1000.50));
		actual.add(new InsuredPerson(3, "Petrov", "Ivan", "Ivanovich", LocalDate.of(1991, 1, 6), 150.50));
		actual.add(new InsuredPerson(4, "Ankirov", "Peter", "Petrovich", LocalDate.of(1980, 7, 26), 1000.50));

		Assert.assertEquals(expected.toString(), (c.sortPersonsByName(c.getPersonList())).toString());


	}

	@Test
	public void testSearchPerson() {

		InsuredPerson expected = new InsuredPerson(1449, "Berezova", "Marya", "Ivanovna", LocalDate.of(1994, 1, 29), 1500);

		actual.add(new InsuredPerson(133, "Ivanov", "Ivan", "Ivanovich", LocalDate.of(1991, 1, 6), 150.50));
		actual.add(new InsuredPerson(1449, "Berezova", "Marya", "Ivanovna", LocalDate.of(1994, 1, 29), 1500));
		actual.add(new InsuredPerson(1448, "Ivanov", "Helmut", "Ivanovich", LocalDate.of(1991, 1, 6), 150.50));

		InsuredPerson actual = c.getPersonById(1449);
		Assert.assertEquals(expected.getSurname(), actual.getSurname());


		InsuredPerson actual1 = c.getPersonById(1446);
		Assert.assertEquals("", actual1.getSurname());

	}

	@Test
	public void uploadCSV() {

		actual.add(new InsuredPerson(1, "Ivanov", "Ivan", "Ivanovich", LocalDate.of(1991, 1, 6), 150.50));
		actual.add(new InsuredPerson(2, "Petrov", "Peter", "Petrovich", LocalDate.of(1980, 7, 26), 1000.50));


		expects.add(new InsuredPerson(1, "Ivanov", "Ivan", "Ivanovich", LocalDate.of(1991, 1, 6), 150.50));
		expects.add(new InsuredPerson(2, "Petrov", "Peter", "Petrovich", LocalDate.of(1980, 7, 26), 1000.50));

		b.sortPersonsByName(expects);
		c.sortPersonsByName(actual);
		c.saveCSV();

		Assert.assertEquals(b.toString(), c.uploadCSV().toString());
	}

	@Test
	public void testJDBC()  {

		actual.add(new InsuredPerson(1, "Ivanov", "Ivan", "Ivanovich", LocalDate.of(1991, 1, 6), 150.50));
		actual.add(new InsuredPerson(2, "Petrov", "Peter", "Petrovich", LocalDate.of(1980, 7, 26), 1000.50));

        /*dao.createTable(c);
        dao.getDB().getId();
        Assert.assertEquals(86, dao.getDB().getId());*/
	}
}
