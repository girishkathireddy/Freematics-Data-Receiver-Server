package com.lpr.track.dao;

import java.util.List;

import com.lpr.track.entity.Clients;
import com.lpr.track.exception.BusinessException;

public interface ClientDao {
   void add(Clients client)throws BusinessException;
   List<Clients> listClients()throws BusinessException;
}
