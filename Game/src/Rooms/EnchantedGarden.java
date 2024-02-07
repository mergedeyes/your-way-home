package Rooms;

public class EnchantedGarden extends Room{
        
    public EnchantedGarden() {
        super("You are in an enchanted garden.");
    }
        
    @Override
    public String getActions() {
        return "You can go \"inside\", \"North\", \"South\", \"East\" or \"West\".";
    }

    @Override
    public String getName() {
        return "Enchanted Garden";
    }

    @Override
    public String inside() {
        return "You are now inside the " + getName() + ".\n";
    }


}
