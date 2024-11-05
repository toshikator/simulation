package second_project.simulation.renderer;

import second_project.simulation.ConsolePics;
import second_project.simulation.Coordinates;
import second_project.simulation.map.Map;

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
        for (int y = 0; y < map.getMapSize().ordinate; y++) {

            for (int x = 0; x < map.getMapSize().abscissa; x++) {

                System.out.printf("%-3s", map.isCoordinateEmpty(new Coordinates(x, y)) ? ConsolePics.TILE.getPic() : map.getEntityByCoordinates(new Coordinates(x, y)).getImg());
            }

            System.out.println();
        }
    }
}
