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

import es.upm.dit.isst.tucomunidadapi.model.Vecino;
import es.upm.dit.isst.tucomunidadapi.repository.*;

@RestController
@RequestMapping("/vecinos")
public class VecinoController{
 private final VecinoRepository vecinoRepository;
 public VecinoController(VecinoRepository VecinoRepository) {
  this.vecinoRepository = VecinoRepository;
 }
 @GetMapping("/all")
 public List<Vecino> getVecinos() {
 return (List<Vecino>) vecinoRepository.findAll();
 }
 
 
 @GetMapping("/vecinoById/{idvecino}")
public ResponseEntity<Vecino> read(@PathVariable Integer idvecino) {
 return  vecinoRepository.findById(idvecino).map(vecino ->

 ResponseEntity.ok().body(vecino)

).orElse(new ResponseEntity<Vecino>(HttpStatus.NOT_FOUND));

}


@PostMapping("/newVecino")
public ResponseEntity<Vecino> createVecino(@RequestBody Vecino Vecino) throws URISyntaxException {
   Vecino savedVecino = vecinoRepository.save(Vecino);
return ResponseEntity.created(new URI("/vecinos/"+savedVecino.getNombre())).body(savedVecino);
}

 @DeleteMapping("/deleteVecinoById/{idvecino}")
 public ResponseEntity deleteVecino(@PathVariable Integer idvecino) {
    vecinoRepository.deleteById(idvecino);
 return ResponseEntity.ok().build();
 }
 
 @PutMapping("/actualizarVecinoById/{idvecino}")
 public ResponseEntity updateVecino(@PathVariable Integer idvecino, @RequestBody Vecino Vecino) {
 return vecinoRepository.findById(idvecino).map(vecino -> {
    vecino.setContraseña(Vecino.getContraseña());
    vecino.setDni(Vecino.getDni());
    vecino.setEmail(Vecino.getEmail());
    vecino.setNombre(Vecino.getNombre());
    vecinoRepository.save(vecino);
 return ResponseEntity.ok().body(vecino);
 }).orElse(new ResponseEntity<Vecino>(HttpStatus.NOT_FOUND));
 }
 
 }