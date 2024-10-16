package org.example.spring.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.spring.model.Estudiante;
import org.example.spring.repository.EstudianteRepository;
import org.example.spring.service.dto.estudiante.request.EstudianteRequestDTO;
import org.example.spring.service.dto.estudiante.response.EstudianteResponseDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstudianteServicio {
    private final EstudianteRepository estudianteRepository;

    @Transactional
    public EstudianteResponseDTO save(EstudianteRequestDTO request){
        final var estudiante = new Estudiante(request);
        final var result = this.estudianteRepository.save(estudiante);
        return new EstudianteResponseDTO(result.getIdEstudiante(), result.getNombre(),result.getApellido(),result.getEdad(),result.getGenero(),result.getDocumento(),result.getCiudadResidencia(), result.getLibretaUniversitaria(), result.getInscripciones());
    }
}
