package Rooms;

public class Graveyard extends Room{
        
            public Graveyard() {
                super("You are in a graveyard.");
            }
            @Override
            public String getActions() {
                return "You can go \"inside\", \"North\", \"South\", \"East\" or \"West\".";
            }
}
