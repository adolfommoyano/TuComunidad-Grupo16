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

import es.upm.dit.isst.tucomunidadapi.model.Comunidad;
import es.upm.dit.isst.tucomunidadapi.repository.*;

@RestController
@RequestMapping("/comunidades")
public class ComunidadController {
 private final ComunidadRepository comunidadRepository;
 public ComunidadController(ComunidadRepository ComunidadRepository) {
  this.comunidadRepository = ComunidadRepository;
 }
 @GetMapping("/all")
 public List<Comunidad> getComunidades() {
 return (List<Comunidad>) comunidadRepository.findAll();
 }

 @GetMapping("/comunidadById/{idcomunidad}")
 public List<Comunidad> read(@PathVariable Integer idcomunidad) { 
  return comunidadRepository.findByIdcomunidad(idcomunidad);
 }

 

 @GetMapping("/comunidadByDireccion/{direccion}")
 public  List<Comunidad> readTitulo(@PathVariable String direccion) { 
   return comunidadRepository.findByDireccion(direccion);
  }

  @PostMapping("/newComunidad")
  public ResponseEntity<Comunidad> createComunidad(@RequestBody Comunidad Comunidad) throws URISyntaxException {
    Comunidad savedComunidad = comunidadRepository.save(Comunidad);
  return ResponseEntity.created(new URI("/vecinos/"+savedComunidad.getIdcomunidad())).body(savedComunidad);
  }
  
   @DeleteMapping("/deleteComunidadById/{idcomunidad}")
   public ResponseEntity deleteVecino(@PathVariable Integer idcomunidad) {
    comunidadRepository.deleteById(idcomunidad);
   return ResponseEntity.ok().build();
   }
   
   @PutMapping("/actualizarComunidadById/{idcomunidad}")
   public ResponseEntity updateVecino(@PathVariable Integer idcomunidad, @RequestBody Comunidad Comunidad) {
   return comunidadRepository.findById(idcomunidad).map(comunidad -> {
    comunidad.setDireccion(Comunidad.getDireccion());
    comunidad.setCodigoPostal(Comunidad.getCodigoPostal());
    comunidadRepository.save(comunidad);
    return ResponseEntity.ok().body(comunidad);
     }).orElse(new ResponseEntity<Comunidad>(HttpStatus.NOT_FOUND));
   }
   

}

  