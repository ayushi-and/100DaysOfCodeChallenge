package Day15;

public class TicTacToeMainClass {
    /**
     * Your TicTacToeLeetCode object will be instantiated and called as such:
     * TicTacToeLeetCode obj = new TicTacToeLeetCode(n);
     * int param_1 = obj.move(row,col,player);
     */

    public static void main(String[] args) {
        TicTacToeLeetCode toe = new TicTacToeLeetCode(3);

        System.out.println(toe.move(0, 0, 1));
        System.out.println(toe.move(0, 2, 2));
        System.out.println(toe.move(2, 2, 1));
        System.out.println(toe.move(1, 1, 2));
        System.out.println(toe.move(2, 0, 1));
        System.out.println(toe.move(1, 0, 2));
        System.out.println(toe.move(2, 1, 1));
    }
}
