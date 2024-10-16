package org.example.spring.service.dto.inscripcion.response;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.spring.model.Carrera;
import org.example.spring.model.Estudiante;
import org.example.spring.model.Inscripcion;
import org.example.spring.service.dto.carrera.request.CarreraRequestDTO;
import org.example.spring.service.dto.estudiante.request.EstudianteRequestDTO;

@Data
@RequiredArgsConstructor
public class InscripcionResponseDTO {

    private final int idInscripcion;

    private final Estudiante estudianteDTO;

    private final Carrera carreraDTO;

    private final int antiguedad;
    private  final boolean graduado;


    public InscripcionResponseDTO(Inscripcion i) {
        this.idInscripcion = i.getIdInscripcion();
        this.estudianteDTO = i.getEstudiante();
        this.carreraDTO = i.getCarrera();
        this.antiguedad = i.getAntiguedad();
        this.graduado = i.isGraduado();
    }
}
