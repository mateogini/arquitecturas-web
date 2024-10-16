package org.example.spring.repository;

import org.example.spring.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante,Integer> {

    @Query("SELECT t from Estudiante t")
    public List<Estudiante> findAll();

    @Query("SELECT t from Estudiante t where t.nombre = :nombre")
    public List<Estudiante> findAllByName(String nombre);

    @Query("SELECT t from Estudiante t where t.documento = :documento")
    public Estudiante findAllByDocumento(Long documento);

    //c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
    @Query("SELECT t from Estudiante t order by t.apellido")
    public List<Estudiante> findAllOrderByApellido();

    //d) recuperar un estudiante, en base a su número de libreta universitaria
    @Query("SELECT t from Estudiante t where t.libretaUniversitaria = :libretaUniversitaria")
    public List<Estudiante> findAllByLibretaUniversitaria(int libretaUniversitaria);

    //e) recuperar todos los estudiantes, en base a su género.
    @Query("SELECT t from Estudiante t where t.genero = :genero")
    public List<Estudiante> findAllByGenero(String genero);
    //g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
    @Query("SELECT e FROM Estudiante e JOIN e.inscripciones i WHERE e.ciudadResidencia = :ciudadResidencia AND i.carrera.idCarrera = :carreraId")
    List<Estudiante> findByCiudadResidenciaAndCarreraId(@Param("ciudadResidencia") String ciudadResidencia, @Param("carreraId") int carreraId);

}
