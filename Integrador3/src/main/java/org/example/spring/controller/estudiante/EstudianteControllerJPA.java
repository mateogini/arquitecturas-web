package org.example.spring.controller.estudiante;

import org.example.spring.model.Estudiante;
import org.example.spring.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("estudiante")
public class EstudianteControllerJPA {
    @Qualifier("estudianteRepository")
    @Autowired
    private final EstudianteRepository repository;


    public EstudianteControllerJPA(@Qualifier("estudianteRepository")EstudianteRepository repository){
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Estudiante>getEstudiantes(){
        return repository.findAll();
    }
    @GetMapping("/ByName/{name}")
    public Iterable<Estudiante>getEstudiantesByName(@PathVariable String name){
        return repository.findAllByName(name);
    }
    @GetMapping("/ordenados") //c)
    public Iterable<Estudiante>getEstudiantesOrdenados(){
        return repository.findAllOrderByApellido();
    }

    @GetMapping("/ByLibreta/{libretaUniversitaria}")//d)
    public Iterable<Estudiante>getEstudiantesByLibreta(@PathVariable int libretaUniversitaria){
        return repository.findAllByLibretaUniversitaria(libretaUniversitaria);
    }

    @GetMapping("/ByGenero/{genero}") //e)
    public Iterable<Estudiante> getEstudiantesByGenero(@PathVariable String genero){
        return repository.findAllByGenero(genero);
    }
//
    @GetMapping("/carrera/{carreraId}/ciudad/{ciudadResidencia}")//g)
    public Iterable<Estudiante> getEstudiantesByCarrera(@PathVariable String ciudadResidencia,@PathVariable int carreraId){
        return repository.findByCiudadResidenciaAndCarreraId(ciudadResidencia, carreraId);
    }
    @PostMapping("")//a)
    public Estudiante altaEstudiante(@RequestBody Estudiante e){
        return repository.save(e);
    }


}
