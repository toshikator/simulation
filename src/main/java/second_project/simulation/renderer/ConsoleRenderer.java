package second_project.simulation.renderer;

import second_project.simulation.ConsolePics;
import second_project.simulation.Coordinates;
import second_project.simulation.map.Map;

import java.awt.*;

public class ConsoleRenderer {
    private static ConsoleRenderer instance;

    private ConsoleRenderer() {

    }

    public static ConsoleRenderer getInstance() {
        if (instance == null) {
            instance = new ConsoleRenderer();
        }
        return instance;
    }

    public void render(Map map) {
        for (int y = 0; y < map.mapSize.ordinate; y++) {

            for (int x = 0; x < map.mapSize.abscissa; x++) {
                
                System.out.printf("%-3s", map.map.containsKey(new Coordinates(x, y)) ? map.map.get(new Coordinates(x, y)).img : ConsolePics.TILE.getPic());
            }

            System.out.println();
        }
    }
}
