package com.example.vacinacorona.domain.vacina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Long> {
    @Query(value = "SELECT max(vac.id) from Vacina vac")
    Integer selectMaxId();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO vacina (idvacina, nome_vacina, estoque, id_fase_vacina, id_governo, id_empresa) " +
            "VALUES(:idvacina, :nome_vacina, :estoque, :id_fase_vacina, :id_governo, :id_empresa)", nativeQuery = true)
    void inserir(@Param("idvacina") Long idvacina,
                 @Param("nome_vacina") String nome_vacina,
                 @Param("estoque") String estoque,
                 @Param("id_fase_vacina") Long id_fase_vacina,
                 @Param("id_governo") Long id_governo,
                 @Param("id_empresa") Long id_empresa);
}
