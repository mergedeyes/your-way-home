public class FieldInfo {
    public boolean isMovePossibleNorth;
    public boolean isMovePossibleSouth;
    public boolean isMovePossibleEast;
    public boolean isMovePossibleWest;

    public FieldInfo(boolean north, boolean south, boolean east, boolean west) {
        this.isMovePossibleNorth = north;
        this.isMovePossibleSouth = south;
        this.isMovePossibleEast = east;
        this.isMovePossibleWest = west;
    }
}
