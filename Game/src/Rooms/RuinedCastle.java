package Rooms;

public class RuinedCastle extends Room{
            
                public RuinedCastle() {
                    super("You are in a ruined castle.");
                }
            
                @Override
                public String getActions() {
                    return "You can go \"North\", \"South\", \"East\" or \"West\".";
                }
}
