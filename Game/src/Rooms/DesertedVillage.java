package Rooms;

public class DesertedVillage extends Room{
    
        public DesertedVillage() {
            super("You are at the entrance of a deserted village.");
        }

        @Override
        public String getExtra() {
            return "There is a signpost here - you can \"read\" it.";
        }
    
        @Override
        public String getActions() {
            return "You can go \"inside\", \"North\", \"South\", \"East\" or \"West\".";
        }

        @Override
        public String getName() {
            return "Deserted Village";
        }

}
