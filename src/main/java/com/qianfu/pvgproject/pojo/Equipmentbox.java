package com.qianfu.pvgproject.pojo;

import java.util.List;

/*
    设备箱
 */
public class Equipmentbox {

    private Integer eqId;      // 设备箱id
    private String eqNumber;   // 设备箱编号
    private String eqInterchangerIP;   // 交换机IP
    private Integer eqAreaId;     // 区域id 外键

    private List<Camera> eqCameraList; // 摄像机 列表

    private Area eqArea;

    public Area getEqArea() {
        return eqArea;
    }

    public void setEqArea(Area eqArea) {
        this.eqArea = eqArea;
    }

    public Integer getEqId() {
        return eqId;
    }

    public void setEqId(Integer eqId) {
        this.eqId = eqId;
    }

    public String getEqNumber() {
        return eqNumber;
    }

    public void setEqNumber(String eqNumber) {
        this.eqNumber = eqNumber;
    }

    public String getEqInterchangerIP() {
        return eqInterchangerIP;
    }

    public void setEqInterchangerIP(String eqInterchangerIP) {
        this.eqInterchangerIP = eqInterchangerIP;
    }

    public Integer getEqAreaId() {
        return eqAreaId;
    }

    public void setEqAreaId(Integer eqAreaId) {
        this.eqAreaId = eqAreaId;
    }

    public List<Camera> getEqCameraList() {
        return eqCameraList;
    }

    public void setEqCameraList(List<Camera> eqCameraList) {
        this.eqCameraList = eqCameraList;
    }

    @Override
    public String toString() {
        return "Equipmentbox{" +
                "eqId=" + eqId +
                ", eqNumber='" + eqNumber + '\'' +
                ", eqInterchangerIP='" + eqInterchangerIP + '\'' +
                ", eqAreaId=" + eqAreaId +
                '}';
    }
}
