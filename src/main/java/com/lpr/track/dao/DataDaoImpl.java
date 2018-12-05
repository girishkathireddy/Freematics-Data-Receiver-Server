package com.lpr.track.dao;

import com.lpr.track.entity.Data;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DataDaoImpl implements  DataDao{


    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Data data) {
        em.persist(data);
    }
}
