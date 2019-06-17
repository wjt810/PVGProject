package com.qianfu.pvgproject.dao.equipmentbox;

import com.qianfu.pvgproject.pojo.Equipmentbox;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import javax.persistence.criteria.CriteriaBuilder;
import java.awt.*;
import java.util.List;

public interface EquipmentboxDao {

    /*
     *  根据 id 查询设备箱
     *  如果 id 为空，返回 list列表
     */
    @SelectProvider(type = EqDaoProvider.class,method = "eqList")
    @Results({
            @Result(property = "eqId",column = "eq_id"),
            @Result(property = "eqEreaId",column = "eq_erea_id"),
            @Result(property = "eqArea",column = "eq_erea_id",
                    one = @One(select = "com.quanfu.pvgproject.dao.area.AreaDao.areaList"))
    })
    List<Equipmentbox> eqList(@Param("eqId") Integer eqId);

    /*
     *  根据 areaId(区域id) 查询设备箱列表
     *  返回 list集合
     */
    @SelectProvider(type = EqDaoProvider.class,method = "getEqsByAreaId")
    @Results({
            @Result(property = "eqId",column = "eq_id"),
            @Result(property = "eqCameraList",column = "eq_id",
                many = @Many(select = "com.qianfu.pvgproject.dao.camera.CameraDao.getCamerasByEqId"))
    })
    List<Equipmentbox> getEqsByAreaId(@Param("areaId") Integer areaId);

    /*
     *  根据 id 查询设备箱
     *  返回 eq 对象
     */
    @SelectProvider(type = EqDaoProvider.class,method = "getEqById")
    @Results({
            @Result(property = "eqAreaId",column = "eq_area_id"),
            @Result(property = "eqArea",column = "eq_area_id",one = @One(select = "com.qianfu.pvgproject.dao.area.AreaDao.getAreaById"))
    })
    Equipmentbox getEqById(@Param("eqId") Integer eqId);


    // ========================分割线===============================

    class EqDaoProvider{

        public String getEqsByAreaId(Integer areaId){
            return new SQL(){{
                SELECT("*");
                FROM("equipmentbox");
                if (areaId != null){
                    WHERE("eq_area_id = #{areaId}");
                }
            }}.toString();
        }

        public String eqList(Integer eqId){
            String sql = new SQL(){{
                SELECT("*");
                FROM("equipmentbox");
                if(eqId!=null){
                    WHERE("eq_id = #{eqId}");
                }
            }}.toString();
            System.out.println(sql);
            return sql;
        }

        public String getEqById(Integer id){
            return new SQL(){{
                SELECT("*");
                FROM("equipmentbox");
                WHERE("eq_id = #{id}");
            }}.toString();
        }
    }
}
