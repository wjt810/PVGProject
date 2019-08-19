package com.qianfu.pvgproject.controller;

import com.qianfu.pvgproject.pojo.Area;
import com.qianfu.pvgproject.pojo.Camera;
import com.qianfu.pvgproject.pojo.Equipmentbox;
import com.qianfu.pvgproject.service.area.AreaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/area")
public class AreaController {

    @Resource
    public AreaService areaService;

    @RequestMapping("/selAreaList")
    public List<Area> areaList(){
        List<Area> alist = areaService.areaList(null);
        /*System.out.println("区域\t\t设备箱编号\t\t摄像机编号");
        for (Area a : alist) {
            System.out.println(a.getAreaName());
            for (Equipmentbox eq : a.getAreaEqlist()) {
                System.out.println("\t\t\t\t"+eq.getEqNumber());
                for (Camera c : eq.getEqCameraList()){
                    System.out.println("\t\t\t\t\t\t"+c.getCameraNumber());
                }
            }
        }*/
        return alist;
    }
}
