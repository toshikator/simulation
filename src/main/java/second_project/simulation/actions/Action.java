package second_project.simulation.actions;

import second_project.simulation.AppConstants;
import second_project.simulation.entities.Entity;
import second_project.simulation.entities.resources.Grass;
import second_project.simulation.map.Map;

import java.util.HashMap;
import java.util.HashSet;

abstract public class Action {

    protected final Map map;

    protected Action(Map map) {
        this.map = map;
    }
}
