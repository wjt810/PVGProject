package com.qianfu.pvgproject.controller;

import com.qianfu.pvgproject.pojo.Camera;
import com.qianfu.pvgproject.service.camera.CameraService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/camera")
public class CameraController {
    @Resource
    public CameraService cameraService;

    @RequestMapping("selCamera")
    public String selCameraList(Model m){
        List<Camera> cameraList = cameraService.cameraList(null);
        m.addAttribute("cameraList",cameraList);
        /*System.out.println("摄像机编号\t 设备箱 \t 区域");
        for (Camera c: cameraList) {
            System.out.println(c.getCameraNumber()+"\t"+c.getCameraEq().getEqNumber()+"\t"+c.getCameraEq().getEqArea().getAreaName());
        }*/
        return "/test/index";
    }
}
