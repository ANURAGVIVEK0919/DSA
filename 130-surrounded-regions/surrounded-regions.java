class Solution {

    public void solve(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        // Top and bottom boundary
        for (int col = 0; col < cols; col++) {
            dfs(board, 0, col);
            dfs(board, rows - 1, col);
        }

        // Left and right boundary
        for (int row = 0; row < rows; row++) {
            dfs(board, row, 0);
            dfs(board, row, cols - 1);
        }

        // Remaining O -> X
        // Safe # -> O
        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }

                if (board[row][col] == '#') {
                    board[row][col] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {

        // Invalid or not O
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length ||
            board[row][col] != 'O') {

            return;
        }

        // Mark as safe
        board[row][col] = '#';

        // Explore neighbours
        dfs(board, row - 1, col); // up
        dfs(board, row + 1, col); // down
        dfs(board, row, col - 1); // left
        dfs(board, row, col + 1); // right
    }
}