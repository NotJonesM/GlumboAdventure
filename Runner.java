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
            if (GlumboToolbox.matchStart(in, "GRAB")) { /* TODO add get item functionality */}
            else if (GlumboToolbox.matchStart(in, "ATTACK")) { /* TODO add attack functionality */}
            else if (GlumboToolbox.matchStart(in, "MOVE")) {
                switch(in.substring(4, in.length())) {
                    case "UP": { p.moveUp(); break; }
                    case "DOWN": { p.moveDown(); break; }
                    case "LEFT": { p.moveLeft(); break; }
                    case "RIGHT": { p.moveRight(); break; }
                }
                System.out.println(d.getDungeon().get(p.getRow()).get(p.getCol()));
            }
            else if (GlumboToolbox.matchStart(in, "USE")) { /* TODO add use functionality */}
            else { System.out.println("Command not recognized!"); }
        }
    }
}
