public class Map {
    int[][] map;

    public Map(int mapDefaultValue, int height, int width) {

        this.map = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.map[i][j] = mapDefaultValue;
            }

        }

    }



}
