package TicTacToe;

//Player = 1
//Player = 2

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    static int playerScore =0;
    static int computerScore = 0;
   static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            char [][] gameBoard = { { '_','|','_','|','_'},
                    {'_','|','_','|','_'},
                    {' ','|',' ','|', ' '}};
            printBoard(gameBoard);
            boolean gameOver = false;
            boolean playAgain = true;

            while(playAgain) {
                while (!gameOver) {
                    playerMove(gameBoard);
                    gameOver = isGameOver(gameBoard);
                    if (gameOver) {
                        break;
                    }

                    computerMove(gameBoard);
                    gameOver = isGameOver(gameBoard);
                    if (gameOver) {
                        break;
                    }
                }
            }
            System.out.println("Player Score: " + playerScore);
            System.out.println("Computer Score: " + computerScore);
            System.out.println("Would you like to play again? Yes/No");
            scanner.nextLine();
            String result = scanner.nextLine();

            switch (result){
                case "Yes":
                case"yes":
                    playAgain = true;
                    System.out.println("Let's play again");
                    resetTheBoard(gameBoard);
                    gameOver = false;
                    printBoard(gameBoard);
                    break;

                case "No":
                case"no":
                    playAgain =false;
                    System.out.println("Thanks for playing");
                    break;
                default:
                    break;

            }
    }

        public static void printBoard(char [][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.println(c);
            }
            System.out.println();
        }
    }

        public static void updateBoard(int position,int player,char[][] gameBoard){
            char symbol;

            if(player == 1){
                symbol = 'X';
            }else{
                symbol = 'O';
            }
            switch(position){
                case 1:
                    gameBoard[0][0] = symbol;
                    printBoard(gameBoard);
                    break;
                case 2:
                    gameBoard[0][2] = symbol;
                    printBoard(gameBoard);
                    break;
                case 3:
                    gameBoard[0][4] = symbol;
                    printBoard(gameBoard);
                    break;
                case 4:
                    gameBoard[1][0] = symbol;
                    printBoard(gameBoard);
                    break;
                case 5:
                    gameBoard[1][2] = symbol;
                    printBoard(gameBoard);
                    break;
                case 6:
                    gameBoard[1][4] = symbol;
                    printBoard(gameBoard);
                    break;
                case 7:
                    gameBoard[2][0] = symbol;
                    printBoard(gameBoard);
                    break;
                case 8:
                    gameBoard[2][2] = symbol;
                    printBoard(gameBoard);
                    break;
                case 9:
                    gameBoard[2][4] = symbol;
                    printBoard(gameBoard);
                    break;
                default:
                    break;
            }
        }

        public static void playerMove(char[][] gameBoard){
            System.out.println("Please make a move");
            int move = scanner.nextInt();
            boolean result = isValidMove(move, gameBoard);
            while(!result){
                System.out.println("Invalid move. Please try again");
                move = scanner.nextInt();
                result = isValidMove(move, gameBoard);
            }
            System.out.println("Player move to position: " + move );
            updateBoard(move,1,gameBoard);
        }

        public static boolean isValidMove(int move, char[][] gameBoard){

            switch(move){
                case 1:
                    if(gameBoard[0][0] == '_'){
                        return true;
                    }else {
                        return false;
                    }
                case 2:
                    if(gameBoard[0][2] == '_'){
                        return true;
                    }else {
                        return false;
                    }
                case 3:
                    if(gameBoard[0][4] == '_'){
                        return true;
                    }else {
                        return false;
                    }
                case 4:
                    if(gameBoard[1][0] == '_'){
                        return true;
                    }else {
                        return false;
                    }
                case 5:
                    if(gameBoard[1][2] == '_'){
                        return true;
                    }else {
                        return false;
                    }
                case 6:
                    if(gameBoard[1][4] == '_'){
                        return true;
                    }else {
                        return false;
                    }
                case 7:
                    if(gameBoard[2][0] == '_'){
                        return true;
                    }else {
                        return false;
                    }
                case 8:
                    if(gameBoard[2][2] == '_'){
                        return true;
                    }else {
                        return false;
                    }
                case 9:
                    if(gameBoard[2][4] == '_'){
                        return true;
                    }else {
                        return false;
                    }
                default:
                    return false;
            }
        }

        public static void computerMove(char [][] gameBoard){
            Random rand = new Random();
            int move = rand.nextInt(9)+1;
            boolean result = isValidMove(move, gameBoard);
            while(!result){
                move = rand.nextInt(9)+1;
                result = isValidMove(move, gameBoard);
            }
            System.out.println("Computer moved at position: " + move);
            updateBoard(move, 2, gameBoard);
        }

        public static boolean isGameOver(char[][] gameBoard){
            //Horizontal wins
            if(gameBoard[0][0] == 'X' && gameBoard[0][2] == 'X' && gameBoard[0][4] == 'X'){
                System.out.println("Player Wins");
                playerScore++;
                return true;
            }
            if(gameBoard[0][0] == 'O' && gameBoard[0][2] == 'O' && gameBoard[0][4] == 'O'){
                System.out.println("Computer Wins");
                computerScore++;
                return true;
            }
            if(gameBoard[1][0] == 'X' && gameBoard[1][2] == 'X' && gameBoard[1][4] == 'X'){
                System.out.println("Player Wins");
                playerScore++;
                return true;
            }
            if(gameBoard[1][0] == 'O' && gameBoard[1][2] == 'O' && gameBoard[1][4] == 'O'){
                System.out.println("Computer Wins");
                computerScore++;
                return true;
            }
            if(gameBoard[2][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[2][4] == 'X'){
                System.out.println("Player Wins");
                playerScore++;
                return true;
            }
            if(gameBoard[2][0] == 'O' && gameBoard[2][2] == 'O' && gameBoard[2][4] == 'O'){
                System.out.println("Computer Wins");
                computerScore++;
                return true;
            }

            //Vertical wins
            if(gameBoard[0][0] == 'X' && gameBoard[1][0] == 'X' && gameBoard[2][0] == 'X'){
                System.out.println("Player Wins");
                playerScore++;
                return true;
            }
            if(gameBoard[0][2] == 'X' && gameBoard[1][2] == 'X' && gameBoard[2][2] == 'X'){
                System.out.println("Player Wins");
                playerScore++;
                return true;
            }
            if(gameBoard[04][0] == 'X' && gameBoard[1][4] == 'X' && gameBoard[2][4] == 'X'){
                System.out.println("Player Wins");
                playerScore++;
                return true;
            }
            if(gameBoard[0][0] == 'O' && gameBoard[1][0] == 'O' && gameBoard[2][0] == 'O'){
                System.out.println("Computer Wins");
                computerScore++;
                return true;
            }
            if(gameBoard[0][2] == 'O' && gameBoard[1][2] == 'O' && gameBoard[2][2] == 'O'){
                System.out.println("Computer Wins");
                computerScore++;
                return true;
            }
            if(gameBoard[0][4] == 'O' && gameBoard[1][4] == 'O' && gameBoard[2][4] == 'O'){
                System.out.println("Computer Wins");
                computerScore++;
                return true;
            }
            //Diagonal wins
            if(gameBoard[0][0] == 'X' && gameBoard[1][2] == 'X' && gameBoard[2][4] == 'X'){
                System.out.println("Player Wins");
                playerScore++;
                return true;}
            if(gameBoard[2][0] == 'X' && gameBoard[1][2] == 'X' && gameBoard[0][4] == 'X') {
                System.out.println("Player Wins");
                playerScore++;
                return true;
            }
            if(gameBoard[0][0] == 'O' && gameBoard[1][2] == 'O' && gameBoard[2][4] == 'O'){
                System.out.println("Computer Wins");
                computerScore++;
                return true;
            }
            if(gameBoard[2][0] == 'O' && gameBoard[1][2] == 'O' && gameBoard[0][4] == 'O'){
                System.out.println("Computer Wins");
                computerScore++;
                return true;
            }
            if(gameBoard[0][0] != '_' && gameBoard[0][2] != '_' && gameBoard[0][4] != '_' &&
                gameBoard[1][0] != '_' && gameBoard[1][2] != '_' && gameBoard[1][4] != '_' &&
                gameBoard[2][0] != '_' && gameBoard[2][2] != '_' && gameBoard[2][4] != '_'){
                System.out.println("It is a tie");
                return true;
            }
            return false;
        }
        public static void resetTheBoard(char [][] gameBoard){
            gameBoard[0][0] = '_';
            gameBoard[0][2] = '_';
            gameBoard[0][4] = '_';
            gameBoard[1][0] = '_';
            gameBoard[1][2] = '_';
            gameBoard[1][4] = '_';
            gameBoard[2][0] = '_';
            gameBoard[2][2] = '_';
            gameBoard[2][4] = '_';

        }

}
