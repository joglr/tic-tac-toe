import java.util.UUID;

class Board {

  public static final String EMPTY = " ";
  public static final String TIE = UUID.randomUUID().toString();
  public static final String X = "X";
  public static final String O = "O";
  public static String[][] emptyBoard = { { EMPTY, EMPTY, EMPTY }, { EMPTY, EMPTY, EMPTY }, { EMPTY, EMPTY, EMPTY } };
  private static String[][] winBoard = { { X, EMPTY, EMPTY }, { EMPTY, X, EMPTY }, { EMPTY, EMPTY, X } };
  private static String[] players = { X, O };

  public int size;
  protected String[][] board;
  private int currentPlayer;

  public Board() {
    board = emptyBoard;
  }

  public Board(String[][] customBoard) {
    reset();
    board = customBoard;
  }

  public String[] getPlayers() {
    return players;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int newSize) {
    size = newSize;
  }

  public void reset() {

    size = 3;
    currentPlayer = 0;
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

  public void print() {
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
