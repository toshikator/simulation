package second_project.simulation;

public final class AppConstants {

    public static final int WORLD_WIDTH = 16;
    public static final int WORLD_HEIGHT = 16;
    public static final int ROCKS_AMOUNT = 17;
    public static final int TREES_AMOUNT = 7;
    public static final int GRASS_AMOUNT = 5;
    public static final int CARNIVORE_AMOUNT = 14;
    public static final int HERBIVORE_AMOUNT = 14;
    public static final int CARNIVORE_SPEED = 3;
    public static final int HERBIVORE_SPEED = 4;
    public static final int CARNIVORE_HEALTH = 17;
    public static final int HERBIVORE_HEALTH = 19;
    public static final int CARNIVORE_STRENGTH = 4;
    public static final int GAME_TURNS = 20;

    private AppConstants() {
        System.out.println("Entities for AppConstants are not allowed");
    }
}
