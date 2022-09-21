package com.example.marsi.repository;

import com.example.marsi.model.Camera;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CameraRepository extends JpaRepository<Camera, Integer> {
}
