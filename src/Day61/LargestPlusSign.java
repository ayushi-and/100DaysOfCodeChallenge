package Day61;

import java.util.Arrays;

/* ----Largest Plus Sign
You are given an integer n. You have an n x n binary grid grid with all values initially 1's except for some indices given in the array mines.
The ith element of the array mines is defined as mines[i] = [xi, yi] where grid[xi][yi] == 0.
Return the order of the largest axis-aligned plus sign of 1's contained in grid. If there is none, return 0.
An axis-aligned plus sign of 1's of order k has some center grid[r][c] == 1 along with four arms of length k - 1 going up, down, left, and right,
and made of 1's. Note that there could be 0's or 1's beyond the arms of the plus sign, only the relevant area of the plus sign is checked for 1's.

Example 1:
Input: n = 5, mines = [[4,2]]
Output: 2
Explanation: In the above grid, the largest plus sign can only be of order 2. One of them is shown.

Example 2:
Input: n = 1, mines = [[0,0]]
Output: 0
Explanation: There is no plus sign, so return 0.

Constraints:
1 <= n <= 500
1 <= mines.length <= 5000
0 <= xi, yi < n
All the pairs (xi, yi) are unique.
https://www.youtube.com/watch?v=mu9r9HHJs9I
 */
//Brute Force - O(n^3)
public class LargestPlusSign {
    public static int orderOfLargestPlusSign(int n, int[][] mines) {
        int ans = 0;
        int[][] inputGrid = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(inputGrid[i], 1);
        }
        for(int[] mine : mines) {
            inputGrid[mine[0]][mine[1]] = 0;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int topCount = 0;
                int downCount = 0;
                int leftCount = 0;
                int rightCount = 0;

                //top count
                for(int k = i; k >= 0; k--) {
                    if(inputGrid[k][j] == 1) {
                        topCount++;
                    }
                    else break;
                }

                //down count
                for(int k = i; k < n; k++) {
                    if(inputGrid[k][j] == 1) {
                        downCount++;
                    }
                    else break;
                }

                //left count
                for(int k = j; k >= 0; k--) {
                    if(inputGrid[i][k] == 1) {
                        leftCount++;
                    }
                    else break;
                }

                //right count
                for(int k = j; k < n; k++) {
                    if(inputGrid[i][k] == 1) {
                        rightCount++;
                    }
                    else break;
                }

                int res1 = Math.min(topCount, downCount);
                int res2 = Math.min(leftCount, rightCount);

                int res = Math.min(res1, res2);

                ans = Math.max(ans, res);

            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] mines = {{4, 2}};
        System.out.println(orderOfLargestPlusSign(n, mines));
    }
}
