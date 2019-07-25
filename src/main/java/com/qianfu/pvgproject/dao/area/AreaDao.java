package com.qianfu.pvgproject.dao.area;

import com.qianfu.pvgproject.pojo.Area;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

public interface AreaDao {

    /*
        如果areaId为空，查询所有区域信息，
        如果areaId不为空，则根据 areaId 查询区域信息
        返回 list 集合
     */
    @SelectProvider(type = AreaDaoProvider.class,method = "areaList")
    @Results({
            @Result(property = "areaId",column = "area_id"),
            @Result(property = "areaName",column = "area_name"),
            @Result(property = "areaEqlist",column = "area_id",
                    many = @Many(select = "com.qianfu.pvgproject.dao.equipmentbox.EquipmentboxDao.getEqsByAreaId"))
    })
    List<Area> areaList(@Param(value = "areaId") Integer areaId);

    /*
     *  根据id 查询区域信息
     *  返回 area 对象
     */
    @SelectProvider(type = AreaDaoProvider.class,method = "getAreaById")
    Area getAreaById(@Param("id")Integer id);

    /*
        在内部类 构建SQL语句 （适用动态SQL）
     */
    class AreaDaoProvider{

        public String areaList(Integer areaId){
            return new SQL(){{
                SELECT("*");
                FROM("area");
                if(areaId!=null){
                    WHERE("area_id = #{areaId}");
                }
            }}.toString();
        }

        public String getAreaById(@Param("id")Integer id){
            return new SQL(){{
                SELECT("*");
                FROM("area");
                WHERE("area_id = "+id);
            }}.toString();
        }
    }
}
