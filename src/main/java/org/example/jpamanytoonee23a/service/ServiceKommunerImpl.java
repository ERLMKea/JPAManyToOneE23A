package org.example.jpamanytoonee23a.service;

import org.example.jpamanytoonee23a.model.Kommune;
import org.example.jpamanytoonee23a.repository.KommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceKommunerImpl implements ServiceKommuner {

    @Autowired
    KommuneRepository kommuneRepository;

    @Override
    public List<Kommune> getKommunerStartsWith(Character c) {
        List<Kommune> lstKom = kommuneRepository.findAll();
        return lstKom.stream().filter(kom -> kom.getNavn().charAt(0) == c).toList();
    }

}
