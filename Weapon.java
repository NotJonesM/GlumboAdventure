public class Weapon extends Item {
    // Fields
    private int damage; 
    private boolean ranged;
    private boolean twoHanded;

    // Constructor
    public Weapon(String name, int dmg, boolean ranged, boolean twoHanded) {
        super(name);
        this.damage = dmg;
        this.ranged = ranged;
        this.twoHanded = twoHanded;
    }

    // Accessors
    public int getDamage() { return damage; }
    public boolean getRanged() { return ranged; }
    public boolean getTwoHanded() { return twoHanded; }

    // Methods
    public String toString() { 
        String res = getName() + " is ";
        if (getRanged()) { res += "ranged"; }
        if (getRanged() && getTwoHanded()) { res += " and "; }
        if (getTwoHanded()) { res += "two-handed."; }
        return res;
    }
}
