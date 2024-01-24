public class JTetromino extends Tetromino {

    public JTetromino() {
        this.rotations = new int[][][]
            {
                {
                    {1, 0, 0},
                    {1, 1, 1},
                    {0, 0, 0},
                },
                {
                    {0, 1, 1},
                    {0, 1, 0},
                    {0, 1, 0},
                },
                {
                    {0, 0, 0},
                    {1, 1, 1},
                    {0, 0, 1},
                },
                {
                    {0, 1, 0},
                    {0, 1, 0},
                    {1, 1, 0},
                }
            };

    }

}
