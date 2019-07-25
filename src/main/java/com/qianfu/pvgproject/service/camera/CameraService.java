package com.qianfu.pvgproject.service.camera;

import com.qianfu.pvgproject.pojo.Camera;

import java.util.List;

public interface CameraService {

    List<Camera> cameraList(Integer cameraId);
}
