package second_project.simulation.actions.initActions;

import second_project.simulation.AppConstants;
import second_project.simulation.actions.Action;

import second_project.simulation.entities.creatures.Carnivore;
import second_project.simulation.entities.creatures.Herbivore;
import second_project.simulation.entities.resources.Grass;
import second_project.simulation.entities.resources.Rock;
import second_project.simulation.entities.resources.Tree;
import second_project.simulation.map.Map;

public abstract class InitActions extends Action {

    protected InitActions(Map map) {
        super(map);
    }

    public abstract void applyStartPositions();

    protected void setGrass() {
        Grass grass;
        for (int j = 0; j < AppConstants.GRASS_AMOUNT; j++) {
            grass = new Grass(map.getEmptyRandomCoordinate());
            map.setEntityToCoordinate(grass.getCoordinates(), grass);
        }
    }

    protected void setRocks() {
        Rock rock;
        for (int j = 0; j < AppConstants.ROCKS_AMOUNT; j++) {
            rock = new Rock(map.getEmptyRandomCoordinate());
            map.setEntityToCoordinate(rock.getCoordinates(), rock);
        }
    }

    protected void setTrees() {
        Tree tree;
        for (int j = 0; j < AppConstants.TREES_AMOUNT; j++) {
            tree = new Tree(map.getEmptyRandomCoordinate());
            map.setEntityToCoordinate(tree.getCoordinates(), tree);
        }
    }

    protected void setHerbivores() {
        Herbivore herbivore;
        for (int j = 0; j < AppConstants.HERBIVORE_AMOUNT; j++) {
            herbivore = new Herbivore(map, map.getEmptyRandomCoordinate());
            map.setEntityToCoordinate(herbivore.getCoordinates(), herbivore);
        }
    }

    protected void setCarnivores() {
        Carnivore carnivore;
        for (int j = 0; j < AppConstants.CARNIVORE_AMOUNT; j++) {
            carnivore = new Carnivore(map, map.getEmptyRandomCoordinate());
            map.setEntityToCoordinate(carnivore.getCoordinates(), carnivore);
        }
    }
}
