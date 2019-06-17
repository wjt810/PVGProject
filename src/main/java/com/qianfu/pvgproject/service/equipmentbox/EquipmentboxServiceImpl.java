package com.qianfu.pvgproject.service.equipmentbox;

import com.qianfu.pvgproject.dao.equipmentbox.EquipmentboxDao;
import com.qianfu.pvgproject.pojo.Equipmentbox;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EquipmentboxServiceImpl implements EquipmentboxService {

    @Resource
    public EquipmentboxDao equipmentboxDao;

    @Override
    public List<Equipmentbox> eqList(Integer eqId) {
        return equipmentboxDao.eqList(eqId);
    }
}
