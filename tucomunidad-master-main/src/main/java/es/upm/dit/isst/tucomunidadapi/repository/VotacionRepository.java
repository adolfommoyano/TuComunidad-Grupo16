package es.upm.dit.isst.tucomunidadapi.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.upm.dit.isst.tucomunidadapi.model.Votacion;

public interface VotacionRepository extends CrudRepository<Votacion, Integer> {
  List<Votacion> findByTitulo(String titulo);
  List<Votacion> findByComunidadDireccion(String comunidad);
  List<Votacion> findByComunidad_Idcomunidad(String comunidad);

}