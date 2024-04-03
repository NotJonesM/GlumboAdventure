import java.util.ArrayList;

public class Player {
    private int hp;
    private String name;
    private ArrayList<Item> inventory;
    private double currentBuff = 0;
    private int row;
    private int col;

    //Constructors
    public Player(){
        name = "Nameless";
        hp = 100;
    }

    public Player(String name){
        this.name = name;
        hp = 100;
    }
    //Accessors
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

    //Methods

    public void moveUp() { row--; }
    public void moveDown() { row++; }
    public void moveLeft() { col--; }
    public void moveRight() { col++; }

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

    public void pickUpItem(Item i){
        if(i instanceof Weapon){
            inventory.add(0, i);
        }else{
            inventory.add(i);
        }
    }

    public void goThroughDoor(Door d){
        if (d.isExit()){
            //TODO Add an ending, kill program or something idk
            System.out.println("You win!");
        }else{
            //TODO Make this do something lol
        }
    }

    public void usePotion(Potion p){
        hp = hp + p.getHpVal();
        currentBuff = currentBuff + p.getBuffVal();
        inventory.remove(p);
    }

    public void takeDmg(int dmg){
        hp = hp - dmg;
    }

    public void removeItem(Item r){
        for (Item i : inventory){
            if (i.equals(r)){
                inventory.remove(i);
            }
        }
    }
}
