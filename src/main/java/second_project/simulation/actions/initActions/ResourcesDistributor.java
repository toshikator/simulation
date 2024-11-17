package second_project.simulation.actions.initActions;

import second_project.simulation.AppConstants;
import second_project.simulation.actions.Action;
import second_project.simulation.entities.Entity;
import second_project.simulation.entities.resources.Grass;
import second_project.simulation.entities.resources.Rock;
import second_project.simulation.entities.resources.Tree;
import second_project.simulation.map.Map;

import java.util.HashMap;
import java.util.HashSet;

public class ResourcesDistributor extends InitActions {

    public ResourcesDistributor(Map map) {
        super(map);
    }

    @Override
    public void applyStartPositions() {
        setGrass();
        setRocks();
        setTrees();
    }
}


