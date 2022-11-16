package com.example.marsi;

import com.example.marsi.model.Camera;
import com.example.marsi.repository.CameraRepository;
import com.example.marsi.repository.PhotoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MarsiApplicationTests {

    @Autowired
    CameraRepository cameraRepository;


    @Test
    void testSomeCameras() {
        List<Camera> cameras = cameraRepository.findAll();
        assertEquals(true, cameras.size()>0);
    }

    @Test
    void testCameraId() {
        Optional<Camera> opt = cameraRepository.findById(20);
        assertEquals(true, opt.isPresent());
    }


}
