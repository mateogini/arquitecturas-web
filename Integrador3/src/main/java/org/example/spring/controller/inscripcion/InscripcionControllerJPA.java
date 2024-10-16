package org.example.spring.controller.inscripcion;

import org.example.spring.model.Carrera;
import org.example.spring.model.Estudiante;
import org.example.spring.model.Inscripcion;
import org.example.spring.repository.CarreraRepository;
import org.example.spring.repository.EstudianteRepository;
import org.example.spring.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("inscripciones")
public class InscripcionControllerJPA {
    @Qualifier("inscripcionRepository")

    @Autowired
    private final InscripcionRepository repository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CarreraRepository carreraRepository;

    public InscripcionControllerJPA(@Qualifier("inscripcionRepository") InscripcionRepository repository){
        this.repository= repository;
    }
    @PostMapping("/matricular/{dni}/{carreraId}")
    public Inscripcion matricularEstudiante(@PathVariable Long dni, @PathVariable int carreraId){// Buscar el estudiante por su ID
        Estudiante estudiante = estudianteRepository.findAllByDocumento(dni);

        // Buscar la carrera por su ID
        Carrera carrera = carreraRepository.findByIdCarrera(carreraId);

        // Crear una nueva inscripción
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setEstudiante(estudiante);
        inscripcion.setCarrera(carrera);
        inscripcion.setAntiguedad(0); // Puedes cambiar este valor o calcularlo si es necesario
        inscripcion.setGraduado(false); // Asumimos que el estudiante no está graduado inicialmente

        // Guardar la inscripción en la base de datos
        return repository.save(inscripcion);
    }
}
