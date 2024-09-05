package org.example.jpamanytoonee23a.service;

import org.example.jpamanytoonee23a.model.Kommune;
import org.example.jpamanytoonee23a.repository.KommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiServiceGetKommunerImpl implements ApiServiceGetKommuner {

    private final RestTemplate restTemplate;
    public ApiServiceGetKommunerImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    KommuneRepository KommuneRepository;

    String KommuneUrl = "https://api.dataforsyningen.dk/kommuner";

    private void saveKommuner(List<Kommune> kommuneer) {
        kommuneer.forEach(reg -> KommuneRepository.save(reg));
    }

    @Override
    public List<Kommune> getKommuner() {
        ResponseEntity<List<Kommune>> KommuneResponse =
                restTemplate.exchange(KommuneUrl,
                        HttpMethod.GET, null, new      ParameterizedTypeReference<List<Kommune>>(){
                        });
        List<Kommune> kommuner = KommuneResponse.getBody();
        saveKommuner(kommuner);
        return kommuner;
    }



}
