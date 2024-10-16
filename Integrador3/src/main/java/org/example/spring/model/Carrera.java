package org.example.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.spring.service.dto.carrera.request.CarreraRequestDTO;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCarrera;
    private String nombreCarrera;

    @OneToMany (mappedBy = "carrera")
    @JsonIgnore
    private List<Inscripcion> inscripciones;


    public Carrera(CarreraRequestDTO request) {
        this.nombreCarrera = request.getNombreCarrera();
        this.inscripciones = request.getInscripciones();
    }

}
