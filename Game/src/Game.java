import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Rooms.*;

public class Game {
    private Player player;
    private Room currentRoom;
    private Map<Integer, Room> rooms;
    private Scanner scanner;
    private int[][] map = {
        {1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 10, 2, 1}, // Startpunkt, Wald, Verlassenes Dorf, Schloss
        {1, 0, 0, 6, 0, 3, 1},  // Wald, Mystischer See, Spinnenhöhle
        {1, 0, 4, 0, 0, 0, 1},  // Baumhaus der Hexe
        {1, 5, 0, 0, 0, 0, 1},  // Verlassene Ruine
        {1, 0, 7, 0, 0, 8, 1},  // Alter Friedhof, Verzauberter Garten
        {1, 1, 1, 1, 9, 1, 1}   // Unterirdische Katakomben
    };
    public int mapLength = map.length;
    
    
    public static void wait(int ms){
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public Game() {
        // Initialisiere das Spiel mit einem Spieler und einem Start-Raum
        scanner = new Scanner(System.in);
        System.out.println("Welcome to the game!");
        wait(1500);
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        player = new Player(name, 1, 1, 0);
        initializeRooms();
        updateCurrentRoom();
        System.out.println(currentRoom.getDescription());
        System.out.println("\nYou are now in at X: " + player.getPosition()[0] + ", Y: " + player.getPosition()[1] + ".\n");
    }

    private void initializeRooms() {
    rooms = new HashMap<>();
    rooms.put(0, new Forest());
    rooms.put(1, new Bushes());
    rooms.put(2, new Castle());
    rooms.put(3, new Cave());
    rooms.put(4, new TreeHouse());
    rooms.put(5, new RuinedCastle());
    rooms.put(6, new MysticalLake());
    rooms.put(7, new Graveyard());
    rooms.put(8, new EnchantedGarden());
    rooms.put(9, new Catacombs());
    rooms.put(10, new DesertedVillage());
    }


    private void updateCurrentRoom() {
        int[] pos = player.getPosition();
        int roomType = map[pos[0]][pos[1]]; // Benutze Y-Achse, dann X-Achse
        currentRoom = rooms.get(roomType);
    }

    public void clearScreen() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }
    

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("In which direction do you want to go? (North, South, East, West) | type 'quit' to exit");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("quit")) {
                break; // Spiel beenden, wenn der Spieler "quit" eingibt
            }

            player.action(input, mapLength); // Spieleraktion basierend auf Eingabe
            updateCurrentRoom();
            clearScreen();
            System.out.println(currentRoom.getDescription());
            System.out.println("\nYou are now in at X: " + player.getPosition()[1] + ", Y: " + player.getPosition()[0] + ".\n");
        }

        scanner.close();
    }

    public void closeGame() {
        scanner.close();
    }
}
