import java.util.ArrayList;

public class Minimax_Node {
	public int positions_evaluated_se, mini_max_estimate;
	public ArrayList<Character> outputBoardPosition;
	
	
	public String toString(){
		String obp="";
		
		for(Character c : outputBoardPosition)
		{
			obp=obp.concat(c.toString());
		}
		return 	"Board Position: " + obp + "\nPositions evaluated by static estimation: " + positions_evaluated_se + "\nMINIMAX estimate:\t\t" + mini_max_estimate;
	}

}
