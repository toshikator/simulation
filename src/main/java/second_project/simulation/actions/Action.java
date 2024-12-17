package second_project.simulation.actions;

import second_project.simulation.map.SimulationMap;

abstract public class Action {

    protected final SimulationMap simulationMap;

    protected Action(SimulationMap simulationMap) {
        this.simulationMap = simulationMap;
    }
}
