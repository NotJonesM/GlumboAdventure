import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ArrayList<Entity> monsters = new ArrayList<>();
        monsters.add(new Monster("Zombie", 32, 10));
        monsters.add(new Monster("Skeleton", 25, 5));
        monsters.add(new Monster("Spider", 20, 6));
        monsters.add(new Monster("Bat", 5, 2));
        monsters.add(new Monster("Zombie Knight", 40, 15));
        monsters.add(new Monster("Skeleton Knight", 35, 13));
        monsters.add(new Monster("Bat", 5, 2));
        monsters.add(new Monster("Bat", 5, 2));
        monsters.add(new Monster("Bat", 5, 2));
        monsters.add(new Monster("Zombie", 32, 10));
        monsters.add(new Monster("Skeleton", 25, 5));
        monsters.add(new Monster("Spider", 20, 6));
        monsters.add(new Monster("Zombie", 32, 10));
        monsters.add(new Monster("Skeleton", 25, 5));
        monsters.add(new Monster("Spider", 20, 6));
        monsters.add(new Monster("Zombie Knight", 40, 15));
        monsters.add(new Monster("Skeleton Knight", 35, 13));

        ArrayList<Entity> items = new ArrayList<>();
        items.add(new Weapon("Longsword", 13, false, false));
        items.add(new Weapon("Shortsword", 9, false, false));
        items.add(new Weapon("Dagger", 7, false, false));
        items.add(new Weapon("Stick", 6, false, false));
        items.add(new Weapon("Severed Arm", 1, false, false));
        items.add(new Weapon("Sharp Bone", 3, false, false));
        items.add(new Weapon("Excalibur", 50, false, false));
        items.add(new Weapon("Worn Longsword", 10, false, false));
        items.add(new Weapon("Worn Shortsword", 8, false, false));
        items.add(new Weapon("Dagger", 7, false, false));
        items.add(new Weapon("Stick", 6, false, false));
        items.add(new Weapon("Dagger", 7, false, false));
        items.add(new Weapon("Stick", 6, false, false));
        items.add(new Weapon("Worn Longsword", 10, false, false));
        items.add(new Weapon("Worn Shortsword", 8, false, false));
        items.add(new Weapon("Worn Longsword", 10, false, false));
        items.add(new Weapon("Worn Shortsword", 8, false, false));

        System.out.println("Welcome to Glumbo Adventure, the text-based dungeon crawler you know and love! Move around the map by typing the keywords “Move Up”, “Move Down”, “Move Left”, and “Move Right”. Fight your way through enemies and collect cool treasure! Good luck and have fun!");

        Dungeon d = new Dungeon("The Undercity", 5, 5, items, monsters, 0, 0, 5, 5);
        Player p = new Player("Yourself");
        Scanner scan = new Scanner(System.in);
        boolean running = true;

        while(running) { // ###### MAIN RUNNER LOOP #####
            System.out.print("Enter a command: ");
            String in = scan.nextLine().toUpperCase();
            Room currentRoom = d.getDungeon().get(p.getRow()).get(p.getCol());
            if (GlumboToolbox.matchStart(in, "GRAB")) { 
                Entity item = currentRoom.getContents().get((currentRoom.getContents().indexOf(in.substring(5, in.length()))));
                System.out.println("You pick up the " + item.getName());
                p.pickUpItem((Item) item);
                currentRoom.removeEntity(item);
            }
            else if (GlumboToolbox.matchStart(in, "ATTACK")) {
                Monster mob = (Monster) currentRoom.getContents().get((currentRoom.getContents().indexOf(in.substring(7, in.length()))));
                System.out.println("You attack the " + mob.getName() + ", leaving it with " + mob.getHp() + " hit points!");
                p.attack(mob);
                if (mob.getHp() <= 0) { 
                    currentRoom.removeEntity(mob); 
                    System.out.println("You killed the " + mob.getName());
                }
            }
            else if (GlumboToolbox.matchStart(in, "MOVE")) {
                System.out.println("You move one room " + in.substring(5, in.length()));
                switch(in.substring(5, in.length())) {
                    case "UP": { p.moveUp(); break; }
                    case "DOWN": { p.moveDown(); break; }
                    case "LEFT": { p.moveLeft(); break; }
                    case "RIGHT": { p.moveRight(); break; }
                }
                System.out.println(currentRoom);
            }
            else if (GlumboToolbox.matchStart(in, "USE")) {
                Potion pot = (Potion) p.getInventory().get(p.getInventory().indexOf(in.substring(4, in.length())));
                p.usePotion(pot);
            }
            else if (GlumboToolbox.matchStart(in, "INVENTORY")) { 
                System.out.println(p.getInventory()); // TODO idk if this will work
            }
            else { System.out.println("Command not recognized!"); }

            d.printMap();

            for (Entity e : currentRoom.getContents()) {
                if (e instanceof Monster) {
                    Monster m = (Monster) e;
                    System.out.println(m.getName() + " deals " + m.getDmg() + "to you!");
                    p.takeDmg(m.getDmg());
                    System.out.println("You are at " + p.getHp() + "/100 HP!");
                    if (p.getHp() <= 0) { System.out.println("You lose."); running = false; break;}
                }
            }

        }
    }
}
