package com.lpr.track.entity;

import javax.persistence.*;

@Entity
@Table(name="ldata")
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="DATAID")
    private Integer dataID;

    @Column(name="DFEEDID")
    private Integer dfeedId;

    @Column(name="TEND")
    private Integer tenD;

    @Column(name="TENC")
    private Integer tenC;

    @Column(name="THRIBBLEONE")
    private Integer thribbleOne;

    @Column(name="ONEZEROFOUR")
    private Integer oneZeroFour;

    @Column(name="TENA")
    private Integer tenA;

    @Column(name="TENF")
    private Integer tenF;

    @Column(name="TWENTYFOUR")
    private Integer tewentyFour;

    @Column(name="THIRTY")
    private Integer thirty;

    @Column(name="TENE")
    private Integer tenE;

    @Column(name="ONEZEROFIVE")
    private Integer oneZeroFive ;

    @Column(name="TEN")
    private Long ten;

    @Column(name="A")
    private String gpsA;

    @Column(name="B")
    private String gpsB;

    @Column(name="C")
    private String gpsC;

    @Column(name="D")
    private String gpsD;

    @Column(name="F")
    private String gpsF;

    public Integer getDataID() {
        return dataID;
    }

    public void setDataID(Integer dataID) {
        this.dataID = dataID;
    }

    public Integer getDfeedId() {
        return dfeedId;
    }

    public void setDfeedId(Integer dfeedId) {
        this.dfeedId = dfeedId;
    }

    public Integer getTenD() {
        return tenD;
    }

    public void setTenD(Integer tenD) {
        this.tenD = tenD;
    }

    public Integer getTenC() {
        return tenC;
    }

    public void setTenC(Integer tenC) {
        this.tenC = tenC;
    }

    public Integer getThribbleOne() {
        return thribbleOne;
    }

    public void setThribbleOne(Integer thribbleOne) {
        this.thribbleOne = thribbleOne;
    }

    public Integer getOneZeroFour() {
        return oneZeroFour;
    }

    public void setOneZeroFour(Integer oneZeroFour) {
        this.oneZeroFour = oneZeroFour;
    }

    public Integer getTenA() {
        return tenA;
    }

    public void setTenA(Integer tenA) {
        this.tenA = tenA;
    }

    public Integer getTenF() {
        return tenF;
    }

    public void setTenF(Integer tenF) {
        this.tenF = tenF;
    }

    public Integer getTewentyFour() {
        return tewentyFour;
    }

    public void setTewentyFour(Integer tewentyFour) {
        this.tewentyFour = tewentyFour;
    }

    public Integer getThirty() {
        return thirty;
    }

    public void setThirty(Integer thirty) {
        this.thirty = thirty;
    }

    public Integer getTenE() {
        return tenE;
    }

    public void setTenE(Integer tenE) {
        this.tenE = tenE;
    }

    public Integer getOneZeroFive() {
        return oneZeroFive;
    }

    public void setOneZeroFive(Integer oneZeroFive) {
        this.oneZeroFive = oneZeroFive;
    }

    public Long getTen() {
        return ten;
    }

    public void setTen(Long ten) {
        this.ten = ten;
    }

    public String getGpsA() {
        return gpsA;
    }

    public void setGpsA(String gpsA) {
        this.gpsA = gpsA;
    }

    public String getGpsB() {
        return gpsB;
    }

    public void setGpsB(String gpsB) {
        this.gpsB = gpsB;
    }

    public String getGpsC() {
        return gpsC;
    }

    public void setGpsC(String gpsC) {
        this.gpsC = gpsC;
    }

    public String getGpsD() {
        return gpsD;
    }

    public void setGpsD(String gpsD) {
        this.gpsD = gpsD;
    }

    public String getGpsF() {
        return gpsF;
    }

    public void setGpsF(String gpsF) {
        this.gpsF = gpsF;
    }
}
