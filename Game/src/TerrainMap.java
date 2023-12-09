import java.util.Map;
import java.util.HashMap;

public class TerrainMap {
    public static Map<Integer, Character> getMap() {
        Map<Integer, Character> terrainMap = new HashMap<>();
        terrainMap.put(0, '*'); // Plus für Wald
        terrainMap.put(1, '*'); // Stern für Wald
        terrainMap.put(2, '▓'); // Block für Mauer
        // Weitere Zuordnungen...
        return terrainMap;
    }
    
    private int[][] map = {
        {1, 1, 1, 1, 1, 1, 1},
        {1, 99, 0, 0, 10, 2, 1}, // Startpunkt, Wald, Verlassenes Dorf, Schloss
        {1, 0, 0, 6, 0, 3, 1},  // Wald, Mystischer See, Spinnenhöhle
        {1, 0, 4, 0, 0, 0, 1},  // Baumhaus der Hexe
        {1, 5, 0, 0, 0, 0, 1},  // Verlassene Ruine
        {1, 0, 7, 0, 0, 8, 1},  // Alter Friedhof, Verzauberter Garten
        {1, 1, 1, 1, 9, 1, 1}   // Unterirdische Katakomben
    };
}
