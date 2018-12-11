package com.lpr.track.dao;

import com.lpr.track.entity.Data;
import com.lpr.track.exception.BusinessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DataDaoImpl implements  DataDao{


    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Data data) throws BusinessException {
        try {
         em.persist(data);
        }catch (Exception e ){
            throw new BusinessException("Couldnt connect to database");
        }
    }
}
