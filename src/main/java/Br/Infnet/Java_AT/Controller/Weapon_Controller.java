package Br.Infnet.Java_AT.Controller;

import Br.Infnet.Java_AT.Model.Weapon;
import Br.Infnet.Java_AT.exceptions.ResourceNotFoundException;
import Br.Infnet.Java_AT.Service.Weapon_Service;
import Br.Infnet.Java_AT.exceptions.ResponsePayload;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Log
@RestController
@RequestMapping("/weapons")
public class Weapon_Controller {
    @Autowired
    Weapon_Service wpService;

    @GetMapping
    public List<Weapon> retornarTodos(@RequestParam (required = false , defaultValue = "1") int tamanho, @RequestParam (required = false)Optional<String> name){

        List<Weapon> weapons = wpService.retornarTodos();

        if(name.isPresent()) {

            return weapons = wpService.acharPorNome(name.get());
        }
        else {
            return weapons = weapons.subList(0, tamanho);
        }
    }

    @GetMapping("/{id}")
        public ResponseEntity puxarArmaPorID(@PathVariable int id ) {

        try{

            Weapon weapon = wpService.getWeaponID(id);
            return ResponseEntity.ok(weapon);

        }
        catch (ResourceNotFoundException e) {

            ResponsePayload responsePayload = new ResponsePayload(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responsePayload);
        }
    }

@PostMapping
    public ResponseEntity<ResponsePayload> create(@RequestBody Weapon weap) {

        wpService.create(weap);
        log.info(String.valueOf(HttpStatus.CREATED));
    return ResponseEntity.status(HttpStatus.CREATED).body(new ResponsePayload("criado com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponsePayload> Delete(@PathVariable int id) {

        try {

            wpService.deleteID(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponsePayload("arma foi deletada com sucesso"));
        }
        catch (ResourceNotFoundException e ){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body( new ResponsePayload(e.getMessage()));
        }
   }

    @PutMapping("/{id}")
    public ResponseEntity<ResponsePayload> update(@PathVariable int id, @RequestBody Weapon UpdatedWeapon) {

        try{

            wpService.update(id, UpdatedWeapon);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponsePayload("arma atualizada com sucesso"));
        }
        catch (ResourceNotFoundException ex) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponsePayload(ex.getMessage()));
        }
    }
}