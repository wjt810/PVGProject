package com.qianfu.pvgproject.controller;

import com.qianfu.pvgproject.pojo.Camera;
import com.qianfu.pvgproject.service.camera.CameraService;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/camera")
public class CameraController {
    @Resource
    public CameraService cameraService;

    @RequestMapping("selCamera")
    @ResponseBody
    public List<Camera> selCameraList(Model m,
                                @RequestParam(value = "field",required = false) String field, @RequestParam(value = "text",required = false) String text){
        System.out.println(field+"\t"+text);
        List<Camera> cameraList = cameraService.cameraList(null);
        if (field != null && text!=null && field!="" && text!=""){
            // 判断用户选择的字段
            cameraList = chooseField(cameraList,field,text);
        }
        /*System.out.println("摄像机编号\t 设备箱 \t 区域");
        for (Camera c: cameraList) {
            System.out.println(c.getCameraNumber()+"\t"+c.getCameraEq().getEqNumber()+"\t"+c.getCameraEq().getEqArea().getAreaName());
        }*/
        return cameraList;
    }

    // 判断用户选择的字段
    private List<Camera> chooseField(List<Camera> cameraList,String field,String text){
        List<Camera> cameras = null;
        if(field.equals("areaName")){
            cameras = selAreaName(cameraList,text);
            return cameras;
        }
        if(field.equals("eqNumber") ){
            cameras = selEqNumber(cameraList,text);
            return cameras;
        }
        if(field.equals("eqInterchangerIP") ){
            cameras = selEqInterchangerIP(cameraList,text);
            return cameras;
        }
        if(field.equals("cameraNumber") ){
            cameras = selCameraNumber(cameraList,text);
            return cameras;
        }
        if(field.equals("cameraProductNumber") ){
            cameras = selCameraProductNumber(cameraList,text);
            return cameras;
        }
        if(field.equals("cameraIP") ){
            cameras = selCameraIP(cameraList,text);
            return cameras;
        }
        if(field.equals("cameraComment") ){
            cameras = selCameraComment(cameraList,text);
            return cameras;
        }
        return null;
    }


    // 根据前端选择的字段进行 模糊查询
    private List<Camera> selAreaName(List<Camera> cameraList,String text) {
        List<Camera> cameras = null;
        for (Camera c : cameraList) {
            if (c.getCameraEq().getEqArea().getAreaName().equals(text)) {
                cameras.add(c);
            }
        }
        return cameras;
    }
    private List<Camera> selEqNumber(List<Camera> cameraList,String text) {
        List<Camera> cameras = null;
        for (Camera c : cameraList) {
            if (c.getCameraEq().getEqNumber().equals(text)) {
                cameras.add(c);
            }
        }
        return cameras;
    }
    private List<Camera> selEqInterchangerIP(List<Camera> cameraList,String text) {
        List<Camera> cameras = null;
        for (Camera c : cameraList) {
            if (c.getCameraEq().getEqInterchangerIP().equals(text)) {
                cameras.add(c);
            }
        }
        return cameras;
    }
    private List<Camera> selCameraNumber(List<Camera> cameraList,String text) {
        List<Camera> cameras = null;
        for (Camera c : cameraList) {
            if (c.getCameraNumber().equals(text)) {
                cameras.add(c);
            }
        }
        return cameras;
    }
    private List<Camera> selCameraProductNumber(List<Camera> cameraList,String text) {
        List<Camera> cameras = null;
        for (Camera c : cameraList) {
            if (c.getCameraProductNumber().equals(text)) {
                cameras.add(c);
            }
        }
        return cameras;
    }
    private List<Camera> selCameraIP(List<Camera> cameraList,String text) {
        List<Camera> cameras = null;
        for (Camera c : cameraList) {
            if (c.getCameraIP().equals(text)) {
                cameras.add(c);
            }
        }
        return cameras;
    }
    private List<Camera> selCameraComment(List<Camera> cameraList,String text) {
        List<Camera> cameras = null;
        for (Camera c : cameraList) {
            if (c.getCameraComment().equals(text)) {
                cameras.add(c);
            }
        }
        return cameras;
    }
}
