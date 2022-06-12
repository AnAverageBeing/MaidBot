package game;

import java.util.ArrayList;

public class GameHandler {

    private static GameBoard Gboard;
    private static SnakeManager snake;

    private ArrayList<String> foodLoctions = new ArrayList<String>();

    public GameHandler(int y, int x, int noffood) {
        Gboard = new GameBoard(y, x);
        spawnFood(noffood);
        snake = new SnakeManager(Gboard);
    }

    public void spawnFood(int numberofFood){
        for(int i = 0; i < numberofFood; i++){
            int x = (int)(Math.random()*9);
            int y = (int)(Math.random()*9);
            while(foodLoctions.contains(x+","+y)){
                x = (int)(Math.random()*9);
                y = (int)(Math.random()*9);  
            }
            foodLoctions.add(x+","+y);
        }
        //add food to the board
        for(int i = 0; i < foodLoctions.size(); i++){
            String[] food = foodLoctions.get(i).split(",");
            Gboard.updateBoard(Integer.parseInt(food[0]),Integer.parseInt(food[1]),2);
        }
    }

    public static String getEmotes() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Gboard.getBoard().length; i++) {
            for (int j = 0; j < Gboard.getBoard()[i].length; j++) {
                if (Gboard.getBoard()[i][j] == 0) {
                    sb.append(":black_large_square:");
                } 
                else if (Gboard.getBoard()[i][j] == 1) {
                    sb.append(":flushed:");
                }
                else if (Gboard.getBoard()[i][j] == 2) {
                    sb.append(":apple:");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
