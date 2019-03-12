public class GameOO{
  

  public GameOO(){

  }


  public static void main(String[] args){
    int counter = 0;
    GameConfig gameBoard = new GameConfig();
    System.out.print("This is a 5x5 chess board. Rows go from 0-4 and columns go from 0-4. Player 1 controls the White pieces and Player 2 controls the Black pieces. The pieces are White Knight(wK), White Pawn(wP), Black Knight(bK), Black Pawn(bP).\n");
    gameBoard.printBoard();
    Human player1 = new Human();
    Human player2 = new Human();

    while( gameBoard.gameWon() != true){
      // keeping track of turn
      counter++;
      System.out.println("Turn " + counter);

      // getting input from player 1 (white) using methods from human player class
      // add in exception if spot is occupied by another one of your pieces.
      String whitePiece = player1.playerWhite();
      int cRow1 = player1.currentWhiteRow();
      int cCol1 = player1.currentWhiteColumn();
      while( !gameBoard.inputMatchesBoard(whitePiece, cRow1, cCol1)){
        System.out.println("That spot on the board does not have that piece. Pick a location where your piece exists: ");
        cRow1 = player1.currentWhiteRow();
        cCol1 = player1.currentWhiteColumn();
      }
      int nRow1 = player1.newWhiteRow();
      int nCol1 = player1.newWhiteColumn();

      // getting input from player 2 (black) using methods from human player class
      String blackPiece = player2.playerBlack();
      int cRow2 = player2.currentBlackRow();
      int cCol2 = player2.currentBlackColumn();
      while( !gameBoard.inputMatchesBoard(blackPiece, cRow2, cCol2)){
        System.out.println("That spot on the board does not have that piece. Pick a location where your piece exists: ");
        cRow2 = player2.currentBlackRow();
        cCol2 = player2.currentBlackColumn();
      }
      int nRow2 = player2.newBlackRow();
      int nCol2 = player2.newBlackColumn();

      // calls method from GameConfig class to move pieces
      gameBoard.secretMove(whitePiece, blackPiece, cRow1, cCol1, nRow1,
                         nCol1, cRow2, cCol2, nRow2, nCol2);
      // reprints updated board
      gameBoard.printBoard();

    }
  }

}
