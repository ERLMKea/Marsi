package com.example.marsi.controller;


import com.example.marsi.model.Photo;
import com.example.marsi.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "pag/")
public class PagingController {

    @Autowired
    PhotoRepository photoRepository;

    @GetMapping("page4")
    public ResponseEntity<List<Photo>> getPageOfPhotos4() {
        int page = 4;
        int size = 5;
        PageRequest pageRequest = PageRequest.of(page, size);

        Page<Photo> pagePhoto = photoRepository.findAll(pageRequest);
        List<Photo> lstCounties = pagePhoto.getContent();
        if (lstCounties.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(lstCounties, HttpStatus.OK);
    }

    @GetMapping("page")
    public ResponseEntity<List<Photo>> getPageOfPhotos(@RequestParam int page, @RequestParam int size) {
        PageRequest pageRequest = PageRequest.of(page, size);

        Page<Photo> pagePhoto = photoRepository.findAll(pageRequest);
        List<Photo> lstCounties = pagePhoto.getContent();
        if (lstCounties.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(lstCounties, HttpStatus.OK);

    }

}