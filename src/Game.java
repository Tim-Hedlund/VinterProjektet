import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Game extends JFrame {

    private static final int unitSize = 30;
    private Timer timer;
    private Map map;
    private int state;
    private int currentFrame = 0;
    private int lastClearFrame = 0;
    private int dropSpeed = 1;

    public Game(Map map) {
        this.map = map;
    }

    void startGame() throws InstantiationException, IllegalAccessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tetris");

        setSize(314, 638); //
        setLocationRelativeTo(null);


        ArrayList<Tetromino> tetrominoOrder = createTetrominos();

        this.state = 1; //1 = running

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawGrid(g);
            }
        };

        add(panel);

        // 16 milliseconds = (60 times per second)
        timer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the method to update the game state (e.g., move tetrominos)

                updateGame(tetrominoOrder);
                currentFrame += 1;

                panel.repaint();
            }
        });
        timer.start();
    }

    private ArrayList<Tetromino> createTetrominos() {
        int arrayLength = 3; //sets arrayLength long enough to show next pieces.
        Tetromino tetromino = new Tetromino();

        ArrayList<Tetromino> returnTetrominos = new ArrayList<>();


        for (int i = 0; i < arrayLength; i++) {

            returnTetrominos.add(tetromino.returnRandomTetromino());

        }

        return returnTetrominos;

    }


    private void drawGrid(Graphics g) {
        for (int i = 0; i < this.map.getWidth(); i++) {
            for (int j = 0; j < this.map.getHeight(); j++) {
                int colorValue = this.map.getValueAt(i, j);
                drawCube(g, i, j, colorValue);
            }
        }
    }

    private Color getColor(int colorValue) {
        switch (colorValue) {
            case 0 -> { return Color.GRAY; }
            case 1 -> { return Color.PINK; }
            case 2 -> { return Color.BLUE; }
            case 3 -> { return Color.CYAN; }
            case 4 -> { return Color.GREEN; }
            case 5 -> { return Color.RED; }
            case 6 -> { return Color.YELLOW; }
            case 7 -> { return Color.ORANGE; }
            case 8 -> { return new Color(212, 175, 55); }//Gold
        }

        System.out.println("Error, null color value");
        return Color.BLACK;
    }

    private void drawCube(Graphics g, int row, int col, int colorValue) {
        Color color = getColor(colorValue);

        g.setColor(color);
        g.fillRect(row * unitSize, col * unitSize, unitSize, unitSize);
        g.setColor(Color.BLACK);
        g.drawRect(row * unitSize, col * unitSize, unitSize, unitSize);
    }

    private void updateGame(ArrayList<Tetromino> tetrominoOrder) {

        if (this.state == 1) {
            
            removeTetromino(tetrominoOrder);
            //applyGravity();
            checkRows();
            moveTetromino(tetrominoOrder, dropSpeed);
            
        } else if (this.state == 2) {
            
            playClearAnimation();

        }

    }

    private void removeTetromino(ArrayList<Tetromino> tetrominoOrder) {

        Tetromino currentTetromino = tetrominoOrder.get(0);

        int[][] tetrominoPositions = currentTetromino.returnOccupiedPositions();

        this.map.setValues(tetrominoPositions, 0);

    }
/*
    private int[][] fixPositions(int[][] localPositions, Tetromino currentTetromino) {

        int tetrominoY = currentTetromino.y;
        int tetrominoX = currentTetromino.x;

        for (int i = 0; i < localPositions.length; i++) {

            localPositions[i][0] += tetrominoY;
            localPositions[i][1] += tetrominoX;

        }

        return localPositions;

    }
*/
    private void moveTetromino(ArrayList<Tetromino> tetrominoOrder, int dropAmount) {

        Tetromino currentTetromino = tetrominoOrder.get(0);

        for (int i = 0; i < dropAmount; i++) {

            currentTetromino.y ++;

            if (this.map.hasCollided(currentTetromino)) {

                currentTetromino.y --;

                this.map.setValues(currentTetromino.returnOccupiedPositions(), currentTetromino.getColor());

                tetrominoOrder.remove(0);
                tetrominoOrder.add(currentTetromino.returnRandomTetromino());

            }

        }
        
    }

    private void playClearAnimation() {

        int animationLength = 20; //gör delbar av animationFrameCount

        if (this.currentFrame - this.lastClearFrame > animationLength) {

            this.state = 1;
            checkRows();

        }
        
    }

    /*
        private void playClearAnimation(int y) {
            int animationFrameNum = this.currentFrame - this.lastClearFrame;
            int animationFrameTicks = 2;
    
            if (animationFrameNum % animationFrameTicks == 0) {
    
    
    
            }
    
        }
    */
    private void checkRows() {

        for (int i = 0; i < this.map.getHeight(); i++) {

            int currentY = this.map.getHeight() - 1 - i;

            if (isRowFull(currentY)) {

                this.map.clearRow(currentY);
                this.lastClearFrame = this.currentFrame;

            }

        }

    }

    private boolean isRowFull(int currentY) {

        int x = 0;
        for (int i = 0; i < this.map.getWidth(); i++) {

            if (this.map.getValueAt(x, currentY) == 0) {
                break;
            }
            System.out.println(i + " is occupied");
            x += 1;

        }

        if (x == this.map.getWidth()) {
            return true;
        }
        return false;

    }

    private void applyGravity() {

        for (int y = 0; y < this.map.getHeight(); y++) {
            for (int x = 0; x < this.map.getWidth(); x++) {

                if (!hasLowerNeighbor(x, y)) {

                    this.map.moveDown(x, y);

                }

            }

        }

    }




    private boolean hasLowerNeighbor(int x, int y) {

        if (y == 19) {
            return true;
        } else if (this.map.getValueAt(x, y+1) != 0) {
            return true;
        } else {
            return false;
        }

    }

}
