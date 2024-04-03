import java.util.ArrayList;

public class Monster extends Entity{
    private int hp;
    private int dmg;
    //Constructors
    public Monster(){
        super("nameless monster");
        hp = 100;
        dmg = 5;
    }

    public Monster(String n, int h, int d){
        super(n);
        hp = h;
        dmg = d;
    }
    //Accessors
    public int getHp(){
        return hp;
    }
    public int getDmg(){
        return dmg;
    }
    //Methods
    public void changeHp(int dmg){
        this.hp = hp - dmg;
    }

    public void attack(Player target){
        target.takeDmg(dmg);
    }

    public void onDeath(Monster m){
        if (m.getHp() <= 0){

        }
    }
}
