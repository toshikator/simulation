package second_project.simulation;

public final class AppConstants {

    public static int WORLD_WIDTH = 16;
    public static int WORLD_HEIGHT = 16;
    public static int ROCKS_AMOUNT = 17;
    public static int TREES_AMOUNT = 7;
    public static int GRASS_AMOUNT = 5;
    public static int CARNIVORE_AMOUNT = 14;
    public static int HERBIVORE_AMOUNT = 14;
    public static int CARNIVORE_SPEED = 3;
    public static int HERBIVORE_SPEED = 4;
    public static int CARNIVORE_HEALTH = 17;
    public static int HERBIVORE_HEALTH = 19;
    public static int CARNIVORE_STRENGTH = 4;
    public static int GAME_TURNS = 120;

    private AppConstants() {
        System.out.println("Entities for AppConstants are not allowed");
    }

    public static void setWorldWidth(int worldWidth) {
        WORLD_WIDTH = worldWidth;
    }

    public static void setWorldHeight(int worldHeight) {
        WORLD_HEIGHT = worldHeight;
    }

    public static void setRocksAmount(int rocksAmount) {
        ROCKS_AMOUNT = rocksAmount;
    }

    public static void setTreesAmount(int treesAmount) {
        TREES_AMOUNT = treesAmount;
    }

    public static void setGrassAmount(int grassAmount) {
        GRASS_AMOUNT = grassAmount;
    }

    public static void setCarnivoreAmount(int carnivoreAmount) {
        CARNIVORE_AMOUNT = carnivoreAmount;
    }

    public static void setHerbivoreAmount(int herbivoreAmount) {
        HERBIVORE_AMOUNT = herbivoreAmount;
    }

    public static void setCarnivoreSpeed(int carnivoreSpeed) {
        CARNIVORE_SPEED = carnivoreSpeed;
    }

    public static void setHerbivoreSpeed(int herbivoreSpeed) {
        HERBIVORE_SPEED = herbivoreSpeed;
    }

    public static void setCarnivoreHealth(int carnivoreHealth) {
        CARNIVORE_HEALTH = carnivoreHealth;
    }

    public static void setHerbivoreHealth(int herbivoreHealth) {
        HERBIVORE_HEALTH = herbivoreHealth;
    }

    public static void setCarnivoreStrength(int carnivoreStrength) {
        CARNIVORE_STRENGTH = carnivoreStrength;
    }

    public static void setGameTurns(int gameTurns) {
        GAME_TURNS = gameTurns;
    }
}
