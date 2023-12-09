import java.util.ArrayList;
import java.util.List;

public class Player {
    private int xPosition;
    private int yPosition;
    private List<Item> inventory;
    private String mood;
    private int flashbacks;
    // Weitere Attribute wie Gesundheit usw.

    public Player(int startX, int startY) {
        this.xPosition = startX;
        this.yPosition = startY;
        this.inventory = new ArrayList<>();
        // Weitere Initialisierungen...
    }

    public void move(String direction) {
        // Logik für die Bewegung, abhängig von der Richtung
        switch (direction.toLowerCase()) {
            case "north": yPosition--; break;
            case "south": yPosition++; break;
            case "east":  xPosition++; break;
            case "west":  xPosition--; break;
        }
    }

    public void addItem(Item item) {
        // Füge einen Gegenstand zum Inventar hinzu
        inventory.add(item);
    }

    public void useItem(Item item) {
        // Verwende einen Gegenstand aus dem Inventar
        // Logik zur Verwendung des Gegenstands...
    }

    // Getter und Setter für xPosition, yPosition und weitere Attribute

    // Weitere Methoden nach Bedarf...

    public boolean move(String direction, Game game) {
        int newX = xPosition;
        int newY = yPosition;
    
        // Berechne die potentielle neue Position basierend auf der Richtung
        switch (direction.toLowerCase()) {
            case "north": newY--; break;
            case "south": newY++; break;
            case "east":  newX++; break;
            case "west":  newX--; break;
        }
    
        // Überprüfe, ob die neue Position innerhalb der Grenzen der Karte liegt
        if (newX >= 0 && newX < game.getMapWidth() && newY >= 0 && newY < game.getMapHeight()) {
            FieldInfo currentField = game.getFieldInfo(newX, newY);
    
            // Überprüfe, ob die Rückkehr zum Ursprungsfeld möglich ist
            boolean canReturn = switch (direction.toLowerCase()) {
                case "north" -> currentField.isMovePossibleSouth;
                case "south" -> currentField.isMovePossibleNorth;
                case "east"  -> currentField.isMovePossibleWest;
                case "west"  -> currentField.isMovePossibleEast;
                default -> false;
            };
    
            if (canReturn) {
                xPosition = newX;
                yPosition = newY;
                return true;
            }
        }
    
        return false;
    }
    
}
