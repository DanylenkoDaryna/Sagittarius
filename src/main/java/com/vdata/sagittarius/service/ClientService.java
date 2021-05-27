package com.vdata.sagittarius.service;

import com.vdata.sagittarius.dao.ClientDao;
import com.vdata.sagittarius.entity.Client;

public class ClientService implements IService {

    private ClientDao clientDao;

    @Override
    public ClientDao getDao() {

        if(clientDao==null){
            clientDao=new ClientDao();
            return clientDao;
        }
        else return clientDao;
    }

    public ClientService(){}

    public void createClient(Client client){
            getDao().create(client);

    }

    public Client readClient(int id){

        return getDao().read(id);
    }

    public void updateClient(Client client){

        getDao().update(client);
    }

    public void deleteClient(Client client){

        getDao().delete(client);
    }


}
