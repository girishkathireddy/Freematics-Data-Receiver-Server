package com.lpr.track.service;

import com.lpr.track.entity.ServerFeeds;
import com.lpr.track.entity.Servers;
import com.lpr.track.exception.BusinessException;

import java.util.Date;
import java.util.List;

public interface ServerFeedService {
    List<ServerFeeds> listServerFeedidDetails()throws BusinessException;

    List<ServerFeeds> getInfobyDateandKey(String serverKey, String vin, Date date) throws BusinessException;

    void add(ServerFeeds serverFeeds)throws BusinessException;
}
