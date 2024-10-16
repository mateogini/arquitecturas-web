package org.example.spring.utils;

import lombok.extern.slf4j.Slf4j;
import org.example.spring.model.Estudiante;
import org.example.spring.model.Carrera;
import org.example.spring.model.Inscripcion;
import org.example.spring.repository.EstudianteRepository;
import org.example.spring.repository.CarreraRepository;

import org.example.spring.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@Slf4j
public class LoadDataBase {

    @Bean
    CommandLineRunner initDataBase(
            @Qualifier("estudianteRepository") EstudianteRepository estudianteRepository,
            @Qualifier("carreraRepository") CarreraRepository carreraRepository, @Qualifier("inscripcionRepository")InscripcionRepository inscripcionRepository) {

        return args -> {
            // Crear y guardar carreras
            Carrera carrera1 = new Carrera();
            carrera1.setNombreCarrera("Ingeniería de Sistemas");
            carreraRepository.save(carrera1);
            log.info("Preloading " + carrera1);

            Carrera carrera2 = new Carrera();
            carrera2.setNombreCarrera("Administración de Empresas");
            carreraRepository.save(carrera2);
            log.info("Preloading " + carrera2);

            // Crear y guardar estudiantes
            Estudiante estudiante1 = new Estudiante();
            estudiante1.setNombre("Mateo");
            estudiante1.setApellido("Dario");
            estudiante1.setEdad(20);
            estudiante1.setCiudadResidencia("Bogotá");
            estudiante1.setDocumento(12345678L);
            estudiante1.setGenero("Masculino");
            estudiante1.setLibretaUniversitaria(102);
            estudianteRepository.save(estudiante1);
            log.info("Preloading " + estudiante1);



            Estudiante estudiante2 = new Estudiante();
            estudiante2.setNombre("Lucas");
            estudiante2.setApellido("Arbol");
            estudiante2.setEdad(20);
            estudiante2.setCiudadResidencia("Bogotá");
            estudiante2.setDocumento(12345678L);
            estudiante2.setGenero("Masculino");
            estudiante2.setLibretaUniversitaria(101);
            estudianteRepository.save(estudiante2);
            log.info("Preloading " + estudiante2);

            Estudiante estudiante3 = new Estudiante();
            estudiante3.setNombre("Ana");
            estudiante3.setApellido("Beta");
            estudiante3.setEdad(22);
            estudiante3.setCiudadResidencia("Medellín");
            estudiante3.setDocumento(45460217l);
            estudiante3.setGenero("Femenino");
            estudiante3.setLibretaUniversitaria(103);
            estudianteRepository.save(estudiante3);
            log.info("Preloading " + estudiante3);

            // Crear y asociar inscripciones (esto requiere que tengas un servicio de inscripción)
            // Puedes crear un método para hacer esto, usando la lista de estudiantes y carreras.
            Inscripcion inscripcion1 = new Inscripcion();
            inscripcion1.setEstudiante(estudiante1);
            inscripcion1.setCarrera(carrera1);
            inscripcion1.setAntiguedad(1);
            inscripcion1.setGraduado(false);
            inscripcionRepository.save(inscripcion1);
            log.info("Preloading " + inscripcion1);

            Inscripcion inscripcion2 = new Inscripcion();
            inscripcion2.setEstudiante(estudiante2);
            inscripcion2.setCarrera(carrera1);
            inscripcion2.setAntiguedad(2);
            inscripcion2.setGraduado(false);
            inscripcionRepository.save(inscripcion2);
            log.info("Preloading " + inscripcion2);

            Inscripcion inscripcion3 = new Inscripcion();
            inscripcion3.setEstudiante(estudiante3);
            inscripcion3.setCarrera(carrera2);
            inscripcion3.setAntiguedad(2);
            inscripcion3.setGraduado(false);
            inscripcionRepository.save(inscripcion3);
            log.info("Preloading " + inscripcion3);
        };
    }
}
