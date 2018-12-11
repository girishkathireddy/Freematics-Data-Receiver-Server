package com.lpr.track.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.lpr.track.entity.Clients;
import com.lpr.track.exception.BusinessException;
import org.springframework.stereotype.Repository;



@Repository
public class ClientDaoImp implements ClientDao {

   @PersistenceContext
   private EntityManager em;

   @Override
   public void add(Clients client) throws BusinessException {
      try {
        em.persist(client);
      }catch (Exception e ){
         throw new BusinessException("Couldnt connect to database");
      }
   }

   @Override
   public List<Clients> listClients() throws BusinessException{
      try {
         CriteriaQuery<Clients> criteriaQuery = em.getCriteriaBuilder().createQuery(Clients.class);
         @SuppressWarnings("unused")
         Root<Clients> root = criteriaQuery.from(Clients.class);
         return em.createQuery(criteriaQuery).getResultList();
      }catch (Exception e ){
         throw new BusinessException("Couldnt connect to database");
      }
   }

}
