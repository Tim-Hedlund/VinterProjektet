import javax.swing.*;
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

    private static Game startGame() {
        int mapHeight = 20;
        int mapWidth = 10;
        int mapDefaultValue = 0;

        Map map = new Map(mapDefaultValue, mapHeight, mapWidth);

        return new Game(map);

    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            Game game = startGame();

                start();
            try {
                game.startGame();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            game.setVisible(true);

        });

    }

}
