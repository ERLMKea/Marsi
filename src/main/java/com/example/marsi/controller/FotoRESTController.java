package com.example.marsi.controller;

import com.example.marsi.model.Photo;
import com.example.marsi.repository.CameraRepository;
import com.example.marsi.repository.PhotoRepository;
import com.example.marsi.repository.RoverRepository;
import com.example.marsi.service.ApiServicePhotos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FotoRESTController {

    @Autowired
    ApiServicePhotos apiServicePhotos;

    @Autowired
    PhotoRepository photoRepository;

    @Autowired
    CameraRepository cameraRepository;

    @Autowired
    RoverRepository roverRepository;

    @GetMapping("/photos")
    List<Photo> getPhotos() {
        return apiServicePhotos.getPhotos();
    }


    @GetMapping("/savephotos")
    List<Photo> savePhotos() {
        List<Photo> lstPhotos = apiServicePhotos.getPhotos();
        for (Photo ph: lstPhotos) {
            cameraRepository.save(ph.getCamera());
            roverRepository.save(ph.getRover());
            photoRepository.save(ph);
        }
        lstPhotos = photoRepository.findAll();
        return lstPhotos;

    }

}



