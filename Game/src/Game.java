import java.util.Scanner;

public class Game {
    private Player player;
    private Room currentRoom;
    private Scanner scanner;
    
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
        currentRoom = new Room("Ein dunkler, geheimnisvoller Wald.");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("In which direction do you want to go? (North, South, East, West) | type 'quit' to exit");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("quit")) {
                break; // Spiel beenden, wenn der Spieler "quit" eingibt
            }

            player.move(input); // Spielerbewegung basierend auf Eingabe
            System.out.println("You are now in room X: " + player.getPosition()[0] + ", Y: " + player.getPosition()[1] + ".");
            System.out.println(currentRoom.getDescription());
        }

        scanner.close();
    }

    public void closeGame() {
        scanner.close();
    }
}
