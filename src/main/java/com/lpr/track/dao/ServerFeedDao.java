package com.lpr.track.dao;

import com.lpr.track.entity.Clients;
import com.lpr.track.entity.ServerFeeds;

import java.util.Date;
import java.util.List;

public interface ServerFeedDao {

    void add(ServerFeeds serverFeeds);

    List<ServerFeeds> getServerFeedInfo();

    List<ServerFeeds> getServerFeedbyDateAndKey(String serverKey, String vin, Date date);
}
