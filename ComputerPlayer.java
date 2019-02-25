import  java.util.Random; 
import java.util.ArrayList;


public class ComputerPlayer {
	
	//These are the instance variables.
		private String token;
		private Move lastMove;
		
	/*This is a constructor which initializes objects, so that other classes my call/use ComputerPlayer.  
	 * 
	 */
		public ComputerPlayer() {
			
		}
		
	
	/*This is the getter method. It computes the AI's next move. For this iteration, a randomization has been implemented.
	 * We use the getMove function to get AllValidMoves, and then choose a random valid move.
	 */
	
	public Move getMove(GameConfig currentConfig) {
		ArrayList<Move> moves = new ArrayList<Move>();
		moves=currentConfig.getAllValidMoves(this.token);
		
		//Move is an array. We want to index into that array and get a random valid move.
		Random Rand=new Random();
		int index= Rand.nextInt(moves.size());
		
		return moves.get(index);
		
	
	}
}
