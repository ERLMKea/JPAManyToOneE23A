package org.example.jpamanytoonee23a.model;

import org.example.jpamanytoonee23a.repository.RegionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RegionTest {

    @Autowired
    RegionRepository regionRepository;

    @Test
    void testDeleteAll() {
        Optional<Region> reg = regionRepository.findById("1081");

    }

}