package com.qianfu.pvgproject.service.camera;

import com.qianfu.pvgproject.dao.camera.CameraDao;
import com.qianfu.pvgproject.pojo.Camera;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CameraServiceImpl implements CameraService {

    @Resource
    public CameraDao cameraDao;

    @Override
    public List<Camera> cameraList(Integer cameraId) {
        return cameraDao.cameraList(cameraId);
    }
}
