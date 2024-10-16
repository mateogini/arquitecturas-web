package org.example.spring.service.dto.estudiante.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.spring.model.Inscripcion;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EstudianteRequestDTO {

    private int idEstudiante;
    @NotNull( message = "El nombre es un campo obligatorio")

    private String nombre;
    @NotNull( message = "El nombre es un campo obligatorio")

    private String apellido;
    @NotNull( message = "El nombre es un campo obligatorio")

    private int edad;
    @NotNull( message = "El nombre es un campo obligatorio")

    private String genero;
    @NotNull( message = "El nombre es un campo obligatorio")

    private Long documento;
    @NotNull( message = "El nombre es un campo obligatorio")

    private String ciudadResidencia;
    @NotNull( message = "El nombre es un campo obligatorio")

    private int libretaUniversitaria;

    private List<Inscripcion> inscripciones;


}
