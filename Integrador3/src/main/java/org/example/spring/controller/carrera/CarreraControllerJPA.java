package org.example.spring.controller.carrera;

import org.example.spring.model.Carrera;
import org.example.spring.model.Estudiante;
import org.example.spring.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carrera")
public class CarreraControllerJPA {
    @Qualifier("carreraRepository")
    @Autowired
    private final CarreraRepository repository;

    public CarreraControllerJPA(@Qualifier("carreraRepository")CarreraRepository repository){
        this.repository = repository;
    }
    @GetMapping("")
    public Iterable<Carrera>getCarreras(){
        return repository.findAll();
    }
    //f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
    @GetMapping("/inscripciones")
    public Iterable<Carrera>getCarrerasByInscripciones(){
        return repository.findAllByInscripciones();
    }
    @GetMapping("/reporte")
    public List<Object[]> generarReporteCarreras() {
        return repository.generarReporteCarreras();
    }

}
