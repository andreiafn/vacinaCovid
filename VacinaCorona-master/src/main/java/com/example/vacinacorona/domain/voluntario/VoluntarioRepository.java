package com.example.vacinacorona.domain.voluntario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoluntarioRepository extends JpaRepository<Voluntario, Long> {

    @Query(value = "SELECT max(vol.idVoluntario) from Voluntario vol")
    Integer selectMaxId();
}
