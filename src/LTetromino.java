public class LTetromino extends Tetromino {

    public LTetromino() {

        super.x = 3;
        super.rotations = new int[][][]
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
