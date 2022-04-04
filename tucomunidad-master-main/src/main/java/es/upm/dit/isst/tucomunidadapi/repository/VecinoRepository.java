package es.upm.dit.isst.tucomunidadapi.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.upm.dit.isst.tucomunidadapi.model.Vecino;

public interface VecinoRepository extends CrudRepository<Vecino, Integer> {
  List<Vecino> findByNombre(String nombre);
}