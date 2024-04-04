public class Monster extends Entity {
    // Fields
    private int hp;
    private int dmg;

    // Constructors
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

    // Accessors
    public int getHp(){
        return hp;
    }
    public int getDmg(){
        return dmg;
    }

    // Methods

    /**
     * Change the monster's HP by the specific amount
     * @param dmg the amount to change it by (can be negative or positive)
     */
    public void changeHp(int dmg){
        this.hp = hp - dmg;
    }

    /**
     * Attack the player for damage equal to the monster's damage stat
     * @param player the player to attack
     */
    public void attack(Player target){
        target.takeDmg(dmg);
    }

    public String toString(){
        return super.getName() + " with " + hp + " remaining hp";
    }
}
