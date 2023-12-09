import java.util.Map;
import java.util.HashMap;

public class TerrainMap {
    public static Map<Integer, Character> getMap() {
        Map<Integer, Character> terrainMap = new HashMap<>();
        terrainMap.put(0, '+'); // Plus für Weg
        terrainMap.put(1, '*'); // Stern für Wald
        terrainMap.put(2, '▓'); // Block für Mauer
        // Weitere Zuordnungen...
        return terrainMap;
    }
}
