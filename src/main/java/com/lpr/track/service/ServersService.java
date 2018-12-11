package com.lpr.track.service;


import com.lpr.track.entity.Servers;
import com.lpr.track.exception.BusinessException;

import java.util.List;

public interface  ServersService {

    List<Servers> listServerDetails() throws BusinessException;
}
