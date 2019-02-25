import java.util.ArrayList;
import java.util.Scanner;

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
	public void setup() {
	}
	public static void main(String[] args) {
		GameConfig config = new GameConfig();
		int counter = 0;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("This is a 5x5 chess board. Player 1 controls the White pieces and Player 2 controls the Black pieces. The pieces are White Knight(wK), White Pawn(wP), Black Knight(bK), Black Pawn(bP).\n");	
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
	
			//prompts user to choose a piece
			System.out.print("Player 1. Choose a piece: ");
			String change = keyboard.next();

			System.out.print("Which row is this piece on? ");
			int rRemove = keyboard.nextInt();
    			while (rRemove > 4 || rRemove < 0) {
        			System.out.print("Invalid answer. Please enter a valid row: ");
				rRemove = keyboard.nextInt();
			}

			System.out.print("Which column is this piece on? ");
			int cRemove = keyboard.nextInt();
    			while (cRemove > 4 || cRemove < 0) {
        			System.out.print("Invalid answer. Please enter a valid column: ");
				cRemove = keyboard.nextInt();
			}	
			
			//prompts user to move their piece to a row from 0-4
			System.out.print("Pick a row to move your piece to: ");
			int i = keyboard.nextInt();
    			while (i > 4 || i < 0) {
        			System.out.print("Invalid answer. Please enter a valid row: ");
				i = keyboard.nextInt();
			}

			//prompts user to move their piece to a column from 0-4
			System.out.print("Pick a column to move your piece to: ");
			int j = keyboard.nextInt();
    			while (j > 4 || j < 0) {
        			System.out.print("Invalid answer. Please enter a valid column: ");
				j = keyboard.nextInt();
			}

			//prompts user to choose a piece
			System.out.print("Player 2. Choose a piece: ");
			String change2 = keyboard.next();

			System.out.print("Which row is this piece on? ");
			int rRemove2 = keyboard.nextInt();
    			while (rRemove2 > 4 || rRemove2 < 0) {
        			System.out.print("Invalid answer. Please enter a valid row: ");
				rRemove2 = keyboard.nextInt();
			}

			System.out.print("Which column is this piece on? ");
			int cRemove2 = keyboard.nextInt();
    			while (cRemove2 > 4 || cRemove2 < 0) {
        			System.out.print("Invalid answer. Please enter a valid column: ");
				cRemove2 = keyboard.nextInt();
			}	
			
			//prompts user to move their piece to a row from 0-4
			System.out.print("Pick a row to move your piece to: ");
			int i2 = keyboard.nextInt();
    			while (i2 > 4 || i2 < 0) {
        			System.out.print("Invalid answer. Please enter a valid row: ");
				i2 = keyboard.nextInt();
			}

			//prompts user to move their piece to a column from 0-4
			System.out.print("Pick a column to move your piece to: ");
			int j2 = keyboard.nextInt();
			System.out.print("\n");
    			while (j2 > 4 || j2 < 0) {
        			System.out.print("Invalid answer. Please enter a valid column: ");
				j2 = keyboard.nextInt();
				System.out.print("\n");
			}

			//changes board to a new state according to what the user inputted
			config.changeBoard("__", rRemove, cRemove);
			config.changeBoard(change, i, j);
			config.changeBoard("__", rRemove2, cRemove2);
			config.changeBoard(change2, i2, j2);

			//still need to get the computer inputs

			//seeing if either black or white won by checking the state of the board

  			for (int p = 0; p < 5; p++) {
    				for (int k = 0; k < 5; k++) {
					list.add(config.getBoard()[p][k]);
					System.out.print(config.getBoard()[p][k] + " ");
					if (k == 4) {
						System.out.print("\n");
					}
					if (p == 4 && k == 4) {
						System.out.print("\n");
					}
				}
			}
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

			//if white has at least one pawn but black has none, then white won
			if (b == 0 && w > 0) {
				System.out.print("White has won");
				break;
			}
			//if black has at least one pawn but white has none, then black won
			else if (w == 0 && b > 0) {
				System.out.print("Black has won");
				break;
			}
			//if both black and white have no pawns, then it's a draw
			else if (w == 0 && b == 0) {
				System.out.print("Draw.");
				break;
			}
		}
	}
}