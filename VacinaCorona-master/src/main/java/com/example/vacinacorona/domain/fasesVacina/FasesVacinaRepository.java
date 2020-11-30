package com.example.vacinacorona.domain.fasesVacina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface FasesVacinaRepository extends JpaRepository<FasesVacina, Long> {
    @Query(value = "SELECT max(fas.id) from FasesVacina fas")
    Integer selectMaxId();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO fases_vacina (idfases_vacina, fase1, fase2, fase3, fase4) " +
                    "VALUES(:idfases_vacina, :fase1, :fase2, :fase3, :fase4)", nativeQuery = true)
    void inserir(@Param("idfases_vacina") Long idfases_vacina,
                 @Param("fase1") String fase1,
                 @Param("fase2") String fase2,
                 @Param("fase3") String fase3,
                 @Param("fase4") String fase4);
}
