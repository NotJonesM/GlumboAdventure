import java.util.ArrayList;

public class Player {
    // Fields
    private int hp;
    private String name;
    private ArrayList<Item> inventory;
    private double currentBuff = 0;
    private int row;
    private int col;

    //C onstructors
    public Player(){
        this.name = "Nameless";
        hp = 100;
        this.row = 0;
        this.col = 0;
    }

    public Player(String name){
        this.name = name;
        hp = 100;
        this.row = 0;
        this.col = 0;
    }

    // Accessors
    public int getHp(){
        return hp;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Item> getInventory(){
        return inventory;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }

    // Methods

    // Move commands, simply mutators for the player's x and y coords.
    public void moveUp() { row--; }
    public void moveDown() { row++; }
    public void moveLeft() { col--; }
    public void moveRight() { col++; }

    /**
     * Attack the specific mob with damage equal to the current weapon's damage stat.
     * @param mob the monster to attack. 
     */
    public void attack(Monster mob){
        for (Item i : inventory){
            if (i instanceof Weapon w){
                if (currentBuff > 0){
                    mob.changeHp((int) (w.getDamage() * currentBuff));
                    currentBuff = 0;
                }else{
                    mob.changeHp(w.getDamage());
                }
                
            }else{
                if (currentBuff > 0){
                    mob.changeHp((int) (5 * currentBuff));
                    currentBuff = 0;
                }else{
                    mob.changeHp(5);
                }
                
            }
        }
    }

    /**
     * Add the specified item to the player's inventory
     * @param i the item to add
     */
    public void pickUpItem(Item i){
        if(i instanceof Weapon){
            inventory.add(0, i);
        }else{
            inventory.add(i);
        }
    }

    /**
     * Ends the game if the player passes through an exit
     * remaining code is a relic of a now-defunct door system
     * @param d the door to enter
     */
    public void goThroughDoor(Door d){
        if (d.isExit()){
            //TODO Add an ending, kill program or something idk
            System.out.println("You win!");
        } else {
            //TODO Make this do something lol
        }
    }

    /**
     * Removes the potion from the player's inventory and applies its health and buff changes
     * @param p the potion to consume
     */
    public void usePotion(Potion p){
        hp = hp + p.getHpVal();
        currentBuff = currentBuff + p.getBuffVal();
        inventory.remove(p);
    }

    /**
     * Modifies the player's HP by the indicated damage.
     */
    public void takeDmg(int dmg){
        hp = hp - dmg;
    }

    /**
     * Removes the given item from the player's inventory.
     */
    public void removeItem(Item r){
        for (Item i : inventory){
            if (i.equals(r)){
                inventory.remove(i);
            }
        }
    }
}
