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

import es.upm.dit.isst.tucomunidadapi.model.Conserje;
import es.upm.dit.isst.tucomunidadapi.repository.*;

@RestController
@RequestMapping("/conserjes")
public class ConserjeController {

private final ConserjeRepository conserjeRepository;
    public ConserjeController(ConserjeRepository ConserjeRepository) {
    this.conserjeRepository = ConserjeRepository;
}
 @GetMapping("/all")
 public List<Conserje> getConserjes() {
 return (List<Conserje>) conserjeRepository.findAll();
 }

 @GetMapping("/conserjeById/{idconserje}")
 public Optional<Conserje> readConserjeById(@PathVariable Integer idconserje) { 
  return conserjeRepository.findById(idconserje);
 }

 @PostMapping("/newConserje")
 public ResponseEntity createConserje(@RequestBody Conserje Conserje) throws URISyntaxException {
 Conserje savedConserjes = conserjeRepository.save(Conserje);
 return ResponseEntity.created(new URI("/conserjes/"+savedConserjes.getNombre())).body(savedConserjes);
 }
 

 @DeleteMapping("/deleteConserjeById/{idconserje}")
 public ResponseEntity deleteConserje(@PathVariable Integer idconserje) {
    conserjeRepository.deleteById(idconserje);
 return ResponseEntity.ok().build();
 }
 
 @PutMapping("/actualizarConserjeById/{idconserje}")
 public ResponseEntity updateConserje(@PathVariable Integer idconserje, @RequestBody Conserje Conserje) {
 return conserjeRepository.findById(idconserje).map(conserje -> {
    conserje.setContraseña(Conserje.getContraseña());
    conserje.setDNI(Conserje.getDNI());
    conserje.setEmail(Conserje.getEmail());
    conserje.setNombre(Conserje.getNombre());
    conserjeRepository.save(conserje);
 return ResponseEntity.ok().body(conserje);
 }).orElse(new ResponseEntity<Conserje>(HttpStatus.NOT_FOUND));
 }

}

  