package second_project.simulation.simulation;

import second_project.simulation.actions.initActions.CreaturesDistributor;
import second_project.simulation.actions.initActions.ResourcesDistributor;
import second_project.simulation.actions.turnActions.TurnActions;

import second_project.simulation.map.Map;
import second_project.simulation.renderer.ConsoleRenderer;

public class Simulation {
    private final Map map;
    private final ConsoleRenderer consoleRenderer;
    private final TurnActions turnActions;

    public Simulation(Map map) {

        this.map = map;
        turnActions = new TurnActions(map);

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
        turnActions.makeMove();
    }
}