package com.lpr.track.dao;

import com.lpr.track.entity.ServerFeeds;
import com.lpr.track.entity.Servers;
import com.lpr.track.exception.BusinessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class ServerFeedDaoImpl implements ServerFeedDao {


    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ServerFeeds> getServerFeedInfo() throws BusinessException{
        try {
            CriteriaQuery<ServerFeeds> criteriaQuery = em.getCriteriaBuilder().createQuery(ServerFeeds.class);
            @SuppressWarnings("unused")
            Root<ServerFeeds> root = criteriaQuery.from(ServerFeeds.class);
            return em.createQuery(criteriaQuery).getResultList();
        }catch (Exception e ){
            throw new BusinessException("Couldnt connect to database");
        }
    }

    @Override
    public List<ServerFeeds> getServerFeedbyDateAndKey(String serverKey, String vin, Date date) throws BusinessException{

        try {
            CriteriaBuilder qb = em.getCriteriaBuilder();
            CriteriaQuery cq = qb.createQuery();
            Root<ServerFeeds> sf = cq.from(ServerFeeds.class);

            //Constructing list of parameters
            List<Predicate> predicates = new ArrayList<Predicate>();

            //Adding predicates in case of parameter not being null
            if (serverKey != null) {
                predicates.add(
                        qb.equal(sf.get("sfskey"), serverKey));
            }
            if (date != null) {
                predicates.add(
                        qb.equal(sf.get("sfdate"), date));
            }
    //        if (vin != null) {
    //            predicates.add(
    //                    qb.equal(sf.get("sfvin"), vin));
    //        }

          //  cq.select(qb.max(sf.<Number>get("sffeedid")));
            //query itself
            cq.select(sf)
                    .where(predicates.toArray(new Predicate[]{}));
            //execute query and do something with result
          List<ServerFeeds> serverFeed=  em.createQuery(cq).getResultList();


            return serverFeed;
        }catch (Exception e ){
            throw new BusinessException("Couldnt connect to database");
        }
    }

    @Override
    public void add(ServerFeeds serverFeeds) throws BusinessException {
        try {
            em.persist(serverFeeds);
        }catch (Exception e ){
            throw new BusinessException("Couldnt connect to database");
        }
    }
}
