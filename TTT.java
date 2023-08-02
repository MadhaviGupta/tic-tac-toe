import java.util.Scanner;
public class TTT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Here are the rules for the game- ");
        System.out.println("You have to enter the co-ordinates for the position you want to put your symbol on. It starts with 0.");
        System.out.println("For example - ");
        System.out.println("  0   1   2");
        for(int i=0; i<3; i++) {
            System.out.println(i + "   |   |   |");
        }
        System.out.println("_____________________________________________________________________________________________________");
        char [][] board = new char[3][3];
        for(int row=0; row< board.length; row++) {
            for(int col=0; col< board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
        char player = 'X';
        int step = 1;
        boolean gameOver = false;
        while(!gameOver) {
            if(step < 10) {
                printBoard(board);
                System.out.print("Player " + player + " enter: ");
                int row = sc.nextInt();
                int col = sc.nextInt();
                if (board[row][col] == ' ') {
                    board[row][col] = player;
                    gameOver = haveWon(board, player);
                    if (gameOver) {
                        System.out.println("Player " + player + " has won the game!");
                        break;
                    } else {
                        player = player == 'X' ? 'O' : 'X';
                    }
                } else {
                    System.out.println("Invalid Move!");
                }
            }
            else {
                System.out.println("It's a draw!");
                break;
            }
            step++;
        }
        printBoard(board);
    }
    public static void printBoard(char[][] board) {
        for (int row=0; row < board.length; row++) {
            for(int col=0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
    public static boolean haveWon(char[][] board, char player) {
        // for rows
        for (int row=0; row < board.length; row++) {
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }
        // for cols
        for (int col=0; col < board[0].length; col++) {
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
        // for diagonals
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }
}
