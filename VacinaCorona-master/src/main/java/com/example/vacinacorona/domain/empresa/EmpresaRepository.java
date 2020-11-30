package com.example.vacinacorona.domain.empresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO empresa (nome_empresa) " +
                   "VALUES(:nomeEmpresa)", nativeQuery = true)
    void inserir(@Param("nomeEmpresa") String nomeEmpresa);

    @Query(value = "SELECT max(emp.idEmpresa) from Empresa emp")
    Long selectMaxId();
}
