import java.util.ArrayList;
import java.util.Scanner;

public class Human{

	private GameConfig config = new GameConfig();

  //default constructor
  public Human() {
  }

  // type of piece player1 wants to move
  public String playerWhite(){
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Player 1, choose a piece: ");
    String whitePiece = keyboard.next();
    while( config.validInputWhite(whitePiece) != true){
      System.out.println("Invalid input. Enter wK or wP: ");
      whitePiece = keyboard.next();
    }
    return(whitePiece);
  }

// current row of the piece player1 wants to move
  public int currentWhiteRow(){
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Which row is this piece on? ");
    int currentRow1 = keyboard.nextInt();
    while (currentRow1 > 4 || currentRow1 < 0) {
        System.out.print("Invalid answer. Please enter a valid row: ");
        currentRow1 = keyboard.nextInt();
    }
    return(currentRow1);
  }

// current column of the piece player1 wants to move
  public int currentWhiteColumn(){
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Which column is this piece on? ");
    int currentCol1 = keyboard.nextInt();
    while (currentCol1 > 4 || currentCol1 < 0) {
        System.out.print("Invalid answer. Please enter a valid column: ");
        currentCol1 = keyboard.nextInt();
    }
    return(currentCol1);
  }

// the new row that player1 wants to move to
  public int newWhiteRow(){
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Pick a row to move your piece to: ");
    int newRow1 = keyboard.nextInt();
    while (newRow1 > 4 || newRow1 < 0) {
        System.out.print("Invalid answer. Please enter a valid row: ");
        newRow1 = keyboard.nextInt();
    }
    return(newRow1);
  }

// the new column that player1 wants to move to
  public int newWhiteColumn(){
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Pick a column to move your piece to: ");
    int newCol1 = keyboard.nextInt();
    while (newCol1 > 4 || newCol1 < 0) {
        System.out.print("Invalid answer. Please enter a valid column: ");
        newCol1 = keyboard.nextInt();
    }
    return(newCol1);
  }

// type of piece that player2 wants to move
  public String playerBlack(){
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Player 2, choose a piece: ");
    String blackPiece = keyboard.next();
    while( config.validInputBlack(blackPiece) != true){
      System.out.println("Invalid input. Enter bK or bP: ");
      blackPiece = keyboard.next();
    }
    return(blackPiece);
  }

// current row of piece that player2 wants to move
  public int currentBlackRow(){
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Which row is this piece on? ");
    int currentRow2 = keyboard.nextInt();
    while (currentRow2 > 4 || currentRow2 < 0) {
        System.out.print("Invalid answer. Please enter a valid row: ");
        currentRow2 = keyboard.nextInt();
    }
    return(currentRow2);
  }

// current column of piece that player2 wants to move
  public int currentBlackColumn(){
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Which column is this piece on? ");
    int currentCol2 = keyboard.nextInt();
    while (currentCol2 > 4 || currentCol2 < 0) {
        System.out.print("Invalid answer. Please enter a valid column: ");
        currentCol2 = keyboard.nextInt();
    }
    return(currentCol2);
  }

// row that player2 wants to move to
  public int newBlackRow(){
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Pick a row to move your piece to: ");
    int newRow2 = keyboard.nextInt();
    while (newRow2 > 4 || newRow2 < 0) {
        System.out.print("Invalid answer. Please enter a valid row: ");
        newRow2 = keyboard.nextInt();
    }
    return(newRow2);
  }

// column that player2 wants to move to
  public int newBlackColumn(){
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Pick a column to move your piece to: ");
    int newCol2 = keyboard.nextInt();
    while (newCol2 > 4 || newCol2 < 0) {
        System.out.print("Invalid answer. Please enter a valid column: ");
        newCol2 = keyboard.nextInt();
    }
    return(newCol2);
  }

}
