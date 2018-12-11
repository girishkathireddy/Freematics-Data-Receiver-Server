package com.lpr.track.dao;

import com.lpr.track.entity.Clients;
import com.lpr.track.entity.Servers;
import com.lpr.track.exception.BusinessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ServersDaoImp implements ServersDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Servers> getServersInfo() throws BusinessException {

        try {
            CriteriaQuery<Servers> criteriaQuery = em.getCriteriaBuilder().createQuery(Servers.class);
            @SuppressWarnings("unused")
            Root<Servers> root = criteriaQuery.from(Servers.class);
            return em.createQuery(criteriaQuery).getResultList();

        }catch (Exception e ){
            throw new BusinessException("Couldnt connect to database");
        }
    }
}
