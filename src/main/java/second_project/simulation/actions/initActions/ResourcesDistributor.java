package second_project.simulation.actions.initActions;

import second_project.simulation.actions.Action;
import second_project.simulation.entities.Entity;
import second_project.simulation.map.Map;

import java.util.HashMap;

public class ResourcesDistributor extends Action {

    public ResourcesDistributor(Map map, HashMap<Entity, Integer> resources) {
        super(map, resources);
    }
}
