package Br.Infnet.Java_AT.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
@JsonIgnoreProperties
public class Weapon {

//    "https://mhw-db.com/weapons"
    //  private static final Logger LOGGER =
    //
    //            LoggerFactory.getLogger(App.class);


    @JsonProperty("id")
    public int ID;

    @JsonProperty("name")
    public String Nome_Arma;


    //Antes era String
    @JsonProperty("type")

    public String Tipo_Da_Arma;




    @JsonProperty("durability")
    public List Durabilidade;

public Weapon(int Id, String nomeArma, String tipArma, List durabilidade) {

    this.ID =   Id;
    Nome_Arma = nomeArma;
    Tipo_Da_Arma = tipArma;
    Durabilidade = durabilidade;
}

public Weapon() {}








}
