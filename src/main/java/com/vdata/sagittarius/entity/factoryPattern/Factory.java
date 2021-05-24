package com.vdata.sagittarius.entity.factoryPattern;

import com.vdata.sagittarius.entity.*;

public class Factory {

    public IClient createClient(PersonType person){
        Client client = new Client();

        switch (person){
            case PHYSICAL: {
                client = new PhysicalClient();
                client.setPersonType(PersonType.PHYSICAL);
                break;
            }
            case JURIDICAL: {
                client = new JuridicalClient();
                client.setPersonType(PersonType.JURIDICAL);
                break;
            }
        }
        return client;
    }

    public void someOperation(){

    }
}
