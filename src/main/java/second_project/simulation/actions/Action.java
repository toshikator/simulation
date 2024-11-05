package second_project.simulation.actions;

import second_project.simulation.entities.Entity;
import second_project.simulation.map.Map;

import java.util.HashMap;

abstract public class Action {

    protected final Map map;
    protected final HashMap<Entity, Integer> resources;

    protected Action(Map map, HashMap<Entity, Integer> resources) {
        this.map = map;
        this.resources = resources;
    }

    private void setResource(Entity resource) {
        this.map.setEntityToRandomEmptyCoordinate(resource);
    }

    public void applyStartPositions() {
        this.resources.forEach((k, v) -> {
            for (int i = 0; i < v; i++) {
                setResource(k);
            }
        });
    }
}
