package Rooms;
public class Room {
    private String description;

    public Room(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getExtra() {
        return ""; // Standardimplementierung
    }

    public String getActions(){
        return ""; // Standardimplementierung
    }

    public String getName(){
        return ""; // Standardimplementierung
    }

    public String inside(){
        return ""; // Standardimplementierung
    }
}
