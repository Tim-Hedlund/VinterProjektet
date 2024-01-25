public class JTetromino extends Tetromino {

    public JTetromino() {
        super.color = 2;
        super.x = 3;
        super.rotations = new int[][][]
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
