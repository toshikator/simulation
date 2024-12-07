package second_project.simulation.actions.foodFinder;

import second_project.simulation.Coordinates;
import second_project.simulation.MapUtility;

import java.util.*;
import java.util.stream.Collectors;

public class BFS {
    NodeOnMapBFS start;
    Class foodType;
    Queue<NodeOnMapBFS> openSet;
    HashSet<NodeOnMapBFS> closedSet;

    public BFS(Coordinates start, Class foodType) {
        this.start = new NodeOnMapBFS(null, start);
        this.foodType = foodType;
//        System.out.println("BFS food type = " + this.foodType);
        openSet = new LinkedList<>();
        closedSet = new HashSet<>();
    }

    public Coordinates findFood() {
        openSet.add(new NodeOnMapBFS(start, start.getCoordinates()));

        while (!openSet.isEmpty()) {
            NodeOnMapBFS currentNode = openSet.poll();
            closedSet.add(currentNode);
            HashSet<Coordinates> closedSetCoordinates = (HashSet<Coordinates>) closedSet.stream().map(NodeOnMapBFS::getCoordinates).collect(Collectors.toSet());

            MapUtility.getAvailableMoveCoordinates(currentNode.getCoordinates()).stream().filter(e -> !closedSetCoordinates.contains(e)).forEach(e -> openSet.add(new NodeOnMapBFS(currentNode, e)));
//            System.out.println("goal food type = " + foodType);
            System.out.println("possible food type = " + MapUtility.getEntityByCoordinates(currentNode.getCoordinates()).getClass());

            if (MapUtility.getEntityByCoordinates(currentNode.getCoordinates()).getClass().equals(foodType)) {
                return currentNode.getCoordinates();
            }
        }
        return null;
    }
}
