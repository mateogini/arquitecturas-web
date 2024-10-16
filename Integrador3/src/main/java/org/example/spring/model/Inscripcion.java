package org.example.spring.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.spring.service.dto.estudiante.request.EstudianteRequestDTO;
import org.example.spring.service.dto.inscripcion.request.InscripcionRequestDTO;

@Entity
@Data
@NoArgsConstructor
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idInscripcion;

    @ManyToOne
    @JoinColumn(name = "idEstudiante")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "idCarrera")
    private Carrera carrera;

    private int antiguedad;
    private boolean graduado;


    public Inscripcion(InscripcionRequestDTO request) {
        this.estudiante = request.getEstudiante();
        this.carrera = request.getCarrera();
        this.antiguedad = request.getAntiguedad();
        this.graduado = request.isGraduado();
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public boolean isGraduado() {
        return graduado;
    }

    public void setGraduado(boolean graduado) {
        this.graduado = graduado;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "idInscripcion=" + idInscripcion +
                ", estudiante=" + estudiante +
                ", carrera=" + carrera +
                ", antiguedad=" + antiguedad +
                ", graduado=" + graduado +
                '}';
    }
}
