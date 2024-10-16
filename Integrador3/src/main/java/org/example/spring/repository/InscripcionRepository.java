package org.example.spring.repository;

import org.example.spring.model.Estudiante;
import org.example.spring.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InscripcionRepository extends JpaRepository<Inscripcion,Integer> {
    @Query("SELECT t from Inscripcion t")
    public List<Inscripcion> findAll();
}
