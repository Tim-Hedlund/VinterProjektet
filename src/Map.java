public class Map {

    private int[][] map;

    private void changeValue(int x, int y, int value) {

        if (this.map.length >= y && y >= 0) {
            if (this.map[0].length >= x && x >= 0) {
                this.map[y][x] = value;
                return;
            }
        }

        System.out.println("ERROR, Out of bounds");
        System.out.print("X = " + x);
        System.out.println(" : Y = " + y);
    }

    private void printMap() {
        int height = this.map.length;
        int width = this.map[0].length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int value = this.map[i][j];
                if (value == 0) {
                    System.out.print("_");
                } else {
                    System.out.print(value);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }


    public Map(int mapDefaultValue, int height, int width) {
        this.map = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.map[i][j] = mapDefaultValue;
            }
        }

        //Test values
        changeValue(0, 0, 1);
        changeValue(1, 2, 2);
        changeValue(2, 4, 3);
        changeValue(3, 4, 3);
        changeValue(4, 4, 3);
        changeValue(5, 4, 3);
        changeValue(5, 8, 3);
        changeValue(6, 4, 3);
        changeValue(7, 4, 3);
        changeValue(8, 4, 3);
        changeValue(9, 19, 5);


        printMap();
    }

    public int getWidth() {

        return this.map[0].length;

    }

    public int getHeight() {

        return this.map.length;

    }

    public int getValueAt(int x, int y) {

        if (this.map[0].length > x) {
            if (this.map.length > y) {
                return this.map[y][x];
            }
        }


        return(-1);

    }

    public void moveDown(int x, int y) {

        int value = this.getValueAt(x, y);
        this.changeValue(x, y, 0);
        this.changeValue(x, y+1, value);

    }

    public void clearRow(int currentY) {

        for (int i = 0; i < this.getWidth(); i++) {

            this.changeValue(i, currentY, 0);

        }

    }

    public void setValues(int[][] positions, int value) {

        for (int i = 0; i < positions.length; i++) {

            int x = positions[i][1];
            int y = positions[i][0];
            changeValue(x, y, value);

        }

    }

    public boolean hasCollided(Tetromino currentTetromino) {

        int[][] tetrominoPositions = currentTetromino.returnOccupiedPositions();

        for (int i = 0; i < tetrominoPositions.length; i++) {

            int currentY = tetrominoPositions[i][0];
            int currentX = tetrominoPositions[i][1];

            if (getValueAt(currentX, currentY) != 0) {

                return true;

            }

        }

        return false;

    }
}