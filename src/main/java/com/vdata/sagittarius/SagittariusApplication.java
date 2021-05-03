package com.vdata.sagittarius;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@SpringBootApplication
public class SagittariusApplication implements CommandLineRunner {

	private static final Logger LOGGER = LogManager.getLogger(SagittariusApplication.class.getName());

	public static void main(String[] args) {

		SpringApplication.run(SagittariusApplication.class, args);

	}


    @Override
    public void run(String... strings) throws Exception {

    }

}
