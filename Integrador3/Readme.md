en docker

usuario:root

password:1234


PARA REST EN POSTMAN:


BASE:estudiante

Para dar de alta un estudiante POST: BASE/estudiante/

BASE:inscripciones

Para matricular un estudiante POST:

BASE/matricular/dni/idCarrera

siendo el dni del estudiante y el id de la carrera



BASE:estudiante

Para recuperar los estudiantes ordenados por Apellido GET:

BASE/estudiante/ordenados.



BASE:estudiante

Para recuperar un estudiante por su numero de libreta GET:

/estudiante/ByLibreta/nrolibreta

Siendo nrolibreta el numero especifico del estudiante a recuperar.


BASE:estudiante

Para recuperar los estudiantes por su genero GET

BASE/estudiante/ByGenero/genero

Siendo genero el genero de los estudiantes a recuperar.



BASE:carrera

Para recuperar las carreras con estudiantes inscriptos y ordenadas de mayor a menor inscriptos

BASE/inscripciones



BASE:estudiante

Para recuperar estudiantes de una carrera filtrados por ciudad

BASE/carrera/idCarrera/ciudad/nombreCiudad

Siendo idCarrera el id de la carrera en especial y nombreCiudad la ciudad a filtrar.



BASE:carrera

Para generar el reporte de las carreras

BASE/reporte




