import java.util.Scanner;

public class HumanPlayer{
  private String player_name;

  public HumanPlayer(){
  }

  public HumanPlayer(String player){
    player =  player_name;
  }

  public String playerName(){
    return player_name;
  }

  Scanner reader = new Scanner(System.in);
  public void getMove(GameConfig gameConfig){

    //takes the player who gets to pick the colour
    String aPlayer = gameConfig.initialPlayer();

    //asks the player to choose a colour
    System.out.println("Choose a colour (Enter b for black or w for white ): ");
    String colour = reader.nextLine();

    //takes a player's move and checks if it is valid for black pieces.
      if(colour == "b"){

        // asks the player to choose a piece to move
        System.out.println("Choose a piece to move: ");
        String piece = reader.nextLine();

        // asks the player for the current position of the piece to be moved
        System.out.println("current row of the piece: ");
        int a = reader.nextInt();
        System.out.println("current column of the piece: ");
        int b = reader.nextInt();

        // checks if the entered piece is valid
        if (piece == "bPawn" || piece == "bKnight"){

            //asks the player where to move the piece
            System.out.println("Where to move? (Enter a row number from 0 to 4): ");
            int x = reader.nextInt();
            System.out.println("Where to move? (Enter a column number from 0 to 4): ");
            int y = reader.nextInt();

            // checks if the chosen tile is empty
            String[][] aBoard = gameConfig.getBoard();
              if (aBoard[x][y] == "blank"){

                // updates the board if the move is valid.
                gameConfig.changeBoard (piece, x, y);
              }
              else{
                System.out.println("Move is invalid");
              }
          }
          else {
            System.out.println("Piece is invalid");
          }
      }

      //takes a player's move and checks if it is valid for black pieces.
      else if(colour == "w"){

        // asks the player to choose a piece to move
        System.out.println("Choose a piece to move: ");
        String piece = reader.nextLine();

        // asks the player for the current position of the piece to be moved
        System.out.println("current row of the piece: ");
        int a = reader.nextInt();
        System.out.println("current column of the piece: ");
        int b = reader.nextInt();

          // checks if the entered piece is valid
        if (piece == "wPawn" || piece == "wKnight"){

            //asks the player where to move the piece
            System.out.println("Where to move? (Enter a row number from 0 to 4): ");
            int x = reader.nextInt();
            System.out.println("Where to move? (Enter a column number from 0 to 4): ");
            int y = reader.nextInt();

              // checks if the chosen tile is empty
            String[][] aBoard = gameConfig.getBoard();
              if (aBoard[x][y] == "blank"){

                // updates the board if the move is valid.
                gameConfig.changeBoard (piece, x, y);
              }
              else{
                System.out.println("Move is invalid");
              }
          }
          else {
            System.out.println("Piece is invalid");
          }
      }


  }

  public static void main(String[] args) {




  }


}
