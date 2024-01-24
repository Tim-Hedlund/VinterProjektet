public class LTetromino extends Tetromino {

    public LTetromino() {
        this.rotations = new int[][][]
            {
                {
                    {0, 0, 1},
                    {1, 1, 1},
                    {0, 0, 0},
                },
                {
                    {0, 1, 0},
                    {0, 1, 0},
                    {0, 1, 1},
                },
                {
                    {0, 0, 0},
                    {1, 1, 1},
                    {1, 0, 0},
                },
                {
                    {1, 1, 0},
                    {0, 1, 0},
                    {0, 1, 0},
                }
            };

    }

}
