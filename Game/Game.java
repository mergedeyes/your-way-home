import java.util.HashMap;
import java.util.Map;

public class Game {
    private GameWindow window;
    private Player player;
    private Map<Integer, Character> terrainMap = new HashMap<>();
    private int[][] map = {
        {1, 1, 1, 1, 1, 1, 1},
        {1, 99, 0, 0, 10, 2, 1}, // Startpunkt, Wald, Verlassenes Dorf, Schloss
        {1, 0, 0, 6, 0, 3, 1},  // Wald, Mystischer See, Spinnenhöhle
        {1, 0, 4, 0, 0, 0, 1},  // Baumhaus der Hexe
        {1, 5, 0, 0, 0, 0, 1},  // Verlassene Ruine
        {1, 0, 7, 0, 0, 8, 1},  // Alter Friedhof, Verzauberter Garten
        {1, 1, 1, 1, 9, 1, 1}   // Unterirdische Katakomben
    };
    private int mapLength;
    private FieldInfo[][] fieldInfos;
    

    public Game(GameWindow window) {
        this.window = window;
        this.player = new Player();
        this.terrainMap = TerrainMap.getMap();
    }

    public Game(int[][] mapData) {
        this.map = mapData;
        this.mapLength = map.length;
        fieldInfos = new FieldInfo[mapHeight][mapWidth];
        initializeFieldInfos();
    }

    private void initializeFieldInfos() {
        for (int i = 0; i < mapLength; i++) {
            for (int j = 0; j < mapLength; j++) {
                fieldInfos[i][j] = getFieldInfoBasedOnType(map[i][j]);
            }
        }
    }

    private FieldInfo getFieldInfoBasedOnType(int fieldType) {
        switch (fieldType) {
            case 0: // Wald: immer alle Richtungen
                return new FieldInfo(true, true, true, true);
            case 1: // Rand: keine Richtung
                return new FieldInfo(false, false, false, false);
            case 2: // Schloss
                return new FieldInfo(true, true, false, true);
            case 3: // Spinnenhöhle
                return new FieldInfo(true, true, true, false);
            case 4: // Baumhaus der Hexe
                return new FieldInfo(true, true, false, false);
            default:
                return new FieldInfo(false, false, false, false);
        }
    }

    private void displayMap() {
        StringBuilder mapDisplay = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                mapDisplay.append(terrainMap.get(map[i][j]));
            }
            mapDisplay.append("\n");
        }
        window.updateDisplay(mapDisplay.toString());
    }

    public void processPlayerCommand(String command) {
        switch (command.toLowerCase()) {
            case "w": player.move("north"); break;
            case "s": player.move("south"); break;
            case "a": player.move("west"); break;
            case "d": player.move("east"); break;
            case "m": displayMap(); break;
            case "i": displayInventory(); break;
            case "e": interact(); break;
        }
        window.updateDisplay("Ergebnis des Befehls...");
    }

}
