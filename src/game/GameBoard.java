package game;

public class GameBoard {
    private int[][] board;
   public GameBoard(int y , int x) {
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
   public void updateBoard(int x, int y, int value) {
       board[x][y] = value;
   }
}
