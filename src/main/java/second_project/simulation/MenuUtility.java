package second_project.simulation;

import java.util.Scanner;

public class MenuUtility {

    public static void changeSettings() {
        Character character;
        System.out.println("h - to change world height");
        System.out.println("w - to change world width");

        character = getCharacter();
        switch (character) {

            case 'h':
                System.out.println("Plz, input world height");
//                AppSettings.setWorldHeight(getIntegerWithLimits(1, 30));
                System.out.println("world height now is " + AppSettings.WORLD_HEIGHT);
                break;
            case 'w':
                System.out.println("Plz, input world width");
//                AppSettings.setWorldWidth(getIntegerWithLimits(1, 30));
                System.out.println("world width now is " + AppSettings.WORLD_WIDTH);
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
