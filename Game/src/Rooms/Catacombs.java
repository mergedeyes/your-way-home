package Rooms;

public class Catacombs extends Room{

    public Catacombs() {
        super("You are at the entrance of the underground catacombs.");
    }

    @Override
    public String getActions() {
        return "You can go \"inside\", \"North\", \"East\" or \"West\".";
    }

    @Override
    public String getName() {
        return "Catacombs";
    }

    @Override
    public String inside() {
        return "You are now inside the " + getName() + ".\n";
    }

}
