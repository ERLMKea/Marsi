package com.example.marsi.repository;

import com.example.marsi.model.Rover;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoverRepository extends JpaRepository<Rover, Integer> {
}
