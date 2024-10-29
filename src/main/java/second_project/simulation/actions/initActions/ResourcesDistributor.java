package second_project.simulation.actions.initActions;

import second_project.simulation.Coordinates;
import second_project.simulation.actions.Action;
import second_project.simulation.entities.resources.Resource;
import second_project.simulation.map.Map;

import java.util.HashMap;
import java.util.Random;

public class ResourcesDistributor extends Action {
    private final Map map;
    private final HashMap<Resource, Integer> resources;

    public ResourcesDistributor(Map map, HashMap<Resource, Integer> resources) {
//        System.out.println("resourcesPut constructor");
        this.map = map;
        this.resources = resources;
    }

    public void applyStartPositions() {
//        System.out.println("resourcesPut apply startPositions");
        resources.forEach((k, v) -> {
            for (int i = 0; i < v; i++) {
                setResource(k);
            }
        });
    }

    private void setResource(Resource resource) {
//        System.out.println("resourcesPut setResource");
        resource.coordinates = getRandomCoordinate();
        while (map.map.containsKey(resource.coordinates)) {
            resource.coordinates = getRandomCoordinate();
        }
        map.map.put(resource.coordinates, resource);
    }

    private Coordinates getRandomCoordinate() {
//        System.out.println("resourcesPut getRandomCoordinate");
        Integer abscissa = getRandomIntegerInLimit(map.mapSize.abscissa);
        Integer ordinate = getRandomIntegerInLimit(map.mapSize.ordinate);
        return new Coordinates(abscissa, ordinate);
    }

    private Integer getRandomIntegerInLimit(Integer limit) {
//        System.out.println("resourcesPut getRandomIntegerInLimit");
        Random random = new Random();
        return random.nextInt(limit);
    }
}
