package second_project.simulation.actions.turnActions;

import second_project.simulation.actions.Action;
import second_project.simulation.entities.creatures.Creature;
import second_project.simulation.map.SimulationMap;

public class TurnActions extends Action {
    public TurnActions(SimulationMap simulationMap) {
        super(simulationMap);
    }

    public void makeMove() {
        simulationMap.getEntities().stream().parallel().filter(e -> e instanceof Creature && !((Creature) e).isDead()).forEach(e -> ((Creature) e).makeAction());
    }
}
