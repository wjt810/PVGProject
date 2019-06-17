package com.qianfu.pvgproject.service.area;

import com.qianfu.pvgproject.dao.area.AreaDao;
import com.qianfu.pvgproject.pojo.Area;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Resource
    public AreaDao areaDao;

    @Override
    public List<Area> areaList(Integer area_id) {
        return areaDao.areaList(area_id);
    }

}
