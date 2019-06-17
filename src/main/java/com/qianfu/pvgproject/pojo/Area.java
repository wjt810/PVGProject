package com.qianfu.pvgproject.pojo;

import java.util.List;

/*
    区域
 */
public class Area {

    private Integer areaId;    // 区域id
    private String  areaName;  // 区域名称

    private List<Equipmentbox> areaEqlist; // 设备箱

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public List<Equipmentbox> getAreaEqlist() {
        return areaEqlist;
    }

    public void setAreaEqlist(List<Equipmentbox> areaEqlist) {
        this.areaEqlist = areaEqlist;
    }

    @Override
    public String toString() {
        return "Area{" +
                "areaId=" + areaId +
                ", areaName='" + areaName + '\'' +
                '}';
    }
}
