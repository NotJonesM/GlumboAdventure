/**
 * Parent class for Weapon, no inherent functionality. Required for use of instanceof in runner contexts.
 */

public class Item extends Entity {
    // Constructor
    public Item(String name) {
        super(name);
    }    
}
