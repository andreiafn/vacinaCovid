package com.example.vacinacorona.domain.efeitosColaterais;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EfeitosColateraisRepository extends JpaRepository<EfeitosColaterais, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO efeitos_colaterais (descricao, comum, incomum, raro) " +
            "VALUES(:descricao, :comum, :incomum, :raro)", nativeQuery = true)
    void inserir(@Param("descricao") String descricao,
                 @Param("comum") String comum,
                 @Param("incomum") String incomum,
                 @Param("raro") String raro);
}
