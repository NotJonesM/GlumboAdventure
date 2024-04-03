import java.util.ArrayList;

class Dungeon {
    // Fields
    private ArrayList<ArrayList<Room>> dungeon = new ArrayList<>();
    private String name;
    private ArrayList<Entity> possibleItems = new ArrayList<>();
    private ArrayList<Entity> possibleMonsters = new ArrayList<>();
    private int entranceRow;
    private int entranceCol;
    private int exitRow;
    private int exitCol;
    private int rows;
    private int cols;

    // Constructor
    public Dungeon(String name, int rows, int cols, ArrayList<Entity> possibleItems, ArrayList<Entity> possibleMonsters, int entranceRow, int entranceCol, int exitRow, int exitCol) {
        this.name = name;
        this.possibleItems = possibleItems;
        this.possibleMonsters = possibleMonsters;
        this.entranceRow = entranceRow;
        this.entranceCol = entranceCol;
        this.exitRow = exitRow;
        this.exitCol = exitCol;
        this.rows = rows;
        this.cols = cols;
        populateMap();
    }

    // Accessors
    public ArrayList<ArrayList<Room>> getDungeon() { return dungeon; }
    public int getLength() { return dungeon.size(); }
    public int getWidth() { return dungeon.get(0).size(); } // assumes dungeon is not a ragged array
    public int getEntranceRow() { return entranceRow; }
    public int getEntranceCol() { return entranceCol; }

    // Methods
    public void printMap(){
        System.out.println(name + ": ");
        System.out.println(dungeon.toString());
    }

    public void populateMap() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; r++) {
                // TODO call room constructor 
            }
        } 
    }
/* NOW-DEFUNCT POPULATEROOM METHOD - FUNCTIONALITY MOVED TO ROOM CLASS
    public void populateRoom(int row, int col) {
        if (row == exitRow && col == exitCol) { 
            
        }
        int rand = (int) (Math.random() * 10) + 1; // random number between 1 and 10 inclusive
        if (rand <= 6) { dungeon.get(row).get(col).addEntity(possibleItems.get((int) (Math.random() * possibleItems.size()))); }
        rand = (int) (Math.random() * 10) + 1;
        if (rand <= 6) { dungeon.get(row).get(col).addEntity(possibleMonsters.get((int) (Math.random() * possibleMonsters.size()))); }
    }
*/
}