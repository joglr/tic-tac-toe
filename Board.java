import java.util.UUID;

class Board {
  public int size = 3;
  protected static String EMPTY = " ";
  public static String TIE = UUID.randomUUID().toString();
  public static String[][] emptyBoard = { { EMPTY, EMPTY, EMPTY }, { EMPTY, EMPTY, EMPTY }, { EMPTY, EMPTY, EMPTY } };

  private static String[][] winBoard = { { "X", EMPTY, EMPTY }, { EMPTY, "X", EMPTY }, { EMPTY, EMPTY, "X" } };
  private static String[] players = { "X", "O" };

  protected String[][] board;
  private int currentPlayer = 0;

  public Board(String[][] customBoard) {
    if (customBoard == null) {
      board = emptyBoard;
    } else {
      board = customBoard;
    }
  }

  public String[] getPlayers() {
    return players;
  }

  public int getSize() {
    return size;
  }

  public void getSize(int newSize) {
    size = newSize;
  }

  public Row getRow(int index) {
    return new Row(board[index]);
  }

  public int getCurrentPlayer() {
    return currentPlayer;
  }

  public void setCurrentPlayer(int newCurrentPlayer) {
    currentPlayer = newCurrentPlayer;
  }

  public String getCurrentPlayerSign() {
    return players[currentPlayer];
  }

  public void outputBoard() {
    System.out.println("Board:");
    System.out.println("");
    for (int i = 0; i < size; i++) {
      String lineOutput = "";
      String[] row = board[i];
      for (int ii = 0; ii < row.length; ii++) {
        lineOutput = String.join(" | ", row);
      }
      System.out.println(lineOutput);
      if (i != size - 1) {
        System.out.println("---------");
      }
    }
    System.out.println("");
  }

  public boolean isFull() {
    boolean isFull = true;
    for (int i = 0; i < size; i++) {
      String[] row = board[i];

      for (int ii = 0; ii < size; ii++) {
        String cell = row[ii];
        if (cell == EMPTY) {
          isFull = false;

          break;
        }
      }
    }
    return isFull;
  }

}

class Row {
  private String[] row = { " ", " ", " " };

  public Row(String[] newRow) {
    row = newRow;
  }

  public String getCell(int index) {
    return row[index];
  }

  public void setCell(int index, String value) {
    row[index] = value;
  }

  public int length() {
    return row.length;
  }
}
