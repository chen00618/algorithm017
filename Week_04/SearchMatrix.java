package week04;

/**
 * @program: test
 * @description: 搜索二维矩阵
 * @author: ChenWeiJun
 * @create: 2020-10-25 21:12
 **/
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;

        int left = 0, right = matrix[0].length - 1;

        while (left < matrix.length && right >= 0) {
            if (matrix[left][right] == target) {
                return true;
            } else if (matrix[left][right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}
