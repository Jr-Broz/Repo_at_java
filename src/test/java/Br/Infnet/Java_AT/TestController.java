package Br.Infnet.Java_AT;

import static org.junit.jupiter.api.Assertions.assertEquals;
import Br.Infnet.Java_AT.Controller.Weapon_Controller;
import Br.Infnet.Java_AT.Model.Weapon;
import Br.Infnet.Java_AT.Service.Weapon_Service;
import lombok.extern.java.Log;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Equals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@Log
@SpringBootTest
public class TestController {

@Autowired
    Weapon_Service weapon_service;


    @Test
    @DisplayName("Deve retornar Qnt de armas")
    public void retornaArma() {

        Weapon weapon = weapon_service.getWeaponID(1);

        assertEquals();



    }















}
