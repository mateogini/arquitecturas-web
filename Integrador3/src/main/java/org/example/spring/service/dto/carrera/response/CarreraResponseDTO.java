package org.example.spring.service.dto.carrera.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.spring.model.Carrera;
import org.example.spring.model.Inscripcion;

import java.util.List;

@Data
@RequiredArgsConstructor
public class CarreraResponseDTO {

    private final int idCarrera;

    private final String nombreCarrera;

    private final List<Inscripcion> inscripciones;


    public CarreraResponseDTO(Carrera c) {
        this.idCarrera = c.getIdCarrera();
        this.nombreCarrera = c.getNombreCarrera();
        this.inscripciones = c.getInscripciones();
    }
}
