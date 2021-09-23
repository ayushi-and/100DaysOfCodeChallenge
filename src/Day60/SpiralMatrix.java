package Day60;

import java.util.ArrayList;
import java.util.List;

/*---Spiral Matrix
Given an m x n matrix, return all elements of the matrix in spiral order.
Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
 */
public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        if (matrix.length == 0) {
            return ans;
        }

        int startRow = 0;
        int endRow = matrix.length - 1;
        int startColumn = 0;
        int endColumn = matrix[0].length - 1;

        while(startRow <= endRow && startColumn <= endColumn) {
            // Move towards right
            for(int j = startColumn; j <= endColumn; j++) {
                ans.add(matrix[startRow][j]);
            }
            startRow++;

            // Move towards down
            for(int i = startRow; i <= endRow; i++) {
                ans.add(matrix[i][endColumn]);
            }
            endColumn--;

            if(startRow <= endRow) {
                // Move towards left
                for (int j = endColumn; j >= startColumn; j --) {
                    ans.add(matrix[endRow][j]);
                }
                endRow--;
            }

            if (startColumn <= endColumn) {
                // Move towards top
                for (int i = endRow; i >= startRow; i --) {
                    ans.add(matrix[i][startColumn]);
                }
            }
            startColumn++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] matrixArray1 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        int[][] matrixArray2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        System.out.println(spiralOrder(matrixArray1));
        System.out.println(spiralOrder(matrixArray2));
    }
}

