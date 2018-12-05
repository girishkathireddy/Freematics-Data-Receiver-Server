package com.lpr.track.service;

import java.util.List;

import com.lpr.track.entity.Clients;

public interface ClientService {
    void add(Clients cleint);
    List<Clients> listClients();
}
