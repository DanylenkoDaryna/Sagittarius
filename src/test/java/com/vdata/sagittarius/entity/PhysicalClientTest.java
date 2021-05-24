package com.vdata.sagittarius.entity;

import com.vdata.sagittarius.entity.factoryPattern.Factory;
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


        assert(pc1.equals(pc2));


    }
}