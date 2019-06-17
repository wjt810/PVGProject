package com.qianfu.pvgproject.pojo;

/*
    摄像机
 */
public class Camera {

    private Integer cameraId;      // 摄像机id
    private Integer cameraEqId;   // 摄像机 所属区域 id
    private String cameraNumber;   // 摄像机编号
    private String cameraProductNumber;   // 产品序号
    private String cameraIP;       // 摄像机IP
    private String cameraComment;  // 备注

    private Equipmentbox cameraEq;

    public Equipmentbox getCameraEq() {
        return cameraEq;
    }

    public void setCameraEq(Equipmentbox cameraEq) {
        this.cameraEq = cameraEq;
    }

    public Integer getCameraId() {
        return cameraId;
    }

    public void setCameraId(Integer cameraId) {
        this.cameraId = cameraId;
    }

    public Integer getCameraEqId() {
        return cameraEqId;
    }

    public void setCameraEqId(Integer cameraEqId) {
        this.cameraEqId = cameraEqId;
    }

    public String getCameraNumber() {
        return cameraNumber;
    }

    public void setCameraNumber(String cameraNumber) {
        this.cameraNumber = cameraNumber;
    }

    public String getCameraProductNumber() {
        return cameraProductNumber;
    }

    public void setCameraProductNumber(String cameraProductNumber) {
        this.cameraProductNumber = cameraProductNumber;
    }

    public String getCameraIP() {
        return cameraIP;
    }

    public void setCameraIP(String cameraIP) {
        this.cameraIP = cameraIP;
    }

    public String getCameraComment() {
        return cameraComment;
    }

    public void setCameraComment(String cameraComment) {
        this.cameraComment = cameraComment;
    }

    @Override
    public String toString() {
        return "Camera{" +
                "cameraId=" + cameraId +
                ", cameraEqId=" + cameraEqId +
                ", cameraNumber='" + cameraNumber + '\'' +
                ", cameraProductNumber='" + cameraProductNumber + '\'' +
                ", cameraIP='" + cameraIP + '\'' +
                ", cameraComment='" + cameraComment + '\'' +
                '}';
    }
}
