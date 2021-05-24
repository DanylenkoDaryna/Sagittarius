package com.vdata.sagittarius.entity;

import com.vdata.sagittarius.entity.factoryPattern.Factory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class ContractTest {

    private static Contract mainContract;
    private static List<InsuredPerson> personList;
    private static final Logger LOGGER = LogManager.getLogger("com.vdata.sagittarius.Demo");

    @BeforeAll
    static void before(){
        Factory f = new Factory();
        PhysicalClient first = (PhysicalClient)f.createClient(PersonType.PHYSICAL);
        JuridicalClient second = (JuridicalClient)f.createClient(PersonType.JURIDICAL);
        PhysicalClient third = (PhysicalClient)f.createClient(PersonType.PHYSICAL);

        first.setStreet("Pokrovska st. 32");
        first.setCity("Kharkiv");
        first.setFirstName("Anny");
        first.setMidName("Parker");
        first.setSurname("Linn");

        second.setStreet("Pokrovska st. 33");
        second.setCity("Kharkiv");
        second.setCompanyName("Disney");

        third.setStreet("Pokrovska st. 34");
        third.setCity("Kharkiv");
        third.setFirstName("Beny");
        third.setMidName("Harbour");
        third.setSurname("Linn");

//        Contract contract = new Contract();
//        contract.setClient(second);
//
//        InsuredPerson ip1= new InsuredPerson();
//        ip1.setContract(contract);
//        ip1.setPersonalCost(99);
//        ip1.setUniqueNum(100);
//        ip1.setClient(first);
//
//        InsuredPerson ip2= new InsuredPerson();
//        ip2.setContract(contract);
//        ip2.setPersonalCost(10);
//        ip2.setUniqueNum(675);
//        ip2.setClient(third);
//
//
//
//        List<InsuredPerson> persons = new ArrayList<>();
//        persons.add(ip1);
//        persons.add(ip2);
//
//        contract.setPersonList(persons);
//        contract.setAcceptDate(LocalDate.of(2000,9,10));
//        contract.setStartDate(LocalDate.of(2001,1,1));
//        contract.setEndDate(LocalDate.of(2010,12,31));
//
//        mainContract=contract;
//        personList=persons;



    }

    @Test
    void getTotalCost() {

        LOGGER.info( "test one");
        LOGGER.info( mainContract.getTotalCost());


    }

    @Test
    void getTotalCost1() {

        LOGGER.info( "test one");
        assert(mainContract.getTotalCost1()==109);

    }

    @Test
    void getTotalCost2() {

        LOGGER.info( "test 2");
        assert(mainContract.getTotalCost2()==109);

    }

    @Test
    void getTotalCost3() {

        LOGGER.info( "test 3");
        assert(mainContract.getTotalCost3()==109);

    }

    @Test
    void getTotalCost4() {

        LOGGER.info( "test 4");
        assert(mainContract.getTotalCost4()==109);

    }

    @Test
    void getTotalCost5() {

        LOGGER.info( "test 5");
        assert(mainContract.getTotalCost5()==109);

    }

    @Test
    void getTotalCost6() {

        LOGGER.info( "test 6");
        assert(mainContract.getTotalCost6()==109);

    }

    @Test
    void getTotalCost7() {

        LOGGER.info( "test 7");
        assert(mainContract.getTotalCost7()==109);

    }

    @Test
    void getTotalCost8() {

        LOGGER.info( "test 8");
        assert(mainContract.getTotalCost8()==109);

    }

}