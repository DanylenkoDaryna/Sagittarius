package com.vdata.sagittarius.service;

import com.vdata.sagittarius.dao.InsuredPersonDao;

public class InsuredPersonService implements IService {
    @Override
    public Object getDao() {
        return new InsuredPersonDao();
    }
}
