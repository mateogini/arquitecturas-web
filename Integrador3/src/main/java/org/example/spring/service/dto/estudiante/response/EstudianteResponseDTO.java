package org.example.spring.service.dto.estudiante.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.spring.model.Estudiante;
import org.example.spring.model.Inscripcion;

import java.util.List;

@Data
@RequiredArgsConstructor
public class EstudianteResponseDTO {

    private final int idEstudiante;
    private final String nombre;
    private final String apellido;
    private final int edad;
    private final String genero;
    private final Long documento;
    private final String ciudadResidencia;
    private final int libretaUniversitaria;

    private final List<Inscripcion> inscripciones;

    public EstudianteResponseDTO(Estudiante e) {
        this.idEstudiante = e.getIdEstudiante();
        this.nombre = e.getNombre();
        this.apellido = e.getApellido();
        this.edad = e.getEdad();
        this.documento = e.getDocumento();
        this.genero = e.getGenero();
        this.ciudadResidencia = e.getCiudadResidencia();
        this.libretaUniversitaria = e.getLibretaUniversitaria();
        this.inscripciones = e.getInscripciones();
    }


}
