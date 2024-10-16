package org.example.spring.service.dto.carrera.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;

import org.example.spring.model.Inscripcion;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarreraRequestDTO {

    private int idCarrera;
    @NotNull( message = "El nombre es un campo obligatorio")
    @NotEmpty(message = "El nombre del campo no puede estar vacío.")
    private String nombreCarrera;
    private List<Inscripcion> inscripciones = new ArrayList<>();;


}
