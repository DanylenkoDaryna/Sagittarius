package com.vdata.sagittarius.service;

import com.vdata.sagittarius.dao.ContractDao;

public class ContractService implements IService {

    @Override
    public Object getDao() {
        return new ContractDao();
    }
}
