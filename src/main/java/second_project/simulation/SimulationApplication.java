package second_project.simulation;

import second_project.simulation.map.Map;
import second_project.simulation.simulation.Simulation;

public class SimulationApplication {

    public static void main(String[] args) {

        Map map = new Map();
        MapUtility.setMap(map);
        Simulation simulation = new Simulation(map);
        simulation.renderMap();

        for (int i = 0; i < 15; i++) {
            System.out.println();
            simulation.makeMove();
            simulation.renderMap();
        }
    }
}
