package com.model;

public class GameFacade {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public GameFacade(Player player1, Player player2) {
        this.board = new Board();
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }

    public void startGame() {
        board.printBoard();
    }

    public boolean makeMove(int row, int col) {
        if (board.placeSymbol(row, col, currentPlayer.getSymbol())) {
            board.printBoard();
            return true;
        }
        return false;
    }

    public Player checkWinner() {
        if (board.checkWin(player1.getSymbol())) {
            return player1;
        } else if (board.checkWin(player2.getSymbol())) {
            return player2;
        }
        return null;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {
        return board;
    }
}

