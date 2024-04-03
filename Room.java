import java.util.ArrayList;

/**
 * Room in dungeon
 */
public class Room {
    
    // Fields

    private int x; // X coord in dungeon
    private int y; // Y coord in dungeon
    private ArrayList<Entity> contents; // Entities in the room

    // Constructors

    /**
     * Creates room at location x,y with contents of entities
     * @param x - x coordinate in dungeon
     * @param y - y coordinate in dungeon
     * @param entities - list of entities in the room
     */
    public Room(int x, int y, ArrayList<Entity> entities){
        this.x = x;
        this.y = y;
        this.contents = entities;
    }

    /**
     * Creates room at location 0,0 with no contents
     */
    public Room(){
        this(0, 0, new ArrayList<Entity>());
    }

    //

}
