package second_project.simulation;

import java.util.Scanner;

public class MenuUtility {

    public static void changeSettings() {
        Character character;
        System.out.println("Please enter the character you would like to change:");
        System.out.println("a - to change carnivore amount");
        System.out.println("b - to change herbivore amount");
        System.out.println("c - to change carnivore speed");
        System.out.println("d - to change herbivore health");
        System.out.println("e - to change game turns");
        System.out.println("f - to change carnivore strength");
        System.out.println("g - to change herbivore speed");
        System.out.println("h - to change rocks amount");
        System.out.println("i - to change grass amount");
        System.out.println("j - to change trees amount");
        System.out.println("k - to change world height");
        System.out.println("l - to change world width");

        character = getCharacter();
        switch (character) {
            case 'a':
                System.out.println("Plz, input carnivore amount");
                AppConstants.setCarnivoreAmount(getIntegerWithLimits(1, 30));
                System.out.println("carnivore amount now is " + AppConstants.CARNIVORE_AMOUNT);
                break;
            case 'b':
                System.out.println("Plz, input herbivore amount");
                AppConstants.setHerbivoreAmount(getIntegerWithLimits(1, 30));
                System.out.println("herbivore amount now is " + AppConstants.HERBIVORE_AMOUNT);
                break;
            case 'c':
                System.out.println("Plz, input carnivore speed");
                AppConstants.setCarnivoreSpeed(getIntegerWithLimits(1, 6));
                System.out.println("carnivore speed now is " + AppConstants.CARNIVORE_SPEED);
                break;
            case 'd':
                System.out.println("Plz, input herbivore health");
                AppConstants.setHerbivoreHealth(getIntegerWithLimits(1, 30));
                System.out.println("herbivore health now is " + AppConstants.HERBIVORE_HEALTH);
                break;
            case 'e':
                System.out.println("Plz, input game turns");
                AppConstants.setGameTurns(getIntegerWithLimits(1, 30));
                System.out.println("game turns now is " + AppConstants.GAME_TURNS);
                break;
            case 'f':
                System.out.println("Plz, input carnivore strength");
                AppConstants.setCarnivoreStrength(getIntegerWithLimits(1, 6));
                System.out.println("carnivore strength now is " + AppConstants.CARNIVORE_STRENGTH);
                break;
            case 'g':
                System.out.println("Plz, input herbivore speed");
                AppConstants.setHerbivoreSpeed(getIntegerWithLimits(1, 6));
                System.out.println("herbivore speed now is " + AppConstants.HERBIVORE_SPEED);
                break;
            case 'h':
                System.out.println("Plz, input rocks amount");
                AppConstants.setRocksAmount(getIntegerWithLimits(1, 30));
                System.out.println("rocks amount now is " + AppConstants.ROCKS_AMOUNT);
                break;
            case 'i':
                System.out.println("Plz, input grass amount");
                AppConstants.setGrassAmount(getIntegerWithLimits(1, 30));
                System.out.println("grass amount now is " + AppConstants.GRASS_AMOUNT);
                break;
            case 'j':
                System.out.println("Plz, input trees amount");
                AppConstants.setTreesAmount(getIntegerWithLimits(1, 30));
                System.out.println("trees amount now is " + AppConstants.TREES_AMOUNT);
                break;
            case 'k':
                System.out.println("Plz, input world height");
                AppConstants.setWorldHeight(getIntegerWithLimits(1, 30));
                System.out.println("world height now is " + AppConstants.WORLD_HEIGHT);
                break;
            case 'l':
                System.out.println("Plz, input world width");
                AppConstants.setWorldWidth(getIntegerWithLimits(1, 30));
                System.out.println("world width now is " + AppConstants.WORLD_WIDTH);
                break;
            default:
                System.out.println("Invalid character, you have an invalid mindset");
                break;
        }
    }

    public static Integer getIntegerWithLimits(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int number = -1;

        do {
            System.out.print("Enter an integer between : " + min + " and " + max);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
            }
        } while (scanner.nextInt() < min || scanner.nextInt() > max);
        return number;
    }

    public static Character getCharacter() {
        Scanner scanner = new Scanner(System.in);
        char symbol = ' ';

        while (true) {
            System.out.print("Enter a single character: ");
            String input = scanner.nextLine();
            if (input.length() == 1) {
                symbol = input.charAt(0);
                break;
            } else {
                System.out.println("Please enter exactly one character.");
            }
        }
        return symbol;
    }
}
