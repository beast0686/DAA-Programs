public class NQueens {
    final int N = 4;

    void print(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j] + " ");
            System.out.println();
        }
    }

    boolean isSafe(int board[][], int row, int col) {
        int i, j;
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;
        return true;
    }

    boolean solve(int board[][], int col) {
        if (col >= N)
            return true;
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (solve(board, col + 1))
                    return true;
                board[i][col] = 0; // Backtrack
            }
        }
        return false;
    }

    boolean solveNQueens() {
        int board[][] = { { 0, 0, 0, 0 },
                          { 0, 0, 0, 0 },
                          { 0, 0, 0, 0 },
                          { 0, 0, 0, 0 } };

        if (!solve(board, 0)) {
            System.out.print("No solution exists");
            return false;
        }

        print(board);
        return true;
    }

    public static void main(String args[]) {
        NQueens queens = new NQueens();
        queens.solveNQueens();
    }
}