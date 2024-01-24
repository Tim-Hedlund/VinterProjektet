public class TTetromino extends Tetromino {

    public TTetromino() {
        this.rotations = new int[][][]
            {
                {
                    {0, 1, 0},
                    {1, 1, 1},
                    {0, 0, 0},
                },
                {
                    {0, 1, 0},
                    {0, 1, 1},
                    {0, 1, 0},
                },
                {
                    {0, 0, 0},
                    {1, 1, 1},
                    {0, 1, 0},
                },
                {
                    {0, 1, 0},
                    {1, 1, 0},
                    {0, 1, 0},
                }
            };

    }

}
