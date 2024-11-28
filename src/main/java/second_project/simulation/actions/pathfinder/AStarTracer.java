package second_project.simulation.actions.pathfinder;

import second_project.simulation.Coordinates;
import second_project.simulation.entities.Entity;
import second_project.simulation.entities.creatures.Creature;
import second_project.simulation.map.Map;

import java.util.*;

public class AStarTracer {

    private final Map map;

    private final NodeOnMap startCoordinate;
    private final NodeOnMap endCoordinate;
    private final HashMap<NodeOnMap, Integer> route = new HashMap<>();

    public AStarTracer(Map map, Coordinates start, Coordinates finish) {
        this.map = map;
        this.startCoordinate = new NodeOnMap(start);
        this.endCoordinate = new NodeOnMap(finish);
    }

    private Integer calculateCost(NodeOnMap from, NodeOnMap to) {
        return Map.calculateDistance(from.getCoordinates(), to.getCoordinates());
    }

    public List<NodeOnMap> findPath() {
        PriorityQueue<NodeOnMap> openSet = new PriorityQueue<>();
        HashSet<NodeOnMap> closedSet = new HashSet<>();

        startCoordinate.setCostFromStart(0);
        startCoordinate.setCostToFinish(calculateCost(startCoordinate, endCoordinate));

        openSet.add(startCoordinate);
        route.put(startCoordinate, 0);

        while (!openSet.isEmpty()) {
            NodeOnMap current = openSet.poll();

            if (calculateCost(current, endCoordinate) == 1) {
                return reconstructPath(current);
            }
            closedSet.add(current);

            map.getAvailableMoveCoordinates(current.getCoordinates()).forEach(c -> {
                NodeOnMap neighbour = new NodeOnMap(c);
                if (!closedSet.contains(neighbour)) {
                    Integer cost = current.getCostFromStart() + calculateCost(current, neighbour);
                    if (cost < route.getOrDefault(neighbour, Integer.MAX_VALUE)) {
                        neighbour.setParent(current);
                        neighbour.setCostFromStart(cost);
                        neighbour.setCostToFinish(calculateCost(neighbour, endCoordinate));
                        route.put(neighbour, cost);

                        if (!openSet.contains(neighbour)) {
                            openSet.add(neighbour);
                        }
                    }
                }
            });
        }

        return null;
    }

    private List<NodeOnMap> reconstructPath(NodeOnMap current) {
        List<NodeOnMap> path = new ArrayList<>();
        while (current != null) {
            path.add(current);
            current = current.getParent();
        }
        if (Objects.isNull(path)) {
            System.out.println("path is null");
        }
        Collections.reverse(path);
        return path;
    }
}
