public class GameConfig {

	/*the initial board to start the game
	*wKnight correspondes to the white knight and so on.
	*
	*/
	private String[][] board = {
		{"wKnight","wPawn","wPawn","wPawn","wKnight"},
		{"wPawn","blank","blank","blank","wPawn"},
		{"blank","blank","blank","blank","blank"},
		{"bPawn","blank","blank","blank","bPawn"},
		{"bKnight","bPawn","bPawn","bPawn","bKnight"}
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
				if( board[row][col] == "wPawn" || board[row][col] == "bPawn"){
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
	return board[row][col] == "blank";
}

// places a piece is a new spot
public void writeChar(String piece, int row, int col){
	board[row][col] = piece;
}

// moves a piece and updates original spot to be empty
public void moveChar(String piece, int currentRow, int currentCol, int newRow, int newCol){
	writeChar("blank", currentRow, currentCol);
	writeChar(piece, newRow, newCol);
}


// checks if spot is valid for knight to move to
public void validSpotKnight(String piece, int currentRow, int currentCol, int newRow, int newCol){
	if( piece == "wKnight" ){
		if( board[newRow][newCol] != piece && board[newRow][newCol] != "wPawn"){
			moveChar(piece, currentRow, currentCol, newRow, newCol);
		}
	}
	else if( piece == "bKnight"){
		if( board[newRow][newCol] != piece && board[newRow][newCol] != "bPawn"){
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
		piece = "bKnight";
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
		piece = "wKnight";
		legalPawnMove(piece, currentRow, currentCol, newRow, newCol);
	}
	else {
		legalPawnMove(piece, currentRow, currentCol, newRow, newCol);
	}
}

// method that moves pawns
public void movePawn(String piece, int currentRow, int currentCol, int newRow, int newCol){
	if( piece == "bPawn"){
		changepawnToknight(piece, currentRow, currentCol, newRow, newCol);
	}
	else if( piece == "wPawn"){
		changePawnToKnight(piece, currentRow, currentCol, newRow, newCol);
	}
}


// method moves any piece
// requires the type of piece, start coords, and ending coords.
public void movePiece(String piece, int currentRow, int currentCol, int newRow, int newCol){
	if( piece == "wPawn" || piece == "bPawn"){
		movePawn(piece, currentRow, currentCol, newRow, newCol);
	}
	else if( piece == "wKnight" || piece == "bKnight"){
		moveKnight(piece, currentRow, currentCol, newRow, newCol);
	}
}

// make move funciton for at the same time
public void secretMove( String piece1, String piece2, int r1, int c1,
												int newR1, int newC1, int r2, int c2, int newR2, int newC2){
	if( newR1 == newR2 && newC1 == newC2){
			if( (piece1 == "wKnight" && piece2 == "bKnight") || (piece1 == "bKnight" && piece2 == "wKnight") ||
					(piece1 == "wPawn" && piece2 == "bPawn") || (piece1 == "bPawn" && piece2 == "wPawn")) {
					board[newR1][newC1] = "blank";
					board[r1][c1] = "blank";
					board[r2][c1] = "blank";
			}
			else if( (piece1 == "wKnight" && piece2 == "bKnight") || (piece1 == "bKnight" && piece2 == "wPawn")){
					board[newR1][newC1] = piece1;
					board[r1][c1] = "blank";
					board[r2][c1] = "blank";
			}
			else if( (piece1 == "bPawn" && piece2 == "wKnight") || (piece1 == "wPawn" && piece2 == "bKnight")){
					board[newR1][newC1] = piece2;
					board[r1][c1] = "blank";
					board[r2][c1] = "blank";
			}
		}
 }

}
