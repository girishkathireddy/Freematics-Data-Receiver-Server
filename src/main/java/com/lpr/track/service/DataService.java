package com.lpr.track.service;

import com.lpr.track.entity.Data;
import com.lpr.track.exception.BusinessException;

public interface DataService {

    void add(Data data) throws BusinessException;
}
