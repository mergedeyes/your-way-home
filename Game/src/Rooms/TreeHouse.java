package Rooms;

public class TreeHouse extends Room{
            
    public TreeHouse() {
        super("You are in a tree house.");
    }
            
    @Override
    public String getActions() {
        return "You can go \"up\", \"North\", \"South\", \"East\" or \"West\".";
    }

    @Override
    public String getName() {
        return "Tree House";
    }

    @Override
    public String inside() {
        return "You are now inside the " + getName() + ".\n";
    }
}
