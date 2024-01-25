public class ZTetromino extends Tetromino {

    public ZTetromino() {

        super.color = 5;
        super.x = 3;
        super.rotations = new int[][][]
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
