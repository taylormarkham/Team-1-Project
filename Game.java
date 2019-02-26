import java.util.ArrayList;
import java.util.Scanner;

//A COUPLE THINGS TO NOTE:
//BETTER VARIABLE NAMES WILL BE CHOSEN IN THE FUTURE
//CURRENTLY THE USERS CAN MOVE PAWNS/KNIGHTS ANYWHERE ON THE BOARD (RIGHT NOW WE ARE ASSUMING THAT THE TWO PLAYERS WILL MOVE THE PIECES CORRECTLY EACH TURN). THIS WILL BE FIXED IN THE FUTURE

public class Game {
	//instance variables
	private GameConfig config = new GameConfig();
	
	//default constructor
	public Game() {
	}

	//getters
	public GameConfig getConfig() {
		return new GameConfig();
	}

	//methods
	public static void main(String[] args) {
		GameConfig config = new GameConfig();
		int counter = 0;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("This is a 5x5 chess board. Rows go from 0-4 and columns go from 0-4. Player 1 controls the White pieces and Player 2 controls the Black pieces. The pieces are White Knight(wK), White Pawn(wP), Black Knight(bK), Black Pawn(bP).\n");

		//prints out what the initial board looks like	
  		for (int p = 0; p < 5; p++) {
    			for (int k = 0; k < 5; k++) {
				System.out.print(config.getBoard()[p][k] + " ");
				if (k == 4) {
					System.out.print("\n");
				}
			}
		}	
		while (true) {
			ArrayList<String> list = new ArrayList<String>();
			counter++;
			
			//keeps track of what turn it is
			System.out.print("Turn " + counter + "\n");
	
			//prompts player 1 to choose a piece
			System.out.print("Player 1. Choose a piece: ");
			String change = keyboard.next();
			while(!change.equals("wK") && !change.equals("wP")){
				System.out.print("Invalid input. Enter wK or wP: ");
				change = keyboard.next();
			}

			//prompts player 1 to choose the row that their piece is on from 0-4
			System.out.print("Which row is this piece on? ");
			int rRemove = keyboard.nextInt();
    			while (rRemove > 4 || rRemove < 0) {
        			System.out.print("Invalid answer. Please enter a valid row: ");
				rRemove = keyboard.nextInt();
			}

			//prompts player 1 to choose the column that their piece is on from 0-4
			System.out.print("Which column is this piece on? ");
			int cRemove = keyboard.nextInt();
    			while (cRemove > 4 || cRemove < 0) {
        			System.out.print("Invalid answer. Please enter a valid column: ");
				cRemove = keyboard.nextInt();
			}

			//checks if the piece exists at the spot on the board chosen by player 1
			while (!config.getBoard()[rRemove][cRemove].equals(change)) {
				System.out.print("That spot on the board does not have that piece. Pick a location where your piece exists. \n");
				System.out.print("Which row is this piece on? ");
				rRemove = keyboard.nextInt();
    				while (rRemove > 4 || rRemove < 0) {
        				System.out.print("Invalid answer. Please enter a valid row: ");
					rRemove = keyboard.nextInt();
				}
				System.out.print("Which column is this piece on? ");
				cRemove = keyboard.nextInt();
    				while (cRemove > 4 || cRemove < 0) {
        				System.out.print("Invalid answer. Please enter a valid column: ");
					cRemove = keyboard.nextInt();
				}
			}
			
			//prompts player 1 to move their piece to a row from 0-4
			System.out.print("Pick a row to move your piece to: ");
			int i = keyboard.nextInt();
    			while (i > 4 || i < 0) {
        			System.out.print("Invalid answer. Please enter a valid row: ");
				i = keyboard.nextInt();
			}

			//prompts player 1 to move their piece to a column from 0-4
			System.out.print("Pick a column to move your piece to: ");
			int j = keyboard.nextInt();
    			while (j > 4 || j < 0) {
        			System.out.print("Invalid answer. Please enter a valid column: ");
				j = keyboard.nextInt();
			}

			//checks if the spot on the board that player 1 wants to move the piece to is already occupied by another piece 
			while (config.getBoard()[i][j].equals("wP") || config.getBoard()[i][j].equals("wK")) {
				System.out.print("That spot on the board is already occupied by one of your other pieces. Choose another location on the board. \n");
				System.out.print("Pick a row to move your piece to: ");
				i = keyboard.nextInt();
    				while (i > 4 || i < 0) {
        				System.out.print("Invalid answer. Please enter a valid row: ");
					i = keyboard.nextInt();
				}
				System.out.print("Pick a column to move your piece to: ");
				j = keyboard.nextInt();
    				while (j > 4 || j < 0) {
        				System.out.print("Invalid answer. Please enter a valid column: ");
					j = keyboard.nextInt();
				}
			}

			//prompts player 2 to choose a piece
			System.out.print("Player 2. Choose a piece: ");
			String change2 = keyboard.next();
			while(!change2.equals("bK") && !change2.equals("bP")){
				System.out.print("Invalid input. Enter bK or bP: ");
				change2 = keyboard.next();
			}

			//prompts player 2 to choose the row that their piece is on from 0-4
			System.out.print("Which row is this piece on? ");
			int rRemove2 = keyboard.nextInt();
    			while (rRemove2 > 4 || rRemove2 < 0) {
        			System.out.print("Invalid answer. Please enter a valid row: ");
				rRemove2 = keyboard.nextInt();
			}

			//prompts player 2 to choose the column that their piece is on from 0-4
			System.out.print("Which column is this piece on? ");
			int cRemove2 = keyboard.nextInt();
    			while (cRemove2 > 4 || cRemove2 < 0) {
        			System.out.print("Invalid answer. Please enter a valid column: ");
				cRemove2 = keyboard.nextInt();
			}

			//checks if the piece exists at the spot on the board chosen by player 2
			while (!config.getBoard()[rRemove2][cRemove2].equals(change2)) {
				System.out.print("That spot on the board does not have that piece. Pick a location where your piece exists. \n");
				System.out.print("Which row is this piece on? ");
				rRemove2 = keyboard.nextInt();
    				while (rRemove2 > 4 || rRemove2 < 0) {
        				System.out.print("Invalid answer. Please enter a valid row: ");
					rRemove2 = keyboard.nextInt();
				}
				System.out.print("Which column is this piece on? ");
				cRemove2 = keyboard.nextInt();
    				while (cRemove2 > 4 || cRemove2 < 0) {
        				System.out.print("Invalid answer. Please enter a valid column: ");
					cRemove2 = keyboard.nextInt();
				}
			}
			
			//prompts player 2 to move their piece to a row from 0-4
			System.out.print("Pick a row to move your piece to: ");
			int i2 = keyboard.nextInt();
    			while (i2 > 4 || i2 < 0) {
        			System.out.print("Invalid answer. Please enter a valid row: ");
				i2 = keyboard.nextInt();
			}

			//prompts player 2 to move their piece to a column from 0-4
			System.out.print("Pick a column to move your piece to: ");
			int j2 = keyboard.nextInt();
			System.out.print("\n");
    			while (j2 > 4 || j2 < 0) {
        			System.out.print("Invalid answer. Please enter a valid column: ");
				j2 = keyboard.nextInt();
				System.out.print("\n");
			}

			//checks if the spot on the board that player 2 wants to move the piece to is already occupied by another piece 
			while (config.getBoard()[i2][j2].equals("bP") || config.getBoard()[i2][j2].equals("bK")) {
				System.out.print("That spot on the board is already occupied by one of your other pieces. Choose another location on the board. \n");
				System.out.print("Pick a row to move your piece to: ");
				i2 = keyboard.nextInt();
    				while (i2 > 4 || i2 < 0) {
        				System.out.print("Invalid answer. Please enter a valid row: ");
					i2 = keyboard.nextInt();
				}
				System.out.print("Pick a column to move your piece to: ");
				j2 = keyboard.nextInt();
    				while (j2 > 4 || j2 < 0) {
        				System.out.print("Invalid answer. Please enter a valid column: ");
					j2 = keyboard.nextInt();
					System.out.print("\n");
				}
			}

			//if both White and Black move a piece to the same spot on the board
			if (i == i2 && j == j2) {
				//if White moves a knight to the same spot that Black moves a pawn, then the knight will beat the pawn and take the spot
				if (change.equals("wK") && change2.equals("bP")) {
					config.changeBoard("__", rRemove, cRemove);
					config.changeBoard("__", rRemove2, cRemove2);
					config.changeBoard(change, i, j);
				}
				//if Black moves a knight to the same spot that White moves a pawn, then the knight will beat the pawn and take the spot
				else if (change.equals("wP") && change2.equals("bK")) {
					config.changeBoard("__", rRemove, cRemove);
					config.changeBoard("__", rRemove2, cRemove2);
					config.changeBoard(change2, i2, j2);
				}
				//if both White and Black move to the same spot with pawns, then both pawns will vanish from the board
				else if (change.equals("wP") && change2.equals("bP")) {
					config.changeBoard("__", rRemove, cRemove);
					config.changeBoard("__", rRemove2, cRemove2);
				}
			}
			else {
				config.changeBoard("__", rRemove, cRemove);
				config.changeBoard(change, i, j);
				config.changeBoard("__", rRemove2, cRemove2);
				config.changeBoard(change2, i2, j2);
			}

			//seeing if either black or white won by checking the state of the board
  			for (int p = 0; p < 5; p++) {
    				for (int k = 0; k < 5; k++) {
					list.add(config.getBoard()[p][k]);
					
					//prints out what the board looks like after what the two players have inputted
					System.out.print(config.getBoard()[p][k] + " ");
					if (k == 4) {
						System.out.print("\n");
					}
					if (p == 4 && k == 4) {
						System.out.print("\n");
					}
				}
			}
			
			//counts how many White Pawns and Black Pawns are currently on the board 
			int w = 0;
			int b = 0;
			for (int z = 0; z < list.size(); z++) {
				if (list.get(z) == "wP") {
					w = w + 1;
				}
				else if (list.get(z) == "bP") {
					b = b + 1;
				}
			}

			//if white has at least one pawn but black has none, then white won and the loop ends
			if (b == 0 && w > 0) {
				System.out.print("White has won");
				break;
			}
			//if black has at least one pawn but white has none, then black won and the loop ends
			else if (w == 0 && b > 0) {
				System.out.print("Black has won");
				break;
			}
			//if both black and white have no pawns, then it's a draw and the loop ends
			else if (w == 0 && b == 0) {
				System.out.print("Draw.");
				break;
			}
		}
	}
}