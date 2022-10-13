package com.example.marsi.controller;

import com.example.marsi.model.Photo;
import com.example.marsi.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class JPQLRESTController {

    @Autowired
    PhotoRepository photoRepository;

    @GetMapping("/photodesc/{descr}")
    List<Photo> getPhotosDescription(@PathVariable String descr) {
        return photoRepository.findPhotoByDescriptionIsLike("%" + descr + "%");
    }

    @GetMapping("photosmany")
    List<Photo> getPhotosMany(@RequestParam Map<String, String> requestParams) {
        String desc = requestParams.get("desc");
        String imgsrc = requestParams.get("imgsrc");
        return photoRepository.findPhotoByDescriptionIsLikeOrImgSrcLike("%"+desc+"%", "%"+imgsrc+"%");
    }
}
