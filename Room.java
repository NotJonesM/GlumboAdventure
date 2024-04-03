import java.util.ArrayList;

/**
 * Room in dungeon
 */
public class Room {
    
    // Fields

    private int x; // X coord in dungeon
    private int y; // Y coord in dungeon
    private ArrayList<Entity> contents; // Entities in the room
    private ArrayList<Door> doors; // Doors in the room (Max of 4)

    // Constructors

    /**
     * Creates room at location x,y with contents of entities
     * @param x - x coordinate in dungeon
     * @param y - y coordinate in dungeon
     * @param entities - list of entities in the room
     * @param doors - list of doors in the room
     */
    public Room(int x, int y, ArrayList<Entity> entities, ArrayList<Door> doors){
        this.x = x;
        this.y = y;
        this.contents = entities;
        this.doors = doors;
    }

    /**
     * Creates room at location 0,0 (Bottom left of the dungeon) with no contents
     */
    public Room(){
        this(0, 0, new ArrayList<Entity>(), new ArrayList<Door>());
    }

    // Accessors
    
    /**
     * @return x value of room within dungeon
     */
    public int getX(){
        return this.x;
    }

    /**
     * @return y value of room within dungeon
     */
    public int getY(){
        return this.y;
    }

    /**
     * @return the contents of a room
     */
    public ArrayList<Entity> getContents(){
        return this.contents;
    }

    // Mutators

    /**
     * Removes entity from contents of room
     * @param e - the entity to be removed
     */
    public void removeEntity(Entity e){
        contents.remove(e);
    }

    /**
     * Adds entity to the contents of the room
     * @param idx - idx where entity will be added
     * @param e - entity to be added
     */
    public void addEntity(int idx, Entity e){
        contents.add(idx, e);
    }

    /**
     * Adds entity to the contents of the room, at the end of the contents list
     * @param e - entity to be added
     */
    public void addEntity(Entity e){
        contents.add(e);
    }

    //TODO add and get doors methods
}
