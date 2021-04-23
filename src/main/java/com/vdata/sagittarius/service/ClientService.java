package com.vdata.sagittarius.service;

import com.vdata.sagittarius.dao.ClientDao;

public class ClientService implements IService {

    @Override
    public Object getDao() {
        return new ClientDao();
    }
}
