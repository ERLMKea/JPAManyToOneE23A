package org.example.jpamanytoonee23a.controller;

import org.example.jpamanytoonee23a.exception.ResourceNotFoundException;
import org.example.jpamanytoonee23a.model.Kommune;
import org.example.jpamanytoonee23a.model.Region;
import org.example.jpamanytoonee23a.repository.RegionRepository;
import org.example.jpamanytoonee23a.service.ApiServiceGetRegioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    @GetMapping("/regionx/{kode}")
    public ResponseEntity<Region> getRegionx(@PathVariable String kode) {
        Optional<Region> orgRegion = regionRepository.findById(kode);
        if (orgRegion.isPresent()) {
            return ResponseEntity.ok(orgRegion.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/region/{kode}")
    public ResponseEntity<Region> getRegion(@PathVariable String kode) {
       Region reg = regionRepository.findById(kode)
                .orElseThrow(() -> new ResourceNotFoundException("Region not found id=" + kode));
       return new ResponseEntity<>(reg, HttpStatus.OK);
    }

    @GetMapping("/kommunermedkode/{kode}")
    public ResponseEntity<Set<Kommune>> getKommunermedkode(@PathVariable String kode) {
        Optional<Region> regOpt = regionRepository.findById(kode);
        if (regOpt.isPresent()) {
            Region reg = regOpt.get();
            Set<Kommune> kommuner = reg.getKommuner();
            return new ResponseEntity<>(kommuner, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
