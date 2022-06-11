package game;

public class getEmotes {
    private static String white = ":white_large_square:";

    public static String get(board board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard()[i].length; j++) {
                if (board.getBoard()[i][j] == 0) {
                    sb.append(white);
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
