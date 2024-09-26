package org.example.jpamanytoonee23a.controller;

import org.example.jpamanytoonee23a.model.Region;
import org.example.jpamanytoonee23a.repository.RegionRepository;
import org.example.jpamanytoonee23a.service.ApiServiceGetRegioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class RegionRestController {

    @Autowired
    ApiServiceGetRegioner apiServiceGetRegioner;

    @Autowired
    RegionRepository regionRepository;

    @GetMapping("/getregioner")
    public List<Region> getRegionerRest() {
        List<Region> lst = apiServiceGetRegioner.getRegioner();
        return lst;
    }

    @PostMapping("/region")
    @ResponseStatus(HttpStatus.CREATED)
    public Region postRegion(@RequestBody Region region) {
        System.out.println(region);
        return regionRepository.save(region);
    }

    @GetMapping("regioner")
    public List<Region> getRegioner() {

        return regionRepository.findAll();
    }

    @GetMapping("/region/{kode}")
    public ResponseEntity<Region> putRegion(@PathVariable String kode) {
        Optional<Region> orgRegion = regionRepository.findById(kode);
        if (orgRegion.isPresent()) {
            return ResponseEntity.ok(orgRegion.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
