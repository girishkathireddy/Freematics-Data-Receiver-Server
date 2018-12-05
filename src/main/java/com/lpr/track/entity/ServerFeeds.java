package com.lpr.track.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="lserverfeeds")
public class ServerFeeds {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="SFID")
    private Integer sfid;

    @Column(name="SFSKEY")
    private String sfskey;

    @Column(name="SFFEEDID")
    private Integer sffeedid;

    @Column(name="SFVIN")
    private String sfvin;

    @Column(name="SFDATE")
    private Date sfdate;

    public Integer getSfid() {
        return sfid;
    }

    public void setSfid(Integer sfid) {
        this.sfid = sfid;
    }

    public String getSfskey() {
        return sfskey;
    }

    public void setSfskey(String sfskey) {
        this.sfskey = sfskey;
    }

    public Integer getSffeedid() {
        return sffeedid;
    }

    public void setSffeedid(Integer sffeedid) {
        this.sffeedid = sffeedid;
    }

    public String getSfvin() {
        return sfvin;
    }

    public void setSfvin(String sfvin) {
        this.sfvin = sfvin;
    }

    public Date getSfdate() {
        return sfdate;
    }

    public void setSfdate(Date sfdate) {
        this.sfdate = sfdate;
    }
}
