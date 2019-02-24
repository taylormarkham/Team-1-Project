import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	//instance variables
	private HumanPlayer human = new HumanPlayer();
	private ComputerPlayer ai = new ComputerPlayer();
	private GameConfig config = new GameConfig();
	
	//default constructor
	public Game() {
	}

	//getters
	public HumanPlayer getHuman() {
		return new HumanPlayer();
	}
	public ComputerPlayer getAi() {
		return new ComputerPlayer();
	}
	public GameConfig getConfig() {
		return new GameConfig();
	}

	//methods
	public void setup() {
	}
	public void play() {
		boolean y = true;
		while (y = true) {
			y = false;
			ArrayList<String> list = new ArrayList<String>();
			Scanner keyboard = new Scanner(System.in);
			System.out.print("This is a 5x5 chess board. The pieces are wKnight, wPawn, bKnight, bPawn.\n");
			
			//prompts user to choose a piece
			System.out.print("Choose a piece: ");
			String change = keyboard.next();	
			
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
        			System.out.print("Invalid answer. Please enter a valid row: ");
				j = keyboard.nextInt();
			}

			//changes board to a new state according to what the user inputted
			config.changeBoard(change, i, j);

			//still need to get the computer inputs

			//seeing if either black or white won by checking the state of the board
			config.getBoard();
    			for (int p = 0; p < 5; p++) {
    				for (int k = 0; k < 5; k++) {
					list.add(config.getBoard()[p][k]);
				}
			}
			for (int z = 0; z < list.size(); z++) {
				if (list.get(z) == "wPawn" || list.get(z) == "bPawn") {
					y = true;
				}
			}
		}
	}
}