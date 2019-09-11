import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

class TicTacToe {
  private Board board;

  public TicTacToe() {
    printWelcome();
    board.outputBoard();
    String winner = board.EMPTY;

    while (!Arrays.stream(board.getPlayers()).anyMatch(winner::equals) || winner == board.TIE) {
      winner = checkWins();
      makeMove();
    }
    if (winner != " ") {
      if (winner != board.TIE) {
        System.out.println(winner + " wins!");
      } else {
        System.out.println("It's a tie!");
      }
    }
  }

  private void printWelcome() {
    System.out.println("Hello! Welcome to Tic Tac Toe");
    System.out.println("=============================");
    System.out.println("Take turns to input a cell number (1-9)");
    System.out.println("");

    String[][] exampleBoardValues = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "9" } };
    Board exampleBoard = new Board(exampleBoardValues);
    exampleBoard.outputBoard();

  }

  public String checkWins() {
    // TODO: Add support for bigger boards
    String winner = " ";
    // Horizontal
    for (int i = 0; i < board.getSize(); i++) {
      Row row = board.getRow(i);
      if (row.getCell(0) == row.getCell(1) && row.getCell(1) == row.getCell(2) && row.getCell(2) == row.getCell(1)) {
        // We maybe have a winner
        if (row.getCell(0) != board.EMPTY) {
          winner = row.getCell(0);
        }
      }
    }
    // Vertical
    for (int i = 0; i < board.getRow(0).length(); i++) {
      if (board.getRow(0).getCell(i) == board.getRow(1).getCell(i)
          && board.getRow(1).getCell(i) == board.getRow(2).getCell(i)
          && board.getRow(2).getCell(i) == board.getRow(1).getCell(i)) {
        // We maybe have a winner
        if (board.getRow(0).getCell(i) != board.EMPTY) {
          winner = board.getRow(0).getCell(i);
        }
      }
    }

    // Across
    if (board.getRow(0).getCell(0) == board.getRow(1).getCell(1)
        && board.getRow(1).getCell(1) == board.getRow(2).getCell(2)
        && board.getRow(2).getCell(2) == board.getRow(0).getCell(0)) {
      // We maybe have a winner
      if (board.getRow(0).getCell(0) != board.EMPTY) {
        winner = board.getRow(0).getCell(0);
      }
    }

    if (board.getRow(0).getCell(2) == board.getRow(1).getCell(1)
        && board.getRow(1).getCell(1) == board.getRow(2).getCell(0)
        && board.getRow(2).getCell(0) == board.getRow(0).getCell(2)) {
      // We maybe have a winner
      if (board.getRow(0).getCell(0) != board.EMPTY) {
        winner = board.getRow(0).getCell(0);
      }
    }
    if (board.isFull()) {
      winner = board.TIE;
    }
    return winner;
  }

  private void makeMove() {
    System.out.println("It is " + board.getCurrentPlayerSign() + "'s turn. Type a number from 1-9");
    Scanner s = new Scanner(System.in);
    int move = -1;

    try {
      move = s.nextInt() - 1;
      s.nextLine();
      int x = move % 3;
      int y = move / 3;

      if (board.getRow(y).getCell(x) != board.EMPTY) {
        System.out.println("Invalid move.");
        System.out.println("");
        makeMove();
        return;
      }
      board.getRow(y).setCell(x, board.getCurrentPlayerSign());
      board.setCurrentPlayer((board.getCurrentPlayer() + 1) % 2);
      board.outputBoard();
    } catch (InputMismatchException e) {
      System.out.println("Invalid move.");
    } finally {
      s.close();
    }
  }

}
