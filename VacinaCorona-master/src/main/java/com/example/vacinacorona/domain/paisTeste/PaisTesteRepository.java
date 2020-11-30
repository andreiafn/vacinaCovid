package com.example.vacinacorona.domain.paisTeste;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PaisTesteRepository extends JpaRepository<PaisTeste, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO pais_teste (nome, num_participantes) " +
                    "VALUES(:nome, :numparticipantes)", nativeQuery = true)
    void inserir(@Param("nome") String nome, @Param("numparticipantes") String numparticipantes);
}
