package second_project.simulation;

import second_project.simulation.map.SimulationMap;
import second_project.simulation.simulation.Simulation;

import static second_project.simulation.AppConstants.GAME_TURNS;

public class SimulationApplication {

    public static void main(String[] args) {

        SimulationMap simulationMap = new SimulationMap();
        MapUtility.setMap(simulationMap);
        Simulation simulation = new Simulation(simulationMap);
        simulation.renderMap();

        for (int i = 0; i < GAME_TURNS; i++) {
            System.out.println();
            simulation.makeMove();
            simulation.renderMap();
        }
    }
}
