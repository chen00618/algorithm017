package week07;

import java.util.Arrays;

/**
 * @program: test
 * @description: 解数独
 * @author: ChenWeiJun
 * @create: 2020-11-15 22:27
 **/
public class SolveSudoku {

    public void solveSudoku(char[][] board) {
        dfs(board,0);
    }
    private boolean dfs(char[][] board, int n) {
        if (n == 81) return true;
        int row = n/9;
        int col = n%9;
        if (board[row][col] != '.') return dfs(board,n+1);

        boolean[] notUsed = new boolean[10];
        validNumber(board,row,col,notUsed);
        for (int i=1;i<=9;i++) {
            if (notUsed[i]) {
                board[row][col] = (char)('0'+i);
                if (dfs(board,n+1)) return true;
            }
        }
        board[row][col] = '.';
        return false;
    }

    private void validNumber(char[][] board, int row, int col, boolean[] notUsed) {
        Arrays.fill(notUsed,true);
        for (int i=0;i<9;i++) {
            if (board[row][i] != '.') notUsed[board[row][i] - '0'] = false;
            if (board[i][col] != '.') notUsed[board[i][col] - '0'] = false;
            int r = row/3 * 3 + i/3;
            int c = col/3 * 3 + i%3;
            if (board[r][c] != '.') notUsed[board[r][c] - '0'] = false;
        }
    }
}
