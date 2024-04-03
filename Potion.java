public class Potion extends Item {
    // Fields
    private int hpChange;
    private int buffValue; // a percentage to buff the next attack by
    private int numBuffs; // number of buffs/buffs remaining

    // Constructors
    public Potion(String name, int heal, int buff, int buffs) {
        super(name);
        this.hpChange = heal;
        this.buffValue = buff;
        this.numBuffs = buffs;
    }

    // Accessors
    public int getHpVal() { return hpChange; }
    public int getBuffVal() { return buffValue; }
    public int getNumBuffs() { return numBuffs; }

    // Accessors
    public void setNumBuffs(int n) { this.numBuffs = n; }

    // Method
    public String toString() { 
        if (hpChange > 0) { return getName() + " heals " + getHpVal() + " HP and buffs the next " + getNumBuffs() + " attack(s) by " + getBuffVal() + " percent."; }
        else { return getName() + " deals " + getHpVal() + " damage and buffs the next " + getNumBuffs() + " attack(s) by " + getBuffVal() + " percent";}
    }
}