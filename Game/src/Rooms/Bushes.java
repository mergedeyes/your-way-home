package Rooms;

public class Bushes extends Room {
    public Bushes(){
        super("Thick thorny bushes surround you.");
    }

    @Override  
    public String getActions() {
        return "You can't go any further. You need to go back.";
    }

    @Override
    public String getName(){
        return "Bushes";
    }
}
