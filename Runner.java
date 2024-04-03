import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Dungeon d = new Dungeon("The Undercity", 5, 5, new ArrayList<Entity>(), new ArrayList<Entity>(), 0, 0, 5, 5);
        Player p = new Player("Yourself");
        Scanner scan = new Scanner(System.in);

        while(true) { // ###### MAIN RUNNER LOOP #####
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
                    if (p.getHp() <= 0) { System.out.println("You lose."); break;}
                }
            }

        }
    }
}
