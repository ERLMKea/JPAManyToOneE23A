package org.example.jpamanytoonee23a.controller;

import org.example.jpamanytoonee23a.model.Kommune;
import org.example.jpamanytoonee23a.model.Region;
import org.example.jpamanytoonee23a.repository.KommuneRepository;
import org.example.jpamanytoonee23a.service.ApiServiceGetKommuner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/kommune")
    @ResponseStatus(HttpStatus.CREATED)
    public Kommune postKommune(@RequestBody Kommune kommune) {
        System.out.println(kommune);
        return kommuneRepository.save(kommune);
    }


}
