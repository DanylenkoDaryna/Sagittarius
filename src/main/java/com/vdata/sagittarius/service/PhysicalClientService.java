package com.vdata.sagittarius.service;

import com.vdata.sagittarius.dao.PhysicalClientDao;
import com.vdata.sagittarius.entity.PhysicalClient;

public class PhysicalClientService implements IService{

    private PhysicalClientDao physicalClientDao;

    @Override
    public PhysicalClientDao getDao() {

        if(physicalClientDao==null){
            physicalClientDao=new PhysicalClientDao();
            return physicalClientDao;
        }
        else return physicalClientDao;
    }

    public PhysicalClientService(){}

    public void createClient(PhysicalClient client){
        getDao().create(client);

    }

    public PhysicalClient readPhysicalClient(int id){

        return getDao().read(id);
    }

    public void updatePhysicalClient(PhysicalClient client){

        getDao().update(client);
    }

    public void deletePhysicalClient(PhysicalClient client){

        getDao().delete(client);
    }

}
