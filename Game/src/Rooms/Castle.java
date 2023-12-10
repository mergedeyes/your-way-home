package Rooms;

public class Castle extends Room{
    public Castle(){
        super("You stand before a pompous castle.");
    }

    @Override  
    public String getActions() {
        return "You can go \"inside\", \"North\", \"South\", \"East\" or \"West\".";
    }
}
