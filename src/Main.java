import java.util.Scanner;

public class Main {

    private static final Scanner keyboard = new Scanner(System.in);
    private static void start() {
        while (true) {
            System.out.println("start new game? : y/n");
            System.out.println();

            String start = keyboard.nextLine();

            if (start.equalsIgnoreCase("y")) {
                break;
            } else if (start.equalsIgnoreCase("n")) {
                System.exit(0);
            }
        }
    }

    private static Map createMap() {
        int mapHeight = 20;
        int mapWidth = 10;
        int mapDefaultValue = 0;

        return new Map(mapDefaultValue, mapHeight, mapWidth);

    }


    public static void main(String[] args) {

        while (true) {
            start();
            Map map = createMap();

        }

    }



}
