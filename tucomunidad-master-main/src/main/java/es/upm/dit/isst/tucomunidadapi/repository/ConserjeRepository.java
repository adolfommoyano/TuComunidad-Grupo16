package es.upm.dit.isst.tucomunidadapi.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.upm.dit.isst.tucomunidadapi.model.Conserje;

public interface ConserjeRepository extends CrudRepository<Conserje, Integer> {
  List<Conserje> findByNombre(String nombre);
}