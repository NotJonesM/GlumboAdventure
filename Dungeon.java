import java.util.ArrayList;

class Dungeon {
    // Fields
    private ArrayList<ArrayList<Room>> dungeon = new ArrayList<>();
    private String name;
    private ArrayList<Item> possibleItems = new ArrayList<>();
    private ArrayList<Monster> possibleMonsters = new ArrayList<>();
    private int entranceX;
    private int entranceY;
    private int exitX;
    private int exitY;

    // Constructor
    public Dungeon(String name, ArrayList<Item> possibleItems, ArrayList<Monster> possibleMonsters, int entranceX, int entranceY, int exitX, int exitY) {
        this.name = name;
        this.possibleItems = possibleItems;
        this.possibleMonsters = possibleMonsters;
    }

    // Accessors
    public int getLength() { return dungeon.size(); }
    public int getWidth() { return dungeon.get(0).size(); } // assumes dungeon is not a ragged array

    // Methods
    private void printMap(ArrayList<Room> map){
        System.out.println(map);
    }

    public void populateMap() {
        for (ArrayList<Room> row : dungeon) {
            for (Room r : row) {
                // TODO: add items/monsters to room
            }
        } 
    }
}