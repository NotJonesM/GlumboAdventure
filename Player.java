import java.util.ArrayList;

public class Player {
    private int hp = 100;
    private String name;
    private ArrayList<Item> inventory;

    public void attack(Monster mob){
        mob.changeHp(5);
    }

    public int getHp(){
        return hp;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Item> getInventory(){
        return inventory;
    }
}
