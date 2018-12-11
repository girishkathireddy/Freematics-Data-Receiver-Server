package com.lpr.track.dao;

import com.lpr.track.entity.Servers;
import com.lpr.track.exception.BusinessException;

import java.util.List;

public interface ServersDao {
    List<Servers> getServersInfo() throws BusinessException;


}
