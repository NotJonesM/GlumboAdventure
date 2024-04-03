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

    // -------------------------------------------------------------------------
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

    // -------------------------------------------------------------------------
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

    /**
     * @return list of doors in the room
     */
    public ArrayList<Door> getDoors(){
        return this.doors;
    }

    // -------------------------------------------------------------------------
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

    /**
     * Adds door to the list of doors
     * @param d - door to be added
     */
    public void addDoor(Door d){
        if (doors.size() < 4){
            doors.add(d);
        }
    }

    // -------------------------------------------------------------------------
    // Other methods

    /**
     * Converts room to a string
     */
    public String toString(){
        String str = "Room with: ";
        for (int i = 0; i < contents.size(); i++){
            str += "\n - " + contents.get(i).toString();
        }
        return str;
    }

    public void populateRoom(ArrayList<Monster> mons, ArrayList<Item> items){
        int monNum = GlumboToolbox.randInt(0,1);
        int itemNum = GlumboToolbox.randInt(1,2);
        for (int i = 0; i < monNum; i++){
            this.addEntity(new Monster());
        }
        for (int i = 0; i < itemNum; i++){
            int randomizer = GlumboToolbox.randInt(1,4);
            if (randomizer == 1){
                this.addEntity(new Weapon());
            } else {
                this.addEntity(new Potion());
            }
        }
    }    
}
