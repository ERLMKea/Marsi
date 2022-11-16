package com.example.marsi.mockito;

import com.example.marsi.model.Photo;
import com.example.marsi.service.PhotoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MockPhotoService {

    @Autowired
    PhotoService photoService;

    @Test
    void testPhotoService() {
        List<Photo> photos = photoService.findAllLastDigit(4);
        
    }

}
