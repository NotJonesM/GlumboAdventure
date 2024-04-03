public class Monster {
    private int hp;
    private String name;
    private int dmg;
    //Constructors
    public Monster(){
        hp = 100;
        name = "nameless monster";
        dmg = 5;
    }

    public Monster(String n, int h, int d){
        hp = h;
        name = n;
        dmg = d;
    }
    //Accessors
    public int getHp(){
        return hp;
    }
    public int getDmg(){
        return dmg;
    }
    public String getName(){
        return name;
    }
    //Methods
    public void changeHp(int dmg){
        this.hp = hp - dmg;
    }

    public void attack(Player target){
        target.takeDmg(dmg);
    }
}
