package week06;

/**
 * @program: test
 * @description: 编辑距离
 * @author: ChenWeiJun
 * @create: 2020-11-08 19:25
 **/
public class MinDistance {

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n+1][m+1];
        for (int i=0;i<dp.length;i++) dp[i][0] = i;

        for (int j=0;j<dp[0].length;j++) dp[0][j] = j;

        for (int i=1;i<dp.length;i++) {
            for (int j=1;j<dp[i].length;j++) {
                int left = dp[i][j-1] + 1;
                int up = dp[i-1][j] + 1;
                int left_up = dp[i-1][j-1];
                if (word1.charAt(i-1) != word2.charAt(j-1))
                    left_up++;
                dp[i][j] = Math.min(left,Math.min(up,left_up));
            }
        }
        return dp[n][m];
    }
}
