package Day15;

//Design a Tic-tac-toe game that is played between two players on a n x n grid.
//You may assume the following rules:
//1 A move is guaranteed to be valid and is placed on an empty block.
//2 Once a winning condition is reached, no more moves is allowed.
//3 A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.

/*Example:
        Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.

        TicTacToe toe = new TicTacToe(3);

        toe.move(0, 0, 1); -> Returns 0 (no one wins)
        |X| | |
        | | | |    // Player 1 makes a move at (0, 0).
        | | | |

        toe.move(0, 2, 2); -> Returns 0 (no one wins)
        |X| |O|
        | | | |    // Player 2 makes a move at (0, 2).
        | | | |

        toe.move(2, 2, 1); -> Returns 0 (no one wins)
        |X| |O|
        | | | |    // Player 1 makes a move at (2, 2).
        | | |X|

        toe.move(1, 1, 2); -> Returns 0 (no one wins)
        |X| |O|
        | |O| |    // Player 2 makes a move at (1, 1).
        | | |X|

        toe.move(2, 0, 1); -> Returns 0 (no one wins)
        |X| |O|
        | |O| |    // Player 1 makes a move at (2, 0).
        |X| |X|

        toe.move(1, 0, 2); -> Returns 0 (no one wins)
        |X| |O|
        |O|O| |    // Player 2 makes a move at (1, 0).
        |X| |X|

        toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
        |X| |O|
        |O|O| |    // Player 1 makes a move at (2, 1).
        |X|X|X|

 */
//Follow up:Could you do better than O(n2) per move() operation?
//Hint:
//Could you trade extra space such that move() operation can be done in O(1)?
//You need two arrays: int rows[n], int cols[n], plus two variables: diagonal, anti_diagonal.
//Solution: Use addtional arrays rows[n], cols[n] and two varialbes diagonal, anti_diagonal to mark the number of Xs and Os.

public class TicTacToeLeetCode {

    private static int[] rows;
    private static int[] cols;
    private static int diagonal;
    private static int antiDiagonal;

    /** Initialize your data structure here. */
    public TicTacToeLeetCode(int n){
        rows = new int[n];
        cols = new int[n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public static int move(int row, int col, int player) {
        if(row >= rows.length || col >= cols.length){
            throw new IllegalArgumentException("Invalid move!");
        }
        int currentPlayer = player == 1 ? 1 : -1;
        rows[row] += currentPlayer;
        cols[col] += currentPlayer;

        if(row == col) {
            diagonal += currentPlayer;
        }
        if(row == rows.length - col - 1) {
            antiDiagonal += currentPlayer;
        }

        int size = rows.length;

        if(Math.abs(rows[row]) == size
            || Math.abs(cols[col]) == size
            || Math.abs(diagonal) == size
            || Math.abs(antiDiagonal) == size) {
            return player;
        }
        return 0;
    }

}
