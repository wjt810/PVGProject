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
        if (field!=null&text!=null){
            cameraList = selCameraByField(cameraList,field,text);
        }
        /*System.out.println("摄像机编号\t 设备箱 \t 区域");
        for (Camera c: cameraList) {
            System.out.println(c.getCameraNumber()+"\t"+c.getCameraEq().getEqNumber()+"\t"+c.getCameraEq().getEqArea().getAreaName());
        }*/
        return cameraList;
    }

    // 根据前端选择的字段进行 模糊查询
    private List<Camera> selCameraByField(List<Camera> cameraList,String field,String text){
        List<Camera> cameras = null;
        if(field.equals("areaName")){
            for (Camera c: cameraList) {
                if(c.getCameraEq().getEqArea().getAreaName().equals(text)){
                    cameras.add(c);
                }
            }
        }
        if(field.equals("eqNumber") ){
            for (Camera c: cameraList) {
                if(c.getCameraEq().getEqNumber().equals(text)){
                    cameras.add(c);
                }
            }
        }
        if(field.equals("eqInterchangerIP") ){
            for (Camera c: cameraList) {
                if(c.getCameraEq().getEqInterchangerIP().equals(text)){
                    cameras.add(c);
                }
            }
        }
        if(field.equals("cameraNumber") ){
            for (Camera c: cameraList) {
                if(c.getCameraNumber().equals(text)){
                    cameras.add(c);
                }
            }
        }
        if(field.equals("cameraProductNumber") ){
            for (Camera c: cameraList) {
                if(c.getCameraProductNumber().equals(text)){
                    cameras.add(c);
                }
            }
        }
        if(field.equals("cameraIP") ){
            for (Camera c: cameraList) {
                if(c.getCameraIP().equals(text)){
                    cameras.add(c);
                }
            }
        }
        if(field.equals("cameraComment") ){
            for (Camera c: cameraList) {
                if(c.getCameraComment().equals(text)){
                    cameras.add(c);
                }
            }
        }
        return cameras;
    }
}
