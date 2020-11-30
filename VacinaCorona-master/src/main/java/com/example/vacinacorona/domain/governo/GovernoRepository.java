package com.example.vacinacorona.domain.governo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface GovernoRepository extends JpaRepository<Governo, Long> {

    @Modifying
    @Transactional
    @Query(value = "" +
            "INSERT INTO governo (nome) " +
            "VALUES(:nome)", nativeQuery = true)
    void inserir(@Param("nome") String nome);

    @Query(value = "SELECT max(gov.idGoverno) from Governo gov")
    Long selectMaxId();
}
