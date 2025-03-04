package second_project.simulation;

import second_project.simulation.entities.creatures.Creature;
import second_project.simulation.map.SimulationMap;
import second_project.simulation.simulation.Simulation;

import java.util.stream.Collectors;

import static second_project.simulation.AppSettings.GAME_TURNS;

public class SimulationApplication {

    public static void main(String[] args) {

        char reply = 0;
        System.out.println("Welcome to the simulation!");
        while (reply != 'e') {
            reply = 0;
            System.out.println("Would you like to start the simulation?");
            System.out.println("Type 'y' to start the simulation");
            System.out.println("Type 'e' for exit");
            System.out.println("Type 's' to change the simulation settings");
            reply = MenuUtility.getCharacter();
            if (reply == 'y') {
                SimulationMap simulationMap = SimulationMap.getInstance();
                Simulation simulation = new Simulation();
                simulation.renderMap();

                for (int i = 0; i < GAME_TURNS; i++) {
                    if (MapUtility.getEntities().stream().filter(e -> e instanceof Creature).map(e -> e.getClass()).collect(Collectors.toSet()).toArray().length > 1) {
                        System.out.println();
                        simulation.makeMove();
                        simulation.renderMap();
                    }
                }
            }
            if (reply == 's') {
                MenuUtility.changeSettings();
            }
        }
    }
}
