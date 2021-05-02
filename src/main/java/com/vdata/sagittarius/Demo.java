package com.vdata.sagittarius;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Demo {

    private static final Logger LOGGER = LogManager.getLogger("com.vdata.sagittarius.Demo");


    public static void main(String[] args) {

        LOGGER.printf(Level.INFO, "Logging about my (not)friends %1$s and the %2$s ", "Nico", "niners.");

    }
}
