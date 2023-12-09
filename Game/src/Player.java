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
        return position;
    }

    public void move(String direction) {
        switch (direction.toLowerCase()) {
            case "w":
                position[1]--; // Bewegung nach Norden verringert die Y-Position
                break;
            case "s":
                position[1]++; // Bewegung nach Süden erhöht die Y-Position
                break;
            case "d":
                position[0]++; // Bewegung nach Osten erhöht die X-Position
                break;
            case "a":
                position[0]--; // Bewegung nach Westen verringert die X-Position
                break;
            default:
                System.out.println("That is not a valid direction!");
        }
    }
}
