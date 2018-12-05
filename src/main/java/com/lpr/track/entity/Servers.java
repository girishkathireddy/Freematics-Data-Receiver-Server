package com.lpr.track.entity;


import javax.persistence.*;

@Entity
@Table(name="lserverinfo")
public class Servers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="SERID")
    private Integer serid;
    @Column(name="SCLIID")
    private Integer scliid;
    @Column(name="SFEEDIDMIN")
    private Integer sfeedidmin;
    @Column(name="SFEEDIDMAX")
    private Integer sfeedidmax;
    @Column(name="SERKEY")
    private String serkey;

    public Integer getSerid() {
        return serid;
    }

    public void setSerid(Integer serid) {
        this.serid = serid;
    }

    public Integer getScliid() {
        return scliid;
    }

    public void setScliid(Integer scliid) {
        this.scliid = scliid;
    }

    public Integer getSfeedidmin() {
        return sfeedidmin;
    }

    public void setSfeedidmin(Integer sfeedidmin) {
        this.sfeedidmin = sfeedidmin;
    }

    public Integer getSfeedidmax() {
        return sfeedidmax;
    }

    public void setSfeedidmax(Integer sfeedidmax) {
        this.sfeedidmax = sfeedidmax;
    }

    public String getSerkey() {
        return serkey;
    }

    public void setSerkey(String serkey) {
        this.serkey = serkey;
    }
}
