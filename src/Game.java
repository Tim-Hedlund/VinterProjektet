import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Game extends JFrame {

    private static final int unitSize = 20;
    private Timer timer;
    private Map map;

    public Game(Map map) {
        this.map = map;
    }

    void startGame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tetris");
        setSize(this.map.getWidth() * unitSize, this.map.getHeight() * unitSize);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawGrid(g);
            }
        };

        add(panel);

        // Set up the timer to update colors every 16 milliseconds (60 times per second)
        timer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the method to update the game state (e.g., move tetrominos)
                // updateGame();

                panel.repaint();
            }
        });
        timer.start();
    }

    private void drawGrid(Graphics g) {
        for (int i = 0; i < this.map.getHeight(); i++) {
            for (int j = 0; j < this.map.getWidth(); j++) {
                // Assuming you have a method getColorAt(i, j) in your Map class
                int colorValue = this.map.getValueAt(i, j);
                drawCube(g, i, j, colorValue);
            }
        }
    }

    private Color getColor(int colorValue) {

        switch(colorValue) {
            case 1:
                return getColor().getRed()

        }


    }

    private void drawCube(Graphics g, int row, int col, int colorValue) {

        Color color = getColor(colorValue);

        g.setColor(color);
        g.fillRect(col * unitSize, row * unitSize, unitSize, unitSize);
        g.setColor(Color.BLACK);
        g.drawRect(col * unitSize, row * unitSize, unitSize, unitSize);
    }

    // Add methods to update the game state (e.g., move tetrominos) if needed

}

