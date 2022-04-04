package es.upm.dit.isst.tucomunidadapi.controllers;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.CoreConstants;
import es.upm.dit.isst.tucomunidadapi.model.Correspondencia;
import es.upm.dit.isst.tucomunidadapi.repository.*;

@RestController
@RequestMapping("/correspondencias")
public class CorrespondenciaController {
 private final CorrespondenciaRepository correspondenciaRepository;
 public CorrespondenciaController(CorrespondenciaRepository CorrespondenciaRepository) {
  this.correspondenciaRepository = CorrespondenciaRepository;
 }
 @GetMapping("/all")
 public List<Correspondencia> getCorrespondencias() {
 return (List<Correspondencia>) correspondenciaRepository.findAll();
 }

 @GetMapping("/correspondenciaById/{idcorrespondencia}")
 public Optional<Correspondencia> read(@PathVariable Integer idcorrespondencia) { 
  return correspondenciaRepository.findById(idcorrespondencia);
 }

 
/*
 @GetMapping("/corresponendiaByIdComunidad/{idcomunidad}")
 public  List<Correspondencia> readCorrespondenciaComunidad(@PathVariable String idcomunidad) { 
   return correspondenciaRepository.findByComunidad_Idcomunidad(idcomunidad);
  }
*/
  @GetMapping("/corresponendiaByIdVecino/{idvecino}")
  public  List<Correspondencia> readCorrespondenciaVecino(@PathVariable Integer idvecino) { 
    return correspondenciaRepository.findByVecino_Idvecino(idvecino);
   }

  @PostMapping("/newCorrespondencia")
  public ResponseEntity<Correspondencia> createCorrespondencia(@RequestBody Correspondencia Correspondencia) throws URISyntaxException {
    Correspondencia savedCorrespondencia = correspondenciaRepository.save(Correspondencia);
  return ResponseEntity.created(new URI("/vecinos/"+savedCorrespondencia.getIdcorrespondencia())).body(savedCorrespondencia);
  }
  
   @DeleteMapping("/deleteCorrespondenciaById/{idcorrespondencia}")
   public ResponseEntity deleteCorrespondencia(@PathVariable Integer idcorrespondencia) {
    correspondenciaRepository.deleteById(idcorrespondencia);
   return ResponseEntity.ok().build();
   }
   
   @PutMapping("/actualizaridCorrespondenciaById/{idcorresponencia}")
   public ResponseEntity updateVecino(@PathVariable Integer idcorresponencia, @RequestBody Correspondencia Correspondencia) {
   return correspondenciaRepository.findById(idcorresponencia).map(correspondencia -> {
    Correspondencia.setTexto(Correspondencia.getTexto());
    correspondenciaRepository.save(correspondencia);
    return ResponseEntity.ok().body(correspondencia);
     }).orElse(new ResponseEntity<Correspondencia>(HttpStatus.NOT_FOUND));
   }
   

}

  