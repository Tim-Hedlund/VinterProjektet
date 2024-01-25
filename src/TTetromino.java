public class TTetromino extends Tetromino {

    public TTetromino() {
        super.color = 1;
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
