public class GameConfig {


	/*the initial board to start the game
	*
	*/
	//strings for the two players
	private final String player1 = "player 1" ;//can have these set to other things later
	private final String player2 = "player 2" ;
	private final String WHITE_KNIGHT = "wK";
	private final String BLACK_KNIGHT = "bK";
	private final String WHITE_PAWN = "wP";
	private final String BLACK_PAWN = "bP";
	private final String BLANK = "__";


	private final String[][] board = {
		{WHITE_KNIGHT, WHITE_PAWN, WHITE_PAWN, WHITE_PAWN, WHITE_KNIGHT},
		{WHITE_PAWN, BLANK, BLANK, BLANK, WHITE_PAWN},
		{BLANK, BLANK, BLANK, BLANK, BLANK },
		{BLACK_PAWN, BLANK, BLANK, BLANK, BLACK_PAWN},
		{BLACK_KNIGHT, BLACK_PAWN, BLACK_PAWN, BLACK_PAWN, BLACK_KNIGHT}
	};

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


// checks if there are any black pawns left
	public boolean noBlackPawns(){
		boolean nobPawns = true;
		for( int row = 0; row < 5; row++){
			for(int col = 0; col < 5; col++){
				if( board[row][col].equals(BLACK_PAWN)){
					nobPawns = false;
				}
			}
		}
		return(nobPawns);
	}

// checks if there are any white pawns left
	public boolean noWhitePawns(){
		boolean nowPawns = true;
		for( int row = 0; row < 5; row++){
			for(int col = 0; col < 5; col++){
				if( board[row][col].equals(WHITE_PAWN)){
					nowPawns = false;
				}
			}
		}
		return(nowPawns);
	}

// checks to see if game has been won
	public boolean gameWon(){
		boolean gameOver = false;
		if (noWhitePawns() == true && noBlackPawns() == true){
			System.out.print("It is a draw!");
			gameOver = true;
		}
		else if( noWhitePawns() == true && noBlackPawns() != true){
			System.out.print("Black has won!");
			gameOver = true;
		}
		else if( noBlackPawns() == true && noWhitePawns() != true ){
			System.out.print("White has won!");
			gameOver = true;
		}
		else{
			gameOver = false;
		}
		return(gameOver);
	}

	// prints out the game board
	public void printBoard(){
		for(int row = 0; row < 5; row++){
			for(int col = 0; col < 5; col++){
				System.out.print(board[row][col] + " " );
			}
			System.out.println();
		}
	}

	public boolean inputMatchesBoard(String piece, int cRow, int cCol){
		boolean validMatch = true;
		if( board[cRow][cCol].equals(piece)){
			validMatch = true;
		}
		else{
			validMatch = false;
		}
		return(validMatch);
	}

// checks if user is entering a valid piece for black player
	public boolean validInputBlack( String piece){
		boolean validBlackPiece = true;
		if(  piece.equals(BLACK_PAWN) || piece.equals(BLACK_KNIGHT)){
			validBlackPiece = true;
		}
		else{
			validBlackPiece = false;
		}
		return(validBlackPiece);
	}

// checks if user is entering a valid piece for white player
	public boolean validInputWhite( String piece){
		boolean validWhitePiece = true;
		if(  piece.equals(WHITE_PAWN) || piece.equals(WHITE_KNIGHT)){
			validWhitePiece = true;
		}
		else{
			validWhitePiece = false;
		}
		return(validWhitePiece);
	}

// checks if a space is empty
public boolean emptySpace(int row, int col){
	return board[row][col].equals(BLANK);
}

// places a piece is a new spot
public void writeChar(String piece, int row, int col){
	board[row][col] = piece;
}

// moves a piece and updates original spot to be empty
public void moveChar(String piece, int currentRow, int currentCol, int newRow, int newCol){
	writeChar(BLANK, currentRow, currentCol);
	//emptySpace(currentRow,currentCol);
	writeChar(piece, newRow, newCol);
}


// checks if spot is valid for knight to move to
public void validSpotKnight(String piece, int currentRow, int currentCol, int newRow, int newCol){
	if( piece.equals(WHITE_KNIGHT) ){
		if( !board[newRow][newCol].equals(piece) && !board[newRow][newCol].equals(WHITE_PAWN)){
			moveChar(piece, currentRow, currentCol, newRow, newCol);
		}
	}
	else if( piece.equals(BLACK_KNIGHT)){
		if( !board[newRow][newCol].equals(piece) && !board[newRow][newCol].equals(BLACK_PAWN)){
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

// Methods for moving the black player's pawn
// if piece is p, then use movepawn()
public void legalpawnMove(String piece, int currentRow, int currentCol, int newRow, int newCol){
	if( newRow == currentRow - 1 && emptySpace(newRow, newCol)){
		moveChar(piece, currentRow, currentCol, newRow, newCol);
	}
	if( (newRow == currentRow - 1 && (newCol == currentCol + 1 || newCol == currentCol - 1)) && !emptySpace(newRow, newCol)){
		moveChar(piece, currentRow, currentCol, newRow, newCol);
	}
}

// method for black player that includes changing pawn to knight
public void changepawnToknight(String piece, int currentRow, int currentCol, int newRow, int newCol){
	if( newRow == 0){
		piece = BLACK_KNIGHT;
		legalpawnMove(piece, currentRow, currentCol, newRow, newCol);
	}
	else {
		legalpawnMove(piece, currentRow, currentCol, newRow, newCol);
	}
}

// method for moving White pawn
public void legalPawnMove(String piece, int currentRow, int currentCol, int newRow, int newCol){
	if( newRow == currentRow + 1 && emptySpace(newRow, newCol)){
		moveChar(piece, currentRow, currentCol, newRow, newCol);
	}
	if( (newRow == currentRow + 1 && (newCol == currentCol + 1 || newCol == currentCol - 1)) && !emptySpace(newRow, newCol)){
		moveChar(piece, currentRow, currentCol, newRow, newCol);
	}
}

// method for white player that includes changing pawn to knight
public void changePawnToKnight(String piece, int currentRow, int currentCol, int newRow, int newCol){
	if( newRow == 4){
		piece = WHITE_KNIGHT;
		legalPawnMove(piece, currentRow, currentCol, newRow, newCol);
	}
	else {
		legalPawnMove(piece, currentRow, currentCol, newRow, newCol);
	}
}

// method that moves pawns
public void movePawn(String piece, int currentRow, int currentCol, int newRow, int newCol){
	if( piece.equals(BLACK_PAWN)){
		changepawnToknight(piece, currentRow, currentCol, newRow, newCol);
	}
	else if( piece.equals(WHITE_PAWN)){
		changePawnToKnight(piece, currentRow, currentCol, newRow, newCol);
	}
}


// method moves any piece
// requires the type of piece, start coords, and ending coords.
public void movePiece(String piece, int currentRow, int currentCol, int newRow, int newCol){
	if( piece.equals(WHITE_PAWN) || piece.equals(BLACK_PAWN)){
		movePawn(piece, currentRow, currentCol, newRow, newCol);
	}
	else if( piece.equals(WHITE_KNIGHT) || piece.equals(BLACK_KNIGHT)){
		moveKnight(piece, currentRow, currentCol, newRow, newCol);
	}
}

// make move funciton for at the same time
public void secretMove( String piece1, String piece2, int r1, int c1,
												int newR1, int newC1, int r2, int c2, int newR2, int newC2){
	if( newR1 == newR2 && newC1 == newC2){
			if( (piece1.equals(WHITE_KNIGHT) && piece2.equals(BLACK_KNIGHT)) || (piece1.equals(BLACK_KNIGHT) && piece2.equals(WHITE_KNIGHT)) ||
					(piece1.equals(WHITE_PAWN) && piece2.equals(BLACK_PAWN)) || (piece1.equals(BLACK_PAWN) && piece2.equals(WHITE_PAWN) )) {
					board[newR1][newC1] = BLANK;
					board[r1][c1] = BLANK;
					board[r2][c1] = BLANK;
			}
			else if( (piece1.equals(WHITE_KNIGHT) && piece2.equals(BLACK_KNIGHT)) || (piece1.equals(BLACK_KNIGHT) && piece2.equals(WHITE_PAWN))){
					board[newR1][newC1] = piece1;
					board[r1][c1] = BLANK;
					board[r2][c1] = BLANK;
			}
			else if( (piece1.equals(BLACK_PAWN) && piece2.equals(WHITE_KNIGHT)) || (piece1.equals(WHITE_PAWN) && piece2.equals(BLACK_KNIGHT))){
					board[newR1][newC1] = piece2;
					board[r1][c1] = BLANK;
					board[r2][c1] = BLANK;
			}
		}
	else{
			movePiece(piece1, r1, c1, newR1, newC1);
			movePiece(piece2, r2, c2, newR2, newC2);
	}
 }

}
