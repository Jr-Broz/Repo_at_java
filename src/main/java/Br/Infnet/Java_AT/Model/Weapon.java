package Br.Infnet.Java_AT.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weapon {

    @JsonProperty("id")
    public int ID;

    @JsonProperty("name")
    public String Nome_Arma;


    //Antes era String
    @JsonProperty("slots")
    public List Slot;


    @JsonProperty("durability")
    public List Durabilidade;

public Weapon(int Id, String nomeArma,  List durabilidade,  List SlotArma) {

    this.ID =   Id;
    Nome_Arma = nomeArma;
    Durabilidade = durabilidade;
    Slot = SlotArma;

}

public Weapon() {

}

}