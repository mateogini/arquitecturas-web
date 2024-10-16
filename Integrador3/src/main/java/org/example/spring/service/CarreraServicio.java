package org.example.spring.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.spring.model.Carrera;
import org.example.spring.repository.CarreraRepository;
import org.example.spring.service.dto.carrera.request.CarreraRequestDTO;
import org.example.spring.service.dto.carrera.response.CarreraResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarreraServicio {
    private final CarreraRepository carreraRepository;

    @Transactional
    public CarreraResponseDTO save(CarreraRequestDTO request){
            final var carrera = new Carrera(request);
            final var result = this.carreraRepository.save(carrera);
            return new CarreraResponseDTO( result.getIdCarrera(), result.getNombreCarrera(), result.getInscripciones() );
    }
    @Transactional
    public List<CarreraResponseDTO> findAll(){
        return this.carreraRepository.findAll().stream().map( CarreraResponseDTO::new).toList();
    }
}
