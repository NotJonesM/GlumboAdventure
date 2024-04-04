
/**
 * Parent class for Item.java and Monster.java. No inherent functionality aside from a name field.
 */
public class Entity {
    // Fields
    private String name;

    // Constructor
    public Entity(String name) {
        this.name = name;
    }

    // Accessors
    public String getName() { return name; }
}