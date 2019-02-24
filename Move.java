public class Move{

  // creates the grid
  // this was so I could test my move methods... 
  public char[][] grid = {{'K','P', 'P', 'P', 'K' },
  {'P','.', '.', '.', 'P' },
  {'.','.', '.', '.', '.' },
  {'p','.', '.', '.', 'p' },
  {'k','p', 'p', 'p', 'k' }};

  // Tests to see if there are no pawns left - game is over when all pawns are gone
  public boolean noPawns(){
    boolean nopawns = true;
    for(int row = 0; row < 5; row++){
      for(int col = 0; col < 5; col++){
        if( grid[row][col] == 'P' || grid[row][col] == 'p'){
          nopawns = false;
        }
      }
    }
    return(nopawns);
  }

  // prints out the game board
  public void print(){
    for(int row = 0; row < 5; row++){
      for(int col = 0; col < 5; col++){
        System.out.print(grid[row][col]);
      }
      System.out.println();
    }
  }

// checks if a space is empty
public boolean emptySpace(int row, int col){
  return grid[row][col] == '.';
}

// places a piece is a new spot
public void writeChar(char piece, int row, int col){
  grid[row][col] = piece;
}

// moves a piece and updates original spot to be empty
public void moveChar(char piece, int currentRow, int currentCol, int newRow, int newCol){
  writeChar('.', currentRow, currentCol);
  writeChar(piece, newRow, newCol);
}


// checks if spot is valid for knight to move to
public void validSpotKnight(char piece, int currentRow, int currentCol, int newRow, int newCol){
  if( piece == 'K' ){
    if( grid[newRow][newCol] != piece && grid[newRow][newCol] != 'P'){
      moveChar(piece, currentRow, currentCol, newRow, newCol);
    }
  }
  else if( piece == 'k'){
    if( grid[newRow][newCol] != piece && grid[newRow][newCol] != 'p'){
      moveChar(piece, currentRow, currentCol, newRow, newCol);
    }
  }
}

// method for moving knights
public void moveKnight(char piece, int currentRow, int currentCol, int newRow, int newCol){
    if( (newRow == currentRow + 1 && newCol == currentCol + 2) ||
      ( newRow == currentRow + 1 && newCol == currentCol - 2) ||
      ( newRow == currentRow - 1 && newCol == currentCol + 2) ||
      ( newRow == currentRow - 1 && newCol == currentCol - 2) ||
      ( newRow == currentRow + 2 && newCol == currentCol + 1) ||
      ( newRow == currentRow + 2 && newCol == currentCol - 1) ||
      ( newRow == currentRow - 2 && newCol == currentCol + 1) ||
      ( newRow == currentRow - 2 && newCol == currentCol - 1)) {
        validSpotKnight(piece, currentRow, currentCol, newRow, newCol);
      }
}

// Methods for moving the lowercase player's pawn
// if piece is p, then use movepawn()
public void legalpawnMove(char piece, int currentRow, int currentCol, int newRow, int newCol){
  if( newRow == currentRow - 1 && emptySpace(newRow, newCol)){
    moveChar(piece, currentRow, currentCol, newRow, newCol);
  }
  if( (newRow == currentRow - 1 && (newCol == currentCol + 1 || newCol == currentCol - 1)) && !emptySpace(newRow, newCol)){
    moveChar(piece, currentRow, currentCol, newRow, newCol);
  }
}

// method for lowercase player that includes changing pawn to knight
public void changepawnToknight(char piece, int currentRow, int currentCol, int newRow, int newCol){
  if( newRow == 0){
    piece = 'k';
    legalpawnMove(piece, currentRow, currentCol, newRow, newCol);
  }
  else {
    legalpawnMove(piece, currentRow, currentCol, newRow, newCol);
  }
}

// method for moving Uppercase pawn
public void legalPawnMove(char piece, int currentRow, int currentCol, int newRow, int newCol){
  if( newRow == currentRow + 1 && emptySpace(newRow, newCol)){
    moveChar(piece, currentRow, currentCol, newRow, newCol);
  }
  if( (newRow == currentRow + 1 && (newCol == currentCol + 1 || newCol == currentCol - 1)) && !emptySpace(newRow, newCol)){
    moveChar(piece, currentRow, currentCol, newRow, newCol);
  }
}

// method for uppercase player that includes changing pawn to knight
public void changePawnToKnight(char piece, int currentRow, int currentCol, int newRow, int newCol){
  if( newRow == 4){
    piece = 'K';
    legalPawnMove(piece, currentRow, currentCol, newRow, newCol);
  }
  else {
    legalPawnMove(piece, currentRow, currentCol, newRow, newCol);
  }
}

// method that moves pawns
public void movePawn(char piece, int currentRow, int currentCol, int newRow, int newCol){
  if( piece == 'p'){
    changepawnToknight(piece, currentRow, currentCol, newRow, newCol);
  }
  else if( piece == 'P'){
    changePawnToKnight(piece, currentRow, currentCol, newRow, newCol);
  }
}


// method moves any piece
// requires the type of piece, start coords, and ending coords.
public void movePiece(char piece, int currentRow, int currentCol, int newRow, int newCol){
  if( piece == 'P' || piece == 'p'){
    movePawn(piece, currentRow, currentCol, newRow, newCol);
  }
  else if( piece == 'K' || piece == 'k'){
    moveKnight(piece, currentRow, currentCol, newRow, newCol);
  }
}

// make move funciton for at the same time
public void secretMove( char piece1, char piece2, int r1, int c1,
                        int newR1, int newC1, int r2, int c2, int newR2, int newC2){
  if( newR1 == newR2 && newC1 == newC2){
      if( (piece1 == 'K' && piece2 == 'k') || (piece1 == 'k' && piece2 == 'K') ||
          (piece1 == 'P' && piece2 == 'p') || (piece1 == 'P' && piece2 == 'p')) {
          grid[newR1][newC1] = '.';
          grid[r1][c1] = '.';
          grid[r2][c1] = '.';
      }
      else if( (piece1 == 'K' && piece2 == 'p') || (piece1 == 'k' && piece2 == 'P')){
          grid[newR1][newC1] = piece1;
          grid[r1][c1] = '.';
          grid[r2][c1] = '.';
      }
      else if( (piece1 == 'p' && piece2 == 'K') || (piece1 == 'P' && piece2 == 'k')){
          grid[newR1][newC1] = piece2;
          grid[r1][c1] = '.';
          grid[r2][c1] = '.';
      }
    }
 }

}
