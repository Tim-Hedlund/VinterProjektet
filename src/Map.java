public class Map {
    private int[][] map;

    private void printMap(int[][] map) {

        int width = map.length;
        int height = map[0].length;

        for (int i = 0; i < width; i++) {
            System.out.println();
            for (int j = 0; j < height; j++) {
                System.out.print(map[i][j]);
            }

        }

    }

    public Map(int mapDefaultValue, int height, int width) {

        this.map = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.map[i][j] = mapDefaultValue;
            }

        }

        printMap(this.map);

    }

}
