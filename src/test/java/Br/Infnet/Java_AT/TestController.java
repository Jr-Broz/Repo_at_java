package Br.Infnet.Java_AT;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import Br.Infnet.Java_AT.Controller.Weapon_Controller;
import Br.Infnet.Java_AT.Model.Weapon;
import Br.Infnet.Java_AT.Service.Weapon_Service;
import Br.Infnet.Java_AT.Util.Weapon_Util;
import lombok.extern.java.Log;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Equals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.ResourceAccessException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

@Log
@SpringBootTest
public class TestController {

@Autowired
    Weapon_Service weapon_service;

@Test
@DisplayName("procurando por algum nome")
public void retornarNome() {

    Weapon_Util weapon_util = new Weapon_Util();

    Weapon weapon = weapon_util.getArma(10);

    assertEquals("Purgation's Atrocity" , weapon.getNome_Arma());
        log.info(weapon.getNome_Arma());
}

@Test
@DisplayName("Retornar qnt de armas") //Teste passa, entretanto caso alguem faça a requisicao delete o teste vai dar errado, caso contrario vai dar certo
public void retorno() {

    List<Weapon> wp = weapon_service.retornarTodos();

    assertEquals(50, wp.size());
}
    @Test
    @DisplayName("Deve criar uma arma ")
    public void criar() {

    Weapon zweihander =     Weapon.builder().Nome_Arma("ZweiHander").ID(39).build();

    log.info(zweihander.toString());

    }

    @Test
    @DisplayName("deve delete arma")
    public void deletarArma() {

        weapon_service.deleteID(1);
        assertEquals(50, weapon_service.retornarTodos().size());
    }
}