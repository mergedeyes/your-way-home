package Rooms;

public class Cave extends Room{
    
        public Cave() {
            super("You are at the entrance of a cave.");
        }
    
        @Override
        public String getActions() {
            return "You can go \"inside\", \"North\", \"South\", \"East\" or \"West\".";
        }

        @Override
        public String getName() {
            return "Cave";
        }
}
