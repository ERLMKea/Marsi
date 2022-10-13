package com.example.marsi.repository;

import com.example.marsi.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {

    List<Photo> findPhotoByDescriptionIsLike(String description);

    List<Photo> findPhotoByDescriptionIsLikeOrImgSrcLike(String description, String imgSrc);



}

