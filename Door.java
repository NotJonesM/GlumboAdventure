/**
 * Doesn't do anything anymore
 */
public class Door {
    // Fields
    private String type; // type of door, for descriptions' sake, e.g., wood, stone, arched, etc. 
    private boolean exit;

    // Constructor(s)
    public Door(String type, boolean exit) {
        this.type = type;
        this.exit = exit;
    }

    // Accessors
    public String getType() { return type; }
    public boolean isExit() { return exit; }

    // Methods
    public String toString() {
        return "a " + getType() + " door";
    }
}
