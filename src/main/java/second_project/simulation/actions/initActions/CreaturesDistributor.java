package second_project.simulation.actions.initActions;

import second_project.simulation.map.SimulationMap;

public class CreaturesDistributor extends InitActions {
    public CreaturesDistributor(SimulationMap simulationMap) {
        super(simulationMap);
    }

    @Override
    public void applyStartPositions() {
        setHerbivores();
        setCarnivores();
    }
}
