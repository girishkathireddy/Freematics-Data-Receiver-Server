package com.lpr.track.dao;

import java.util.List;

import com.lpr.track.entity.Clients;

public interface ClientDao {
   void add(Clients client);
   List<Clients> listClients();
}
