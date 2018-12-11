package com.lpr.track.service;

import com.lpr.track.dao.DataDao;
import com.lpr.track.entity.Data;
import com.lpr.track.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DataServiceImpl implements DataService{

    @Autowired
    private DataDao dataDao;

    @Transactional
    @Override
    public void add(Data data) throws BusinessException {
     dataDao.add(data);
    }
}
