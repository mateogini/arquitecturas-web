package org.example.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.spring.service.dto.estudiante.request.EstudianteRequestDTO;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEstudiante;
    private String nombre;

    private String apellido;

    private int edad;

    private String genero;

    private Long documento;

    private String ciudadResidencia;

    private int libretaUniversitaria;

    @OneToMany (mappedBy = "estudiante")
    @JsonIgnore
    private List<Inscripcion> inscripciones;


    public Estudiante(EstudianteRequestDTO request) {
        this.nombre = request.getNombre();
        this.apellido = request.getApellido();
        this.edad = request.getEdad();
        this.documento = request.getDocumento();
        this.genero = request.getGenero();
        this.ciudadResidencia = request.getCiudadResidencia();
        this.libretaUniversitaria = request.getLibretaUniversitaria();
        this.inscripciones = request.getInscripciones();
    }



}
