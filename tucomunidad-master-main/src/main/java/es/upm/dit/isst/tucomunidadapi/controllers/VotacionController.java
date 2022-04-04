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

import es.upm.dit.isst.tucomunidadapi.model.Votacion;
import es.upm.dit.isst.tucomunidadapi.repository.*;

@RestController
@RequestMapping("/votaciones")
public class VotacionController {
 private final VotacionRepository votacionRepository;
 public VotacionController(VotacionRepository VotacionRepository) {
  this.votacionRepository = VotacionRepository;
 }
 @GetMapping("/all")
 public List<Votacion> getVotaciones() {
 return (List<Votacion>) votacionRepository.findAll();
 }

 @GetMapping("/votacionesById/{idvotaciones}")
 public Optional<Votacion> read(@PathVariable Integer idvotaciones) { 
  return votacionRepository.findById(idvotaciones);
 }

 
 @GetMapping("/votacionesBytitulo/{titulo}")
 public  List<Votacion> readTitulo(@PathVariable String titulo) { 
   return votacionRepository.findByTitulo(titulo);
  }

  @GetMapping("/votacionesByComunidad/{direccion}")
  public  List<Votacion> readComunidad(@PathVariable String direccion) { 
    return votacionRepository.findByComunidadDireccion(direccion);
   }

  @PostMapping("/aumentarVotosFavorById/{idvotaciones}/aumentarVotosFavor")
  ResponseEntity<Votacion> incrementaFavor(@PathVariable Integer idvotaciones) {
  return votacionRepository.findById(idvotaciones).map(
  votacion -> {
     votacion.aumentarNumeroVotosFavor();
     votacionRepository.save(votacion);
  return ResponseEntity.ok().body(votacion);
  }).orElse(new ResponseEntity<Votacion>(HttpStatus.BAD_GATEWAY));
  }


  @PostMapping("/aumentarVotosContraById/{id_votaciones}/aumentarVotosContra")
  ResponseEntity<Votacion> aumentaContra(@PathVariable Integer id_votaciones) {
  return votacionRepository.findById(id_votaciones).map(
  votacion -> {
     votacion.aumentarNumeroVotosContra();
     votacionRepository.save(votacion);
  return ResponseEntity.ok().body(votacion);
  }).orElse(new ResponseEntity<Votacion>(HttpStatus.NOT_FOUND));
  }


 @PostMapping("/newVotacion")
 public ResponseEntity createVotacion(@RequestBody Votacion Votaciones) throws URISyntaxException {
 Votacion savedVotaciones = votacionRepository.save(Votaciones);
 return ResponseEntity.created(new URI("/votaciones/"+savedVotaciones.getTitulo())).body(savedVotaciones);
 }
 

 @DeleteMapping("/deleteVotacionById/{idvotaciones}")
 public ResponseEntity deleteVotacion(@PathVariable Integer idvotaciones) {
   votacionRepository.deleteById(idvotaciones);
 return ResponseEntity.ok().build();
 }
 
 @PutMapping("/actualizarVotacionById/{idvotaciones}")
 public ResponseEntity updateVotaciones(@PathVariable Integer idvotaciones, @RequestBody Votacion Votaciones) {
 return votacionRepository.findById(idvotaciones).map(votacion -> {
    votacion.setTitulo(Votaciones.getTitulo());
    votacion.setDescripcion(Votaciones.getDescripcion());
    votacion.setGestor(Votaciones.getGestor());
    votacion.setNumeroVotosContra(Votaciones.getNumeroVotosContra());
    votacion.setNumeroVotosFavor(Votaciones.getNumeroVotosFavor());
    votacionRepository.save(votacion);
 return ResponseEntity.ok().body(votacion);
 }).orElse(new ResponseEntity<Votacion>(HttpStatus.NOT_FOUND));
 }
 
 }