package org.example.spring.repository;

import org.example.spring.model.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarreraRepository extends JpaRepository<Carrera, Integer> {

    @Query ("SELECT c FROM Carrera c WHERE SIZE(c.inscripciones) > 0 ORDER BY SIZE(c.inscripciones) DESC ")
    public List<Carrera> findAllByInscripciones();
    @Query("SELECT c FROM Carrera c where c.idCarrera = :idcarrera")
    public Carrera findByIdCarrera(int idcarrera);

    @Query(value = "SELECT c.nombre_carrera AS carrera, " +
            "(YEAR(CURRENT_DATE) - i.antiguedad) AS año, " +
            "COUNT(i.id_inscripcion) AS cantidad_inscriptos, " +
            "SUM(CASE WHEN i.graduado = TRUE THEN 1 ELSE 0 END) AS cantidad_egresados " +
            "FROM Carrera c " +
            "JOIN Inscripcion i ON c.id_carrera = i.id_carrera " +
            "JOIN Estudiante e ON i.id_estudiante = e.id_estudiante " +
            "GROUP BY c.nombre_carrera, (YEAR(CURRENT_DATE) - i.antiguedad) " +
            "ORDER BY c.nombre_carrera ASC, año ASC",
            nativeQuery = true)
    public List<Object[]> generarReporteCarreras();



}
