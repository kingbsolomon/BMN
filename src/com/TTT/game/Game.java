package com.TTT.game;

public class Game {

    public static char[][] gameArray2D = new char[3][3];

    //method to determine a winner

    public static String determineWinner() {
        for (int i = 0; i < 3; i++) {
            if (gameArray2D[i][0] == gameArray2D[i][1] && gameArray2D[i][1] == gameArray2D[i][2] && gameArray2D[i][0] != '\u0000') {
                return (gameArray2D[i][0] + " is the winner");
            }

            if (gameArray2D[0][i] == gameArray2D[1][i] && gameArray2D[1][i] == gameArray2D[2][i] && gameArray2D[0][i] != '\u0000') {
                return (gameArray2D[0][i] + " is the winner");
            }
        }

        if (gameArray2D[0][0] == gameArray2D[1][1] && gameArray2D[1][1] == gameArray2D[2][2] && gameArray2D[1][1] != '\u0000') {
            return (gameArray2D[2][2] + " is the winner");
        }

        if (gameArray2D[0][2] == gameArray2D[1][1] && gameArray2D[1][1] == gameArray2D[2][0] && gameArray2D[1][1] != '\u0000') {
            return (gameArray2D[1][1] + " is the winner");
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameArray2D[i][j] == '\u0000') {
                    return null;
                }
            }
        }
        return "Oh, no! It's a tie...";
    }

    public static void runGame() {
        gameArray2D = new char [3][3];
        new TTTGame(1);
    }
}