package com.lpr.track.service;

import com.lpr.track.dao.ServerFeedDao;
import com.lpr.track.entity.ServerFeeds;
import com.lpr.track.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ServerFeedServiceImpl implements ServerFeedService {
    @Autowired
    private ServerFeedDao serverFeedDao;

    @Override
    public List<ServerFeeds> listServerFeedidDetails() throws BusinessException {
        return serverFeedDao.getServerFeedInfo();
    }

    @Override
    public List<ServerFeeds> getInfobyDateandKey(String serverKey, String vin, Date date)throws BusinessException{

        return serverFeedDao.getServerFeedbyDateAndKey(serverKey,vin,date);
    }

    @Transactional
    @Override
    public void add(ServerFeeds serverFeeds) throws BusinessException{
        serverFeedDao.add(serverFeeds);
    }
}
