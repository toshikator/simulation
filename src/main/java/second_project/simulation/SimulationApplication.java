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

import java.util.HashMap;

public class SimulationApplication {

    public static void main(String[] args) {
        Coordinates worldSize = new Coordinates(AppConstants.worldHeight, AppConstants.worldWidth);
        Map map = new Map(worldSize);
        HashMap<Entity, Integer> resources = new HashMap<>();
        ConsoleRenderer consoleRenderer = ConsoleRenderer.getInstance();
        HashMap<Entity, Integer> creatures = new HashMap<>();
        ResourcesDistributor resourcesDistributor = new ResourcesDistributor(map, resources);
        CreaturesDistributor creaturesDistributor = new CreaturesDistributor(map, creatures);

        resources.put(new Grass(), AppConstants.grassAmount);
        resources.put(new Rock(), AppConstants.rocksAmount);
        resources.put(new Tree(), AppConstants.treesAmount);
        creatures.put(new Carnivore(map), AppConstants.carnivoreAmount);
        creatures.put(new Herbivore(map), AppConstants.herbivoreAmount);
        resourcesDistributor.applyStartPositions();
        creaturesDistributor.applyStartPositions();

        while (true) {
            consoleRenderer.render(map);
        }
    }
}
