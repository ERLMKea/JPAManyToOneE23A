package org.example.jpamanytoonee23a.service;

import org.example.jpamanytoonee23a.model.Kommune;

import java.util.List;

public interface ServiceKommuner {

    List<Kommune> getKommunerStartsWith(Character c);


}
