package com.qianfu.pvgproject.dao.camera;

import com.qianfu.pvgproject.pojo.Camera;
import jdk.nashorn.internal.objects.annotations.Where;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public interface CameraDao {

    /*
     *  根据 id 查询 摄像机
     *  如果 id 为 null 返回 list 集合
     */
    @SelectProvider(type = CameraDaoProvider.class,method = "cameraList")
    @Results(value = {
        @Result(property = "cameraId",column = "camera_id"),
        @Result(property = "cameraEqId",column = "camera_eq_id"),
        @Result(property = "cameraEq",column = "camera_eq_id",one=@One(select = "com.qianfu.pvgproject.dao.equipmentbox.EquipmentboxDao.getEqById"))
    })
    List<Camera> cameraList(@Param("cameraId") Integer cameraId);

    /*
     *  根据 eqId(设备箱) 查询摄像机
     *  返回 list 集合对象
     */
    @SelectProvider(type = CameraDaoProvider.class,method = "getCamerasByEqId")
    List<Camera> getCamerasByEqId(@Param("eqId") Integer eqId);


    // =========================分割线========================
    class CameraDaoProvider{

        public String getCamerasByEqId(Integer eqId){
            return new SQL(){{
                SELECT("*");
                FROM("camera");
                if(eqId!=null){
                    WHERE("camera_eq_id = #{eqId}");
                }

            }}.toString();
        }

        public String cameraList(@Param("cameraId") Integer cameraId){
            return new SQL(){{
                SELECT("*");
                FROM("camera");
                if(cameraId !=null){
                    WHERE("camera_id = #{cameraId}");
                }
            }}.toString();
        }
    }
}
