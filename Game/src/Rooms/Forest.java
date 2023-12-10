package Rooms;

public class Forest extends Room{
        
            public Forest() {
                super("You are in a forest.");
            }
        
            @Override
            public String getActions() {
                return "You can go \"North\", \"South\", \"East\" or \"West\".";
            }
}
