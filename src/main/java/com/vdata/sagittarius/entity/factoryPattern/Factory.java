package com.vdata.sagittarius.entity.factoryPattern;

import com.vdata.sagittarius.entity.Client;
import com.vdata.sagittarius.entity.JuridicalClient;
import com.vdata.sagittarius.entity.PersonType;
import com.vdata.sagittarius.entity.PhysicalClient;

public class Factory {

    public Client createClient(PersonType person){


        switch (person){
            case PHYSICAL: {
                return new PhysicalClient();
            }
            case JURIDICAL: {
                return new JuridicalClient();
            }
            default:{
                return null;
            }
        }

    }

    public void someOperation(){

    }
}
