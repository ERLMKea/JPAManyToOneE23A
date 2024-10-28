package org.example.jpamanytoonee23a.repository;


import org.example.jpamanytoonee23a.model.Kommune;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface KommuneRepository extends JpaRepository<Kommune, String> {

    Optional<Kommune> findByNavn(String kommuneName);

    List<Kommune> findByNavnLike(String kommuneName);

    Optional<Kommune> findByNavnAndHref(String kommuneName, String href);

}
