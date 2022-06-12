package game;

public class SnakeManager {
    private static int headx;
    private static int heady;
    public SnakeManager(GameBoard board){
        //spawn snake
        headx = (int)(Math.random()*9);
        heady = (int)(Math.random()*9);
        board.updateBoard(headx, heady, 1);
    }
    public void moveSnake(GameBoard board){
        
    }
    public void increaseSnake(GameBoard board){
        
    }
}
