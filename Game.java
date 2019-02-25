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
		int counter = 0;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("This is a 5x5 chess board. The pieces are wKnight, wPawn, bKnight, bPawn.\n");		
		while (true) {
			counter++;
			GameConfig config = new GameConfig();
			ArrayList<String> list = new ArrayList<String>();
			
			//keeps track of what turn it is
			System.out.print("Turn " + counter + "\n");
	
			//prompts user to choose a piece
			System.out.print("Choose a piece: ");
			String change = keyboard.next();

			System.out.print("Which row is this piece on? ");
			int rRemove = keyboard.nextInt();

			System.out.print("Which column is this piece on? ");
			int cRemove = keyboard.nextInt();		
			
			//prompts user to move their piece to a row from 1-5
			System.out.print("Pick a row to move your piece to: ");
			int i = keyboard.nextInt();
    			while (i > 5 || i < 1) {
        			System.out.print("Invalid answer. Please enter a valid row: ");
				i = keyboard.nextInt();
			}

			//prompts user to move their piece to a column from 1-5
			System.out.print("Pick a column to move your piece to: ");
			int j = keyboard.nextInt();
    			while (j > 5 || j < 1) {
        			System.out.print("Invalid answer. Please enter a valid column: ");
				j = keyboard.nextInt();
			}

			//changes board to a new state according to what the user inputted
			config.changeBoard("blank", rRemove, cRemove);
			config.changeBoard(change, i, j);

			//still need to get the computer inputs

			//seeing if either black or white won by checking the state of the board
    			for (int p = 0; p < 5; p++) {
    				for (int k = 0; k < 5; k++) {
					list.add(config.getBoard()[p][k]);
				}
			}

			int w = 0;
			int b = 0;
			for (int z = 0; z < list.size(); z++) {
				if (list.get(z) == "wPawn") {
					w = w + 1;
				}
				else if (list.get(z) == "bPawn") {
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