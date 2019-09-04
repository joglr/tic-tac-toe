import java.util.Scanner;

class TicTacToe {

  private static String empty = " ";
  private static String[][] emptyBoard = { { empty, empty, empty }, { empty, empty, empty }, { empty, empty, empty } };
  private static String[][] winBoard = { { "X", empty, empty }, { empty, "X", empty }, { empty, empty, "X" } };
  private static String[] players = { "X", "O" };

  private String[][] board;
  private int currentPlayer = 0;

  public TicTacToe() {
    clearBoard();
    printWelcome();
    outputBoard();
  }

  private void printWelcome() {
    System.out.println("Hello! Welcome to Tic Tac Toe");
    System.out.println("=============================");
    System.out.println("Take turns to input a cell number (1-9)");
    System.out.println("");
    System.out.println("1|2|3");
    System.out.println("4|5|6");
    System.out.println("7|8|9");
    System.out.println("");
  }

  private void clearBoard() {
    board = emptyBoard;
  }

  private void outputBoard() {
    System.out.println("Board:");
    System.out.println("");
    for (int i = 0; i < board.length; i++) {
      String lineOutput = "";
      String[] row = board[i];
      for (int ii = 0; ii < row.length; ii++) {
        lineOutput = String.join(" | ", row);
      }
      System.out.println(lineOutput);
      if (i != board.length - 1) {
        System.out.println("---------");
      }
    }
    System.out.println("");
  }

  private void makeMove() {
    System.out.println("It is " + players[(currentPlayer)] + "'s turn. Type a number from 1-9");
    Scanner s = new Scanner(System.in);
    int move = s.nextInt() - 1;
    s.nextLine();
    int x = move % 3;
    int y = move / 3;

    if (board[y][x] != empty) {
      System.out.println("Invalid move. Pick another");
      makeMove();
      return;
    }
    board[y][x] = players[currentPlayer];
    currentPlayer = (currentPlayer + 1) % 2;
    outputBoard();
  }

}
