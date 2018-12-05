package com.lpr.track.entity;

import javax.persistence.*;

@Entity
@Table(name="lcli")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="CLIID")
    private Integer clientId;
    @Column(name="CLINAME")
    private String clientName;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}