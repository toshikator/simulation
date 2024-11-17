package second_project.simulation.actions.initActions;

import second_project.simulation.actions.Action;
import second_project.simulation.entities.Entity;
import second_project.simulation.map.Map;

import java.util.HashMap;
import java.util.HashSet;

public class CreaturesDistributor extends InitActions {
    public CreaturesDistributor(Map map) {
        super(map);
    }

    @Override
    public void applyStartPositions() {
        setHerbivores();
        setCarnivores();
    }
}
