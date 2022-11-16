package com.example.marsi.service;

import com.example.marsi.model.Photo;

import java.util.List;

public interface PhotoService2 {

    List<Photo> findAllLastDigit(Integer digit);

    List<Photo> findAllFirstDigit(Integer digit);
}
