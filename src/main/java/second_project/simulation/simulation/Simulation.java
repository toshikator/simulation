package second_project.simulation.simulation;

import second_project.simulation.AppConstants;
import second_project.simulation.actions.initActions.CreaturesDistributor;
import second_project.simulation.actions.initActions.ResourcesDistributor;
import second_project.simulation.entities.Entity;
import second_project.simulation.entities.creatures.Carnivore;
import second_project.simulation.entities.creatures.Creature;
import second_project.simulation.entities.creatures.Herbivore;
import second_project.simulation.entities.resources.Grass;
import second_project.simulation.entities.resources.Rock;
import second_project.simulation.entities.resources.Tree;
import second_project.simulation.map.Map;
import second_project.simulation.renderer.ConsoleRenderer;

import java.util.HashMap;
import java.util.HashSet;

public class Simulation {
    private final Map map;
    private final ConsoleRenderer consoleRenderer;

    public Simulation(Map map) {
        this.map = map;

        consoleRenderer = ConsoleRenderer.getInstance();

        ResourcesDistributor resourcesDistributor = new ResourcesDistributor(map);
        CreaturesDistributor creaturesDistributor = new CreaturesDistributor(map);

        resourcesDistributor.applyStartPositions();
        creaturesDistributor.applyStartPositions();
    }

    public void renderMap() {
        consoleRenderer.render(map);
    }

    public void makeMove() {
        map.getEntities().forEach(entity -> {
            if (entity instanceof Creature) {
                ((Creature) entity).makeAction();
            }
        });
    }
}