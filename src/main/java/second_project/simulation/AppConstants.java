package second_project.simulation;

public final class AppConstants {

    public static final int worldWidth = 20;
    public static final int worldHeight = 20;
    public static final int rocksAmount = 33;
    public static final int treesAmount = 33;
    public static final int grassAmount = 33;
    public static final int carnivoreAmount = 30;
    public static final int herbivoreAmount = 30;
    public static final int carnivoreSpeed = 3;
    public static final int herbivoreSpeed = 4;
    public static final int carnivoreHealth = 17;
    public static final int herbivoreHealth = 19;
    public static final int carnivoreStrength = 4;

    private AppConstants() {
        System.out.println("Entities for AppConstants are not allowed");
    }
}
