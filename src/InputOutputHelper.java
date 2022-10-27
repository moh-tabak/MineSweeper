import java.util.Scanner;

public class InputOutputHelper {
    static Scanner sc = new Scanner(System.in);


    public int getValidInt(String output) {
        while(true) {
            System.out.printf(output);
            if (sc.hasNextInt()) {
                return sc.nextInt();
            }
        }
    }

    public int letterToInt(Character c) {
        return Character.toLowerCase(c) - 97;
    }

    public void clearScreen() {
        System.out.println("\033[H\033[2J");
    }
}
