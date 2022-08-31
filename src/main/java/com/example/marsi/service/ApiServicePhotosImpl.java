package com.example.marsi.service;

import com.example.marsi.model.Foto;
import com.example.marsi.model.Photo;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ApiServicePhotosImpl implements ApiServicePhotos{

    private RestTemplate restTemplate;
    public ApiServicePhotosImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public List<Photo> getPhotos() {
        ResponseEntity<Foto> photoResponse =
                restTemplate.exchange(rogerUrl,
                        HttpMethod.GET, null, new ParameterizedTypeReference<Foto>() {
                        });
        Foto foto = photoResponse.getBody();
        List<Photo> photos =  foto.getPhotos();
        return photos;

    }
}
