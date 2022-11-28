public class bajrang_conways_gol {
    public static int[][] nextGeneration(int inputGrid[][]) {
        int row = 4, col = 3;
        int[][] future = new int[row][col];
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                int aliveNeighbours = 0;
                int rowAbove = Math.max(x - 1, 0);
                int rowBelow = Math.min(x + 1, row - 1);
                int colLeft = Math.max(y - 1, 0);
                int colRight = Math.min(y + 1, col - 1);
                for (int rowToCheck = rowAbove; rowToCheck <= rowBelow; rowToCheck++)
                    for (int colToCheck = colLeft; colToCheck <= colRight; colToCheck++)
                        aliveNeighbours += inputGrid[rowToCheck][colToCheck];
                aliveNeighbours -= inputGrid[x][y];
                if (aliveNeighbours == 3)
                    future[x][y] = 1;

                else if (aliveNeighbours < 2)
                    future[x][y] = 0;

                else if (aliveNeighbours >= 4)
                    future[x][y] = 0;

                else if (aliveNeighbours == 2)
                    future[x][y] = inputGrid[x][y];
                else
                    throw new RuntimeException("Unhandled neighbor condition");
            }
        } return future;
    }
    public static void main(String[] args) {
        int[][] game = { { 0, 1, 0 },
                { 0, 0, 1 },
                { 1, 1, 1 },
                { 0, 0, 0 }
        };
        var nextGen = nextGeneration(game);
        for (var row : nextGen) {
            for (var cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}
