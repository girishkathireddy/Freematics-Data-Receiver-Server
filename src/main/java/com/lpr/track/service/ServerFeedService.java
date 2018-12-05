package com.lpr.track.service;

import com.lpr.track.entity.ServerFeeds;
import com.lpr.track.entity.Servers;

import java.util.Date;
import java.util.List;

public interface ServerFeedService {
    List<ServerFeeds> listServerFeedidDetails();

    List<ServerFeeds> getInfobyDateandKey(String serverKey, String vin, Date date);

    void add(ServerFeeds serverFeeds);
}
