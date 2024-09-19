package org.example.jpamanytoonee23a.controller;

import org.example.jpamanytoonee23a.model.Kommune;
import org.example.jpamanytoonee23a.repository.KommuneRepository;
import org.example.jpamanytoonee23a.service.ApiServiceGetKommuner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class KommuneRestController {

    @Autowired
    ApiServiceGetKommuner apiServiceGetKommuner;

    @Autowired
    KommuneRepository kommuneRepository;

    @GetMapping("getkommuner")
    public List<Kommune> getKommunerRest() {
        return apiServiceGetKommuner.getKommuner();
    }

    @GetMapping("kommuner")
    public List<Kommune> getKommuner() {

        return kommuneRepository.findAll();
    }


}
