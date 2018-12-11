package com.lpr.track.service;

import java.util.List;

import com.lpr.track.entity.Clients;
import com.lpr.track.exception.BusinessException;

public interface ClientService {
    void add(Clients cleint)throws BusinessException;
    List<Clients> listClients() throws BusinessException;
}
