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
    private int[][] PlayerVisitedMap = { // Player visited map. 0 = not visited, 1 = visited. Player starts at 1,1.
        {0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0}
    };
    
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

    public void printPlayerVisitedMap() {
        for (int i = 0; i < mapLength; i++) {
            for (int j = 0; j < PlayerVisitedMap[i].length; j++) {
                System.out.print(PlayerVisitedMap[i][j] + " ");
            }
            System.out.println(); // Go to next line after printing each row
        }
    }

    public void printMap(int[][] playerVisitedMap, int[][] map) {
        clearScreen(); // Aufräumen, bevor die Karte gedruckt wird
        System.out.println("Map:\n");
        // Map of location types to characters
        Map<Integer, Character> locationSymbols = new HashMap<>();
        locationSymbols.put(0, 'F'); // Forest
        locationSymbols.put(1, 'B'); // Bushes
        locationSymbols.put(2, 'C'); // Castle
        locationSymbols.put(3, 'S'); // Spidercave
        locationSymbols.put(4, 'T'); // Tree House
        locationSymbols.put(5, 'R'); // Ruined Castle
        locationSymbols.put(6, 'M'); // Mystical Lake
        locationSymbols.put(7, 'G'); // Graveyard
        locationSymbols.put(8, 'E'); // Enchanted Garden
        locationSymbols.put(9, 'U'); // Catacombs
        locationSymbols.put(10, 'D'); // Deserted Village
    
        for (int i = 0; i < playerVisitedMap.length; i++) {
            for (int j = 0; j < playerVisitedMap[i].length; j++) {
                if (playerVisitedMap[i][j] == 1) {
                    // Player has visited this location, print its symbol
                    System.out.print(locationSymbols.get(map[i][j]) + " ");
                } else {
                    // Player has not visited this location, print 'X'
                    System.out.print("X ");
                }
            }
            System.out.println(); // New line at the end of each row
        }
        System.out.println(); // New line at the end of the map
        System.out.println("Legend:");
        System.out.println("F = Forest, B = Bushes, C = Castle, S = Spidercave, T = Tree House, R = Ruined Castle\nM = Mystical Lake, G = Graveyard, E = Enchanted Garden, U = Catacombs, D = Deserted Village\nX = Unvisited location");
        System.out.println("\nPress enter to continue...");
        scanner.nextLine();
        clearScreen();
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

    public Game() {
        // Initialisiere das Spiel mit einem Spieler und einem Start-Raum
        scanner = new Scanner(System.in);
        System.out.println("Welcome to the game!");
        wait(600);
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        player = new Player(name, 1, 1, 0);
        initializeRooms();
        updateCurrentRoom();
        System.out.println(currentRoom.getDescription());
        System.out.println("\nYou are now in at X: " + player.getPosition()[0] + ", Y: " + player.getPosition()[1] + ".\n");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            PlayerVisitedMap[player.getPosition()[0]][player.getPosition()[1]] = 1;
            //System.out.println("Map:\n");
            //printPlayerVisitedMap();
            System.out.println("\nIn which direction do you want to go? (North, South, East, West) | type 'map' to see where everything is | type 'quit' to exit");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("quit")) {
                break; // Spiel beenden, wenn der Spieler "quit" eingibt
            }

            if (input.equals("map")) {
                printMap(PlayerVisitedMap, map);
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
