package second_project.simulation;

import second_project.simulation.actions.initActions.ResourcesDistributor;
import second_project.simulation.entities.resources.Grass;
import second_project.simulation.entities.resources.Resource;
import second_project.simulation.entities.resources.Rock;
import second_project.simulation.entities.resources.Tree;
import second_project.simulation.map.Map;
import second_project.simulation.renderer.ConsoleRenderer;

import java.util.HashMap;

public class SimulationApplication {
    public static final Integer worldWidth = 20;
    public static final Integer worldHeight = 20;
    public static final Integer rocksAmount = 23;
    public static final Integer treesAmount = 23;
    public static final Integer grassAmount = 33;

    public static void main(String[] args) {

        HashMap<Resource, Integer> resources = new HashMap<>();
        resources.put(new Grass(), grassAmount);
        resources.put(new Rock(), rocksAmount);
        resources.put(new Tree(), treesAmount);
        Coordinates worldSize = new Coordinates(worldHeight, worldWidth);
        Map map = new Map(worldSize);
        ResourcesDistributor resourcesDistributor = new ResourcesDistributor(map, resources);
        resourcesDistributor.applyStartPositions();
        ConsoleRenderer consoleRenderer = ConsoleRenderer.getInstance();
        consoleRenderer.render(map);
//        System.out.println(ConsolePics.ROCK.getPic());
    }
}
