package second_project.simulation.actions.turnActions;

import second_project.simulation.actions.Action;
import second_project.simulation.entities.creatures.Creature;
import second_project.simulation.map.Map;

public class TurnActions extends Action {
    public TurnActions(Map map) {
        super(map);
    }

    public void makeMove() {
        map.getEntities().stream().filter(e -> e instanceof Creature creature).forEach(e -> ((Creature) e).makeAction());
    }
}
