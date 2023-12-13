package Br.Infnet.Java_AT.Service;
import Br.Infnet.Java_AT.Model.Weapon;
import Br.Infnet.Java_AT.Util.Weapon_Util;
import Br.Infnet.Java_AT.exceptions.ResourceNotFoundException;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log
@Service
public class Weapon_Service {
    public Map<Integer, Weapon> weaponMap = InicioWeapons();

    public Integer wpId = (Integer) retornarTodos().size();

    private Map<Integer, Weapon> InicioWeapons() {

        Map<Integer, Weapon> weaponMap1 = new HashMap<>();
        Weapon_Util weapon_util = new Weapon_Util();

        for(int i = 1; i <= 51; i++) {

            Weapon weapon = weapon_util.getArma(i);
            Weapon firstWeapon = new Weapon(weapon.getID(), weapon.getNome_Arma(),  weapon.getDurabilidade() ,weapon.getSlot() );
            weaponMap1.put(firstWeapon.getID(), firstWeapon);
        }
        return weaponMap1;
    }


    public void create(Weapon weapon)  {

    int id = ++this.wpId;
    weapon.setID(id);
    weaponMap.replace(id, weapon);
 }

 public void deleteID(int id) {

        Weapon WP = weaponMap.remove(id);
        if(WP == null) {
            throw new ResourceNotFoundException("Nao foi possivel achar o id da arma");
        }
 }

 public void update(int id, Weapon newWP) {

        newWP.setID(id);
        weaponMap.replace(id, newWP);
 }

 public  List<Weapon> acharPorNome(String name) {

        List<Weapon> wplt = retornarTodos();

        return wplt.stream().filter(weapon -> weapon.getNome_Arma().startsWith(name)).toList();
 }

    public Weapon getWeaponID(int id) {
        Weapon wp =  weaponMap.get(id);
        if(wp == null) {throw new ResourceNotFoundException("Erro, nao foi possivel encontrar o que procurava.");}
        return wp;
    }

    public List<Weapon> retornarTodos() {

        return weaponMap.values().stream().toList();
    }
}