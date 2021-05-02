package com.vdata.sagittarius;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DemoLogger {

    //private static final Logger LOGGER = LogManager.getLogger("infoLog"); - not working
    //private static final Logger LOGGER = LogManager.getLogger("com.vdata.sagittarius.Demo");
    private static final Logger TRASH_LOGGER = LogManager.getLogger("logger for every trash idea");
    private static final Logger LOGGER = LogManager.getLogger("com.vdata.sagittarius.Demo");
    private static final Logger FLOGGER = LogManager.getFormatterLogger("com.vdata.sagittarius.Demo");

    public static void main(String[] args) {

        TRASH_LOGGER.debug("wanna write it into infoLog file directly? debug !!!");
        TRASH_LOGGER.info("wanna write it into infoLog file directly info !!!");
        TRASH_LOGGER.error("wanna write it into infoLog file directly error !!!");
        TRASH_LOGGER.trace("wanna write it into infoLog file directly trace !!!");
        FLOGGER.info("Long.MAX_VALUE = %,d", Long.MAX_VALUE);

        LOGGER.printf(Level.INFO, "Logging about my (not)friends %1$s and the %2$s ", "Nico", "niners.");

        LOGGER.atError().withThrowable(new NullPointerException()).log("Unable to process request due to {}",
                "help");
    }
}
