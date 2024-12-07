package second_project.simulation;

import second_project.simulation.map.Map;
import second_project.simulation.simulation.Simulation;

import static second_project.simulation.AppConstants.GAME_TURNS;

public class SimulationApplication {

    public static void main(String[] args) {

        Map map = new Map();
        MapUtility.setMap(map);
        Simulation simulation = new Simulation(map);
        simulation.renderMap();

        for (int i = 0; i < GAME_TURNS; i++) {
            System.out.println();
            simulation.makeMove();
            simulation.renderMap();
        }
    }
}
