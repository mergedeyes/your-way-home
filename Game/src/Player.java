public class Player {
    private String name;
    private int position []; // Position des Spielers im Raum
    private int flashbacks;

    public Player(String name, int xCurrent, int yCurrent, int currentFlashbacks) {
        this.name = name;
        this.position = new int[2]; // Initialisiere das Array
        this.position[0] = xCurrent;
        this.position[1] = yCurrent;
        this.flashbacks = currentFlashbacks;
    }

    public String getName() {
        return name;
    }

    public int[] getPosition() {
        return new int[] { position[1], position[0] }; // Gibt erst die Y-Achse, dann die X-Achse zurück
    }

    public boolean isValidMove(String direction, int mapLength) {
        int newX = position[0];
        int newY = position[1];

        switch (direction.toLowerCase()) {
            case "north": newY--; break;
            case "south": newY++; break;
            case "east":  newX++; break;
            case "west":  newX--; break;
        }

        // Überprüfe, ob die neue Position innerhalb der Grenzen der Karte liegt
        return newX >= 0 && newX < mapLength && newY >= 0 && newY < mapLength;
    }

    public void action(String direction, int mapLength) {
        switch (direction.toLowerCase()) {
            case "north":
                if (isValidMove(direction, mapLength)) {
                    position[1]--; // Bewegung nach Norden verringert die Y-Position
                } else {
                    System.out.println("You can't move in that direction.");
                }
                break;
            case "south":
                if (isValidMove(direction, mapLength)) {
                    position[1]++; // Bewegung nach Süden erhöht die Y-Position
                } else {
                    System.out.println("You can't move in that direction.");
                }
                break;
            case "east":
                if (isValidMove(direction, mapLength)) {
                    position[0]++; // Bewegung nach Osten erhöht die X-Position
                } else {
                    System.out.println("You can't move in that direction.");
                }
                break;
            case "west":
                if (isValidMove(direction, mapLength)) {
                    position[0]--; // Bewegung nach Westen verringert die X-Position
                } else {
                    System.out.println("You can't move in that direction.");
                }
                break;
            case "inside":
                // TODO: Implementiere die Aktion "inside"
            default:
                System.out.println("That is not a valid direction!");
        }
    }
}
