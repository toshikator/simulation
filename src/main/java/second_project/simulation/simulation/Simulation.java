package second_project.simulation.simulation;

import second_project.simulation.actions.initActions.CreaturesDistributor;
import second_project.simulation.actions.initActions.ResourcesDistributor;
import second_project.simulation.actions.turnActions.TurnActions;

import second_project.simulation.map.SimulationMap;
import second_project.simulation.renderer.ConsoleRenderer;

public class Simulation {
    private final SimulationMap simulationMap;
    private final ConsoleRenderer consoleRenderer;
    private final TurnActions turnActions;

    public Simulation(SimulationMap simulationMap) {

        this.simulationMap = simulationMap;
        turnActions = new TurnActions(simulationMap);

        simulationMap.removeDeadCreatures();
        consoleRenderer = ConsoleRenderer.getInstance();

        ResourcesDistributor resourcesDistributor = new ResourcesDistributor(simulationMap);
        CreaturesDistributor creaturesDistributor = new CreaturesDistributor(simulationMap);

        resourcesDistributor.applyStartPositions();
        creaturesDistributor.applyStartPositions();
    }

    public void renderMap() {
        consoleRenderer.render(simulationMap);
    }

    public void makeMove() {
        turnActions.makeMove();
        simulationMap.removeDeadCreatures();
    }
}