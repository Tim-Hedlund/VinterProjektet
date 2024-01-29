import java.util.Random;

public class Tetromino {

    Random rand = new Random();
    int direction = 0;
    int x;
    int y = 0;
    int[][][] rotations; //Alla håll en tetromino kan befinna sig i, 4 per tetromino, 1 betyder att den finns och 0 betyder att den inte.
    Class<? extends Tetromino>[] tetrominoClasses = new Class[] {ITetromino.class, JTetromino.class, LTetromino.class, OTetromino.class, STetromino.class, TTetromino.class, ZTetromino.class};
    int color;

    public Tetromino() {

    }

    public Tetromino returnRandomTetromino () {

        int tetrominoCount = tetrominoClasses.length;

        int randNum = rand.nextInt(tetrominoCount);

        try {
            // Create an instance of a random Tetromino subclass
            return tetrominoClasses[randNum].newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace(); // Handle the exception according to your needs
            return null;
        }

    }

    public int[][] returnOccupiedPositions() {
        int tetrominosLeft = 4;

        int[][] currentPositions = new int[tetrominosLeft][2];
        int[][] currentRotation = this.rotations[this.direction];

        for (int y = 0; y < currentRotation.length; y++) {
            for (int x = 0; x < currentRotation[0].length; x++) {

                if (isOccupied(x, y, currentRotation)) {

                    currentPositions[4-tetrominosLeft][0] = y + this.y;
                    currentPositions[4-tetrominosLeft][1] = x + this.x;

                    tetrominosLeft--;
                }

                if (tetrominosLeft == 0) {
                    break;
                }
            }

            if (tetrominosLeft == 0) {
                break;
            }
        }

        return currentPositions;
    }

    private boolean isOccupied(int x, int y, int[][] currentRotation) {

        return getValueAt(x, y, currentRotation) == 1;

    }

    private int getValueAt(int x, int y, int [][] currentRotation) {

        return currentRotation[y][x];

    }

    public int getColor() {
        return this.color;
    }





}