package second_project.simulation.actions.pathfinder;

import second_project.simulation.Coordinates;
import second_project.simulation.map.SimulationMap;

import java.util.*;

public class AStarRouteTracer {

    private final SimulationMap simulationMap;
    private final NodeOnMapAStar startCoordinate;
    private final NodeOnMapAStar endCoordinate;
    private final HashMap<NodeOnMapAStar, Integer> route = new HashMap<>();

    public AStarRouteTracer(SimulationMap simulationMap, Coordinates start, Coordinates finish) {
        this.simulationMap = simulationMap;
        this.startCoordinate = new NodeOnMapAStar(start);
        this.endCoordinate = new NodeOnMapAStar(finish);
    }

    private Integer calculateCost(NodeOnMapAStar from, NodeOnMapAStar to) {
        return SimulationMap.calculateDistance(from.getCoordinates(), to.getCoordinates());
    }

    public List<NodeOnMapAStar> findPath() {
        PriorityQueue<NodeOnMapAStar> openSet = new PriorityQueue<>();
        HashSet<NodeOnMapAStar> closedSet = new HashSet<>();

        startCoordinate.setCostFromStart(0);
        startCoordinate.setCostToFinish(calculateCost(startCoordinate, endCoordinate));

        openSet.add(startCoordinate);
        route.put(startCoordinate, 0);

        while (!openSet.isEmpty()) {
            NodeOnMapAStar current = openSet.poll();

            if (calculateCost(current, endCoordinate) == 1) {
                return reconstructPath(current);
            }
            closedSet.add(current);

            simulationMap.getAvailableMoveCoordinates(current.getCoordinates()).forEach(c -> {
                NodeOnMapAStar neighbour = new NodeOnMapAStar(c);
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

    private List<NodeOnMapAStar> reconstructPath(NodeOnMapAStar current) {
        List<NodeOnMapAStar> path = new ArrayList<>();
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
