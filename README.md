   @DisplayName("Testando requisicao Externa")
    public void testeReqExterna() {


        TestRestTemplate restTemplate = new TestRestTemplate();

    String Nome_Arma = "Buster Sword 1";

    ResponseEntity<Weapon> responseEntity = restTemplate.getForEntity("https://mhw-db.com/weapons/1" , Weapon.class , Nome_Arma);

        log.info("Corpo da Resposta da requisicao "+ responseEntity.getBody().toString());



assertEquals(200, responseEntity.getStatusCode());
assertNotNull(responseEntity.getBody());
assertEquals(Nome_Arma, responseEntity.getBody().getNome_Arma());



    }




    @Test
@DisplayName("Procurando disparo por excecao")
public void chamarExcecao() {


    ResourceNotFoundException ChecarResourceNotFound   = assertThrows(ResourceNotFoundException.class , () -> {

    weapon_service.getWeaponID(90);
});
}
