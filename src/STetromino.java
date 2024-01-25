public class STetromino extends Tetromino {

    public STetromino() {
        super.color = 4;
        super.x = 3;
        super.rotations = new int[][][]
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
