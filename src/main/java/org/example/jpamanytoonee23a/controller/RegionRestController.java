package org.example.jpamanytoonee23a.controller;

import org.example.jpamanytoonee23a.model.Region;
import org.example.jpamanytoonee23a.service.ApiServiceGetRegioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegionRestController {

    @Autowired
    ApiServiceGetRegioner apiServiceGetRegioner;

    @GetMapping("/getregioner")
    public List<Region> getRegioner() {
        List<Region> lst = apiServiceGetRegioner.getRegioner();
        return lst;
    }


}
