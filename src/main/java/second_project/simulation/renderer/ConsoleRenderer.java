package second_project.simulation.renderer;

import second_project.simulation.AppSettings;
import second_project.simulation.ConsolePics;
import second_project.simulation.Coordinates;
import second_project.simulation.MapUtility;
import second_project.simulation.map.SimulationMap;

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

    public void render(SimulationMap simulationMap) {
        for (int y = 0; y < MapUtility.getMap().getWorldHeight(); y++) {

            for (int x = 0; x < MapUtility.getMap().getWorldWidth(); x++) {

                System.out.printf("%-3s", simulationMap.isCoordinateEmpty(new Coordinates(x, y)) ? ConsolePics.TILE.getPic() : simulationMap.getEntityByCoordinates(new Coordinates(x, y)).getImg());
            }

            System.out.println();
        }
    }
}
