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
            System.out.println();
            for (int j = 0; j < width; j++) {
                System.out.print(this.map[i][j]);

            }

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
        changeValue(-1, -1 , -1);

        printMap();
    }

    public int getHeight() {

        return this.map.length;

    }

    public int getWidth() {

        return this.map[0].length;

    }

    public int getValueAt(int x, int y) {

        if (this.map[0].length > x) {
            if (this.map.length > y) {
                return this.map[y][x];
            }
        }

        return(-1);

    }

}
