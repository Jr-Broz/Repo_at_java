package Br.Infnet.Java_AT.Util;
import Br.Infnet.Java_AT.Model.Weapon;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.logging.log4j.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Weapon_Util{

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(Weapon_Util.class);

    private final String  Url_Da_API =  "https://mhw-db.com/weapons";

public Weapon getArma(int id) {

    try{

        HttpRequest request = HttpRequest.newBuilder().GET().version(HttpClient.Version.HTTP_2).uri(new URI( Url_Da_API + id)).build();

        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());


        ObjectMapper objectMapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();

        Weapon wep = objectMapper.readValue(httpResponse.body(), Weapon.class);

        String nome_da_Arma = wep.getNome_Arma();
        int iD = wep.getID();
        List<String>  durabilidade = GetDurabilidade(wep);
        List<String>  tipoDaArma = getTipoArma(wep);

    Weapon weapon =  new Weapon((Integer) id, nome_da_Arma, tipoDaArma.toString(), durabilidade);


        return weapon;
    }

    catch (URISyntaxException | IOException | InterruptedException e) {
        throw new RuntimeException(e);
    }
}


    private List<String> GetDurabilidade(Weapon weap) {


    List<String> durabilidadeDasArmas = new LinkedList<>();

    for(int i = 0; i < weap.getDurabilidade().size(); i++) {

        Object  qntd = weap.getDurabilidade().get(i);

    if(qntd instanceof  Map) {

        Map<String, Object> listaDurabilidade = (Map<String, Object>) qntd;

        Object pegarDurabilidade = listaDurabilidade.get("durability");

    if(pegarDurabilidade instanceof  Map) {


        Map<String, Object> listagemDurabilidade = (Map<String, Object>) pegarDurabilidade;

        Object corDurabilidade = listagemDurabilidade.get("red");

        durabilidadeDasArmas.add(corDurabilidade.toString());

          }
        }

    }

        return  durabilidadeDasArmas;
    }

    private List<String> getTipoArma(Weapon weapon) {

    List<String> TipoArmaLista = new LinkedList<>();


    //Talvez ter que ir na classe weapon colocar Tipo da arma como lista pra poder acessar o ,size() ?
    for(int i = 0; i < weapon.getTipo_Da_Arma().length(); i++){

        Object typ = weapon.getTipo_Da_Arma().length(i);

    }











    }











































































}
