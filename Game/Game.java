public class Game {
    // ... Andere Methoden und Attribute ...

    private void processInput(String input) {
        switch (input.toLowerCase()) {
            case "w": player.move("north"); break;
            case "s": player.move("south"); break;
            case "a": player.move("west"); break;
            case "d": player.move("east"); break;
            case "m": displayMap(); break;
            case "i": displayInventory(); break;
            // Weitere Befehle ...
        }
    }

    // ... Andere Methoden ...
}

public class Player {
    // ... Andere Attribute ...

    public void move(String direction) {
        if (currentRoom.isMovePossible(direction)) {
            // Bewege den Spieler und aktualisiere den Raum
        } else {
            System.out.println("Du kannst hier nicht in diese Richtung gehen.");
        }
    }
}

public class Room {
    // ... Andere Attribute ...

    public boolean isMovePossible(String direction) {
        // Überprüft, ob die Bewegung in die gewünschte Richtung möglich ist
        // Basierend auf den Eigenschaften des aktuellen Raums
    }

    // ... Andere Methoden ...
}
