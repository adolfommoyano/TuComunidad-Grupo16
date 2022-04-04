package es.upm.dit.isst.tucomunidadapi.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.upm.dit.isst.tucomunidadapi.model.Correspondencia;

public interface CorrespondenciaRepository extends CrudRepository<Correspondencia, Integer> {
  List<Correspondencia> findByTexto(String texto);
  List<Correspondencia> findByVecino_Idvecino(Integer idvecino);

}