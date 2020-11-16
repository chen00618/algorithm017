package week07;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: test
 * @description: N皇后
 * @author: ChenWeiJun
 * @create: 2020-11-15 22:26
 **/
public class SolveNQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) return res;
        char[][] chess = new char[n][n];
        for (int i = 0;i<n;i++) {
            for (int j=0;j<n;j++)
                chess[i][j] = '.';
        }
        helper(chess,0,res);
        return res;
    }
    private void helper(char[][] chess, int row, List<List<String>> res) {
        if (row == chess.length) {
            res.add(StringBuild(chess));
            return;
        }

        for (int col = 0;col < chess.length;col++) {
            if (check(chess,row,col)) {
                chess[row][col] = 'Q';
                helper(chess,row+1,res);
                chess[row][col] = '.';
            }
        }
    }

    private boolean check(char[][] chess, int row, int col) {
        //检查合法性
        for (int i=chess[row].length-1;i>=0;i--){
            if(chess[i][col] == 'Q') return false;
        }

        for (int i = row - 1,j = col + 1;i>=0 && j<chess[row].length;i--,j++) {
            if (chess[i][j] == 'Q') return false;
        }

        for (int i = row - 1,j = col - 1;i>=0 && j>=0;i--,j--) {
            if (chess[i][j] == 'Q') return false;
        }
        return true;
    }

    private List<String> StringBuild(char[][] chess) {
        List<String> list  = new ArrayList<>();
        for (char[] chars : chess) {
            list.add(new String(chars));
        }
        return list;
    }
}
