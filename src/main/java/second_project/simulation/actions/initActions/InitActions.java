package second_project.simulation.actions.initActions;

import second_project.simulation.AppSettings;
import second_project.simulation.MapUtility;
import second_project.simulation.actions.Action;

import second_project.simulation.entities.creatures.Carnivore;
import second_project.simulation.entities.creatures.Herbivore;
import second_project.simulation.entities.resources.Grass;
import second_project.simulation.entities.resources.Rock;
import second_project.simulation.entities.resources.Tree;
import second_project.simulation.map.SimulationMap;

public abstract class InitActions extends Action {

    protected InitActions(SimulationMap simulationMap) {
        super(simulationMap);
    }

    public abstract void applyStartPositions();

    protected void setGrass() {
        Grass grass;
        for (int j = 0; j < AppSettings.GRASS_AMOUNT * simulationMap.getCoefficient(); j++) {
            grass = new Grass(simulationMap.getEmptyRandomCoordinate());
            simulationMap.setEntityToCoordinate(grass.getCoordinates(), grass);
        }
    }

    protected void setRocks() {
        Rock rock;
        for (int j = 0; j < AppSettings.ROCKS_AMOUNT * simulationMap.getCoefficient(); j++) {
            rock = new Rock(simulationMap.getEmptyRandomCoordinate());
            simulationMap.setEntityToCoordinate(rock.getCoordinates(), rock);
        }
    }

    protected void setTrees() {
        Tree tree;
        for (int j = 0; j < AppSettings.TREES_AMOUNT * simulationMap.getCoefficient(); j++) {
            tree = new Tree(simulationMap.getEmptyRandomCoordinate());
            simulationMap.setEntityToCoordinate(tree.getCoordinates(), tree);
        }
    }

    protected void setHerbivores() {
        Herbivore herbivore;
        for (int j = 0; j < AppSettings.HERBIVORE_AMOUNT * simulationMap.getCoefficient(); j++) {
            herbivore = new Herbivore(MapUtility.getEmptyRandomCoordinate());
            simulationMap.setEntityToCoordinate(herbivore.getCoordinates(), herbivore);
        }
    }

    protected void setCarnivores() {
        Carnivore carnivore;
        for (int j = 0; j < AppSettings.CARNIVORE_AMOUNT * simulationMap.getCoefficient(); j++) {
            carnivore = new Carnivore(MapUtility.getEmptyRandomCoordinate());
            simulationMap.setEntityToCoordinate(carnivore.getCoordinates(), carnivore);
        }
    }
}
