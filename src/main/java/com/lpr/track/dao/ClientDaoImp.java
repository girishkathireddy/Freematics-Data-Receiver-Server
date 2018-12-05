package com.lpr.track.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.lpr.track.entity.Clients;
import org.springframework.stereotype.Repository;



@Repository
public class ClientDaoImp implements ClientDao {

   @PersistenceContext
   private EntityManager em;

   @Override
   public void add(Clients client) {
      em.persist(client);
   }

   @Override
   public List<Clients> listClients() {
      CriteriaQuery<Clients> criteriaQuery = em.getCriteriaBuilder().createQuery(Clients.class);
      @SuppressWarnings("unused")
      Root<Clients> root = criteriaQuery.from(Clients.class);
      return em.createQuery(criteriaQuery).getResultList();
   }

}
