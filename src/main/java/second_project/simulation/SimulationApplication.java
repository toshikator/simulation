package second_project.simulation;

import second_project.simulation.actions.initActions.CreaturesDistributor;
import second_project.simulation.actions.initActions.ResourcesDistributor;
import second_project.simulation.entities.Entity;
import second_project.simulation.entities.creatures.Carnivore;
import second_project.simulation.entities.creatures.Herbivore;
import second_project.simulation.entities.resources.Grass;

import second_project.simulation.entities.resources.Rock;
import second_project.simulation.entities.resources.Tree;
import second_project.simulation.map.Map;
import second_project.simulation.renderer.ConsoleRenderer;
import second_project.simulation.simulation.Simulation;

import java.util.HashMap;

public class SimulationApplication {

    public static void main(String[] args) {

        Coordinates worldSize = new Coordinates(AppConstants.worldHeight, AppConstants.worldWidth);
        Map map = new Map(worldSize);
        Simulation simulation = new Simulation(map);
        simulation.renderMap();
    }
}
