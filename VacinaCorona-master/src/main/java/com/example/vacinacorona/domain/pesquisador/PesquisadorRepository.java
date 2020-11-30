package com.example.vacinacorona.domain.pesquisador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PesquisadorRepository extends JpaRepository<Pesquisador, Long> {

    @Query(value = "SELECT max(pes.id) from Pesquisador pes")
    Integer selectMaxId();
}
