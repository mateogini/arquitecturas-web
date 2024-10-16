package org.example.spring.service.dto.inscripcion.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import org.example.spring.model.Carrera;
import org.example.spring.model.Estudiante;
import org.example.spring.service.dto.carrera.request.CarreraRequestDTO;
import org.example.spring.service.dto.estudiante.request.EstudianteRequestDTO;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InscripcionRequestDTO {
    @NotNull( message = "El nombre es un campo obligatorio")
    private int idInscripcion;
    @NotNull( message = "El nombre es un campo obligatorio")
    private Estudiante estudiante;
    @NotNull( message = "El nombre es un campo obligatorio")
    private Carrera carrera;
    @NotNull( message = "El nombre es un campo obligatorio")
    private int antiguedad;
    @NotNull( message = "El nombre es un campo obligatorio")
    private boolean graduado;


}
