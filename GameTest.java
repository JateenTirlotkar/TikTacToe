package com.test;

import java.util.Scanner;

import com.model.GameFacade;
import com.model.Player;

public class GameTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player1 = new Player("Player 1", 'X');
        Player player2 = new Player("Player 2", 'O');
        GameFacade game = new GameFacade(player1, player2);

        game.startGame();
        while (true) {
            System.out.println(game.getCurrentPlayer().getName() + "'s turn. Enter row and column:");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (game.makeMove(row, col)) {
                if (game.checkWinner() != null) {
                    System.out.println(game.checkWinner().getName() + " wins!");
                    break;
                } else if (game.getBoard().isFull()) {
                    System.out.println("It's a draw!");
                    break;
                }
                game.switchPlayer();
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
        scanner.close();
    }
}

