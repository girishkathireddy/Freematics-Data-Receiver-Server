package com.lpr.track.service;

import com.lpr.track.dao.ClientDao;
import com.lpr.track.dao.ServersDao;
import com.lpr.track.entity.Servers;
import com.lpr.track.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServersServiceImpl implements ServersService {

    @Autowired
    private ServersDao serversDao;


    @Override
    public List<Servers> listServerDetails() throws BusinessException {
        return serversDao.getServersInfo();
    }
}
