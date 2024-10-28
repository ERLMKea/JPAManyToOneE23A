package org.example.jpamanytoonee23a.controller;


import org.example.jpamanytoonee23a.model.Kommune;
import org.example.jpamanytoonee23a.repository.KommuneRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class KommunePageController {

    //mit repositlory skal på git
    private final KommuneRepository kommuneRepository;

    public KommunePageController(KommuneRepository kommuneRepository) {
        this.kommuneRepository = kommuneRepository;
    }

    @GetMapping("kommunepage")
    public ResponseEntity<List<Kommune>> getPageOfKommuner() {
        int page = 4;
        int size = 5;
        Pageable kommunePage = PageRequest.of(page, size);
        Page<Kommune> pageKommune = kommuneRepository.findAll(kommunePage);
        List<Kommune> lstKommuner = pageKommune.getContent();
        return new ResponseEntity<>(lstKommuner, HttpStatus.OK);
    }

    @GetMapping("kommunepageparm")
    public ResponseEntity<Map<String, Object>> getPageOfKommuner(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue= "10") int size) {

        Pageable kommunePage = PageRequest.of(page, size);
        Page<Kommune> pageKommune = kommuneRepository.findAll(kommunePage);
        List<Kommune> lstKommuner = pageKommune.getContent();

        if (lstKommuner.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        Map<String, Object> response = new HashMap<String, Object>();
        response.put("kommuner", lstKommuner);
        response.put("currentpage", pageKommune.getNumber());
        response.put("totalItems", pageKommune.getTotalElements());
        response.put("totalPages", pageKommune.getTotalPages());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
