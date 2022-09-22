package com.example.marsi.controller;

import com.example.marsi.model.Photo;
import com.example.marsi.repository.CameraRepository;
import com.example.marsi.repository.PhotoRepository;
import com.example.marsi.repository.RoverRepository;
import com.example.marsi.service.ApiServicePhotos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
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

    @GetMapping("savedescr/{descr}")
    List<Photo> saveDescription(@PathVariable String descr) {
        List<Photo> lstPhoto = photoRepository.findAll();
        for (Photo ph: lstPhoto) {
            ph.setDescription(descr);
            photoRepository.save(ph);
        }
        return lstPhoto;
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

    @GetMapping("/photosdescr")
    List<Photo> getPhotosDesc() {
        List<Photo> lstPhotos = photoRepository.findAll();
        lstPhotos = lstPhotos.stream().filter(f -> Objects.nonNull(f.getDescription()))
                .filter(f -> f.getDescription().length()>0)
                .collect(Collectors.toList());
        return lstPhotos;
    }

    @GetMapping("/photosfromnavcamera")
    List<Photo> getPhotosFromNavCamera() {
        List<Photo> lstPhotos = photoRepository.findAll();
        lstPhotos = lstPhotos.stream().filter(f -> f.getCamera().getCameraId() == 26)
                .collect(Collectors.toList());
        return lstPhotos;
    }


}



