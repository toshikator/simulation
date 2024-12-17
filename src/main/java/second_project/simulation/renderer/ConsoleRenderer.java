package second_project.simulation.renderer;

import second_project.simulation.AppConstants;
import second_project.simulation.ConsolePics;
import second_project.simulation.Coordinates;
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
        for (int y = 0; y < AppConstants.WORLD_HEIGHT; y++) {

            for (int x = 0; x < AppConstants.WORLD_WIDTH; x++) {

                System.out.printf("%-3s", simulationMap.isCoordinateEmpty(new Coordinates(x, y)) ? ConsolePics.TILE.getPic() : simulationMap.getEntityByCoordinates(new Coordinates(x, y)).getImg());
            }

            System.out.println();
        }
    }
}
