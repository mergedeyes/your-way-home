package Rooms;

public class MysticalLake extends Room{
    public MysticalLake(){
        super("You are at the mystical lake. It is surrounded by a dense forest. You can hear the sound of water flowing.");
    }

    @Override
    public String getActions(){
        return "You can go \"North\", \"South\", \"East\" or \"West\".";
    }

    @Override
    public String getName(){
        return "Mystical Lake";
    }
}
