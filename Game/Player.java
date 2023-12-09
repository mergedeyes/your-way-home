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