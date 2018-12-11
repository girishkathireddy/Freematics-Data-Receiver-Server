package com.lpr.track.service;

import java.util.List;

import com.lpr.track.dao.ClientDao;
import com.lpr.track.entity.Clients;
import com.lpr.track.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author imssbora
 *
 */
@Service
public class ClientServiceImp implements ClientService {

   @Autowired
   private ClientDao clientDao;

   @Transactional
   @Override
   public void add(Clients client) throws BusinessException {
      clientDao.add(client);
   }

   @Transactional(readOnly = true)
   @Override
   public List<Clients> listClients() throws BusinessException{
      return clientDao.listClients();
   }

}
