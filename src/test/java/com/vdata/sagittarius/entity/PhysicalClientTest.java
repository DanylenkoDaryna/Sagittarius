package com.vdata.sagittarius.entity;

import com.vdata.sagittarius.dao.ClientDao;
import com.vdata.sagittarius.entity.factoryPattern.Factory;
import com.vdata.sagittarius.service.ClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class PhysicalClientTest {

    private static final Logger LOGGER = LogManager.getLogger(PhysicalClientTest.class);

    @Test
    void getFirstName() {

        Factory f = new Factory();
        PhysicalClient pc = new PhysicalClient();
        pc.setFirstName("Frank");
        assert (pc.getFirstName().equals("Frank"));

    }

    @Test
    void getEmptyFirstName() {

        Factory f = new Factory();
        PhysicalClient pc = new PhysicalClient();
        pc.setFirstName("");
        assert (pc.getFirstName().isEmpty());

    }

    @Test
    void insertInDbPhysicalClient(){
        LOGGER.info("test insertion in db");

        PhysicalClient pc1 = new PhysicalClient();
        PhysicalClient pc2 = new PhysicalClient();

        pc1.setFirstName("Niko");
        pc1.setMidName("Feliksovych");
        pc1.setSurname("Mitzkevych");
        pc1.getClient().setCity("Krakiv");
        pc1.getClient().setStreet("Podolska st. 43");
        pc1.getClient().setPersonType(PersonType.PHYSICAL);

        pc2.setFirstName("Sara");
        pc1.setMidName("Feliksovych");
        pc1.setSurname("Mitzkevych");
        pc1.getClient().setCity("Viden");
        pc1.getClient().setStreet("Ragulska st. 50");
        pc1.getClient().setPersonType(PersonType.PHYSICAL);

        ClientService cs = new ClientService();
        cs.createClient(pc1);
        cs.createClient(pc2);

        assert(pc1.getSurname().equals(pc2.getSurname()));


    }
}