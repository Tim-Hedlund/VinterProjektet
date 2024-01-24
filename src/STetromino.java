public class STetromino extends Tetromino {

    public STetromino() {
        this.rotations = new int[][][]
            {
                {
                    {0, 1, 1},
                    {1, 1, 0},
                    {0, 0, 0},
                },
                {
                    {0, 1, 0},
                    {0, 1, 1},
                    {0, 0, 1},
                },
                {
                    {0, 0, 0},
                    {0, 1, 1},
                    {1, 1, 0},
                },
                {
                    {1, 0, 0},
                    {1, 1, 0},
                    {0, 1, 0},
                }
            };

    }

}
