package game;

public class board {
    private int[][] board;
   public board(int y , int x) {
       board = new int[x][y];
       for (int i = 0; i < x; i++) {
           for (int j = 0; j < y; j++) {
               board[i][j] = 0;
           }
       }
   }

   public int[][] getBoard() {
       return board;
   }
}
