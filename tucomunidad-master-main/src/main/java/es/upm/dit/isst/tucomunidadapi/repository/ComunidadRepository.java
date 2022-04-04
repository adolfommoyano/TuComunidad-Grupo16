package es.upm.dit.isst.tucomunidadapi.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.upm.dit.isst.tucomunidadapi.model.Comunidad;

public interface ComunidadRepository extends CrudRepository<Comunidad, Integer> {
  List<Comunidad> findByIdcomunidad(Integer idcomunidad);
  List<Comunidad> findByDireccion(String direccion);

}