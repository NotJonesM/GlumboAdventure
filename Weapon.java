public class Weapon extends Item {
    // Fields
    private int damage; 
    private boolean ranged;
    private boolean twoHanded;

    // Constructor
    public Weapon(String name, int dmg, boolean ranged, boolean twoHanded) {
        super(name);
        this.damage = dmg;
        // Ranged and two-handed both currently do nothing. System may be implemented later if we have time.
        // For now, the framework is here if we need. 
        this.ranged = ranged;
        this.twoHanded = twoHanded;
    }

    public Weapon(){
        this("Sword", 7 ,false, false);
    }

    // Accessors
    public int getDamage() { return damage; }
    public boolean isRanged() { return ranged; }
    public boolean isTwoHanded() { return twoHanded; }

    // Methods
    public String toString() { 
        String res = getName() + " is ";
        if (isRanged()) { res += "ranged"; }
        if (isRanged() && isTwoHanded()) { res += " and "; }
        if (isTwoHanded()) { res += "two-handed."; }
        return res;
    }
}
