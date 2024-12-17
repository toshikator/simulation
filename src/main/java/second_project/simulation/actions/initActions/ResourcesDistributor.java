package second_project.simulation.actions.initActions;

import second_project.simulation.map.SimulationMap;

public class ResourcesDistributor extends InitActions {

    public ResourcesDistributor(SimulationMap simulationMap) {
        super(simulationMap);
    }

    @Override
    public void applyStartPositions() {
        setGrass();
        setRocks();
        setTrees();
    }
}


