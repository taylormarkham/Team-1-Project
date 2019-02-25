public class GameConfig {

	/*the initial board to start the game
	*wKnight correspondes to the white knight and so on.
	*
	*/
	private String[][] board = {
		{"wK","wP","wP","wP","wK"},
		{"wP","__","__","__","wP"},
		{"__","__","__","__","__"},
		{"bP","__","__","__","bP"},
		{"bK","bP","bP","bP","bK"}
	};

	//strings for the two players
	private String player1 = "player 1" ;//can have these set to other things later
	private String player2 = "player 2" ;

	//the class that returns the board
	public String[][] getBoard(){
		return board;
	}

	//the class that changes the board state at a specific tile
	public void changeBoard (String change, int i, int j){
		board[i][j] = change;
	}

	//choosing start player (really just chooses who gets which colour)
	public String initialPlayer(){
		int random = (int)(Math.random() *50 + 1); //getting a random number between 1 and 50
		if (random <=25){
			String startPlayer = player1;
			return startPlayer;
		} else {
			String startPlayer = player2;
			return startPlayer;
		}
	}

	// Tests to see if there are no pawns left - game is over when all pawns are gone
	public boolean noPawns(){
		boolean nopawns = true;
		for(int row = 0; row < 5; row++){
			for(int col = 0; col < 5; col++){
				if( board[row][col] == "wP" || board[row][col] == "bP"){
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
				System.out.print(board[row][col]);
			}
			System.out.println();
		}
	}

// checks if a space is empty
public boolean emptySpace(int row, int col){
	return board[row][col] == "__";
}

// places a piece is a new spot
public void writeChar(String piece, int row, int col){
	board[row][col] = piece;
}

// moves a piece and updates original spot to be empty
public void moveChar(String piece, int currentRow, int currentCol, int newRow, int newCol){
	writeChar("__", currentRow, currentCol);
	writeChar(piece, newRow, newCol);
}


// checks if spot is valid for knight to move to
public void validSpotKnight(String piece, int currentRow, int currentCol, int newRow, int newCol){
	if( piece == "wK" ){
		if( board[newRow][newCol] != piece && board[newRow][newCol] != "wP"){
			moveChar(piece, currentRow, currentCol, newRow, newCol);
		}
	}
	else if( piece == "bK"){
		if( board[newRow][newCol] != piece && board[newRow][newCol] != "bP"){
			moveChar(piece, currentRow, currentCol, newRow, newCol);
		}
	}
}

// method for moving knights
public void moveKnight(String piece, int currentRow, int currentCol, int newRow, int newCol){
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
public void legalpawnMove(String piece, int currentRow, int currentCol, int newRow, int newCol){
	if( newRow == currentRow - 1 && emptySpace(newRow, newCol)){
		moveChar(piece, currentRow, currentCol, newRow, newCol);
	}
	if( (newRow == currentRow - 1 && (newCol == currentCol + 1 || newCol == currentCol - 1)) && !emptySpace(newRow, newCol)){
		moveChar(piece, currentRow, currentCol, newRow, newCol);
	}
}

// method for lowercase player that includes changing pawn to knight
public void changepawnToknight(String piece, int currentRow, int currentCol, int newRow, int newCol){
	if( newRow == 0){
		piece = "bK";
		legalpawnMove(piece, currentRow, currentCol, newRow, newCol);
	}
	else {
		legalpawnMove(piece, currentRow, currentCol, newRow, newCol);
	}
}

// method for moving Uppercase pawn
public void legalPawnMove(String piece, int currentRow, int currentCol, int newRow, int newCol){
	if( newRow == currentRow + 1 && emptySpace(newRow, newCol)){
		moveChar(piece, currentRow, currentCol, newRow, newCol);
	}
	if( (newRow == currentRow + 1 && (newCol == currentCol + 1 || newCol == currentCol - 1)) && !emptySpace(newRow, newCol)){
		moveChar(piece, currentRow, currentCol, newRow, newCol);
	}
}

// method for uppercase player that includes changing pawn to knight
public void changePawnToKnight(String piece, int currentRow, int currentCol, int newRow, int newCol){
	if( newRow == 4){
		piece = "wK";
		legalPawnMove(piece, currentRow, currentCol, newRow, newCol);
	}
	else {
		legalPawnMove(piece, currentRow, currentCol, newRow, newCol);
	}
}

// method that moves pawns
public void movePawn(String piece, int currentRow, int currentCol, int newRow, int newCol){
	if( piece == "bP"){
		changepawnToknight(piece, currentRow, currentCol, newRow, newCol);
	}
	else if( piece == "wP"){
		changePawnToKnight(piece, currentRow, currentCol, newRow, newCol);
	}
}


// method moves any piece
// requires the type of piece, start coords, and ending coords.
public void movePiece(String piece, int currentRow, int currentCol, int newRow, int newCol){
	if( piece == "wP" || piece == "bP"){
		movePawn(piece, currentRow, currentCol, newRow, newCol);
	}
	else if( piece == "wK" || piece == "bK"){
		moveKnight(piece, currentRow, currentCol, newRow, newCol);
	}
}

// make move funciton for at the same time
public void secretMove( String piece1, String piece2, int r1, int c1,
												int newR1, int newC1, int r2, int c2, int newR2, int newC2){
	if( newR1 == newR2 && newC1 == newC2){
			if( (piece1 == "wK" && piece2 == "bK") || (piece1 == "bK" && piece2 == "wK") ||
					(piece1 == "wP" && piece2 == "bP") || (piece1 == "bP" && piece2 == "wP")) {
					board[newR1][newC1] = "__";
					board[r1][c1] = "__";
					board[r2][c1] = "__";
			}
			else if( (piece1 == "wK" && piece2 == "bK") || (piece1 == "bK" && piece2 == "wP")){
					board[newR1][newC1] = piece1;
					board[r1][c1] = "__";
					board[r2][c1] = "__";
			}
			else if( (piece1 == "bP" && piece2 == "wK") || (piece1 == "wP" && piece2 == "bK")){
					board[newR1][newC1] = piece2;
					board[r1][c1] = "__";
					board[r2][c1] = "__";
			}
		}
 }

}
