package com.lpr.track.dao;

import com.lpr.track.entity.Clients;
import com.lpr.track.entity.ServerFeeds;
import com.lpr.track.exception.BusinessException;

import java.util.Date;
import java.util.List;

public interface ServerFeedDao {

    void add(ServerFeeds serverFeeds) throws BusinessException;

    List<ServerFeeds> getServerFeedInfo() throws BusinessException;

    List<ServerFeeds> getServerFeedbyDateAndKey(String serverKey, String vin, Date date) throws BusinessException;
}
