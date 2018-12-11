package com.lpr.track.dao;

import com.lpr.track.entity.Data;
import com.lpr.track.exception.BusinessException;

public interface DataDao {

    void add(Data data)throws BusinessException;
}
