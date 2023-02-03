import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MiniMaxGame extends Base_Static_Estimation{
	
	public ArrayList<ArrayList<Character>> GenerateMovesMidgameEndgame(ArrayList<Character> boardPosition)
	{
		int count =0;
		for(Character c : boardPosition)
		{
			if(c=='W')
			{
				count++;
			}
			
		}
		if(count==3)
		{
			return Base_Static_Estimation.GenerateHopping(boardPosition);
		}
		else
		{
			return GenerateMove(boardPosition);
		}
	}
	
	public ArrayList<ArrayList<Character>> GenerateMovesMidgameEndgameForBlack(ArrayList<Character> board)
	{
		 ArrayList<Character> tempb = new ArrayList<Character>();
  	   for(Character c : board)
  	   {
  		   if(c=='W')
  		   {
  			   tempb.add('B');
  		   }
  		   else if(c=='B')
  		   {
  			   tempb.add('W');
  		   }
  		   else
  		   {
  			   tempb.add(c);
  		   }
  	   }
  	   MiniMaxGame mmo1 = new MiniMaxGame();
  	   ArrayList<ArrayList<Character>> blackMoves = mmo1.GenerateMovesMidgameEndgame(tempb);
 		for (int i = 0; i < blackMoves.size(); i++)
 		{
 			ArrayList<Character> b = blackMoves.get(i);
   	   ArrayList<Character> temp1 = new ArrayList<Character>();

 		 for(Character c : b)
	   {
		   if(c=='W')
		   {
			 temp1.add('B');
		   }
		   else if(c=='B')
		   {
			 temp1.add('W');
		   }
		   else
		   {
			 temp1.add(c);
		   }
	   }
 			blackMoves.set(i,temp1);
 		}
 		return blackMoves;
	}
	
	public Minimax_Node MiniMaxMidgameEndgame(ArrayList<Character> inputBoardPosition,int depth,boolean is_White_Playing)
    {
 	   Base_Static_Estimation bse = new Base_Static_Estimation();
 	   Minimax_Node node = new Minimax_Node();
 	   Minimax_Node temp = new Minimax_Node();
 	   if(depth == 0)
 	   {
 		   node.mini_max_estimate = bse.StaicEstimationMidgameEndgame(inputBoardPosition);
 		   node.positions_evaluated_se++;
 		  // node.outputBoardPosition=inputBoardPosition;
			return node;
		   }
 	   //if depth is not 0
 	  ArrayList<ArrayList<Character>> possibleMovesFromHere = new ArrayList<ArrayList<Character>>();
 	   	if(is_White_Playing)
 	   	{
 	   	 node.mini_max_estimate = Integer.MIN_VALUE;
 	   	possibleMovesFromHere = GenerateMovesMidgameEndgame(inputBoardPosition);
 	   	}
 	   	else {
 	   	 node.mini_max_estimate = Integer.MAX_VALUE;
  	   	possibleMovesFromHere = GenerateMovesMidgameEndgameForBlack(inputBoardPosition);

 	   	}
 	  
 	   for (ArrayList<Character> pm : possibleMovesFromHere)
 	   {
 		   if(is_White_Playing)
 		   {

			//recursive call	    
 		    temp = MiniMaxMidgameEndgame(pm,depth - 1,false);
 		   node.positions_evaluated_se += temp.positions_evaluated_se;
			   if (temp.mini_max_estimate > node.mini_max_estimate)
					{
					node.mini_max_estimate = temp.mini_max_estimate;
					node.outputBoardPosition = (ArrayList<Character>)pm.clone();
					}
 		   }
 		   else {
 			  temp = MiniMaxMidgameEndgame(pm,depth - 1,true);
 	 		  node.positions_evaluated_se += temp.positions_evaluated_se;
 	 		  node.positions_evaluated_se++;
 	 		 
 				   if (temp.mini_max_estimate < node.mini_max_estimate)
 						{
 						node.mini_max_estimate = temp.mini_max_estimate;
 						node.outputBoardPosition = (ArrayList<Character>)pm.clone();
 						}
 			   
 		   }
				
			
 	   }
 	   return node;
    }
 	   
 	   
 	   
    public static void main(String[] args)
    {
 	   String inputFileName, outputFileName;
 	   int depthOfTheTree;
 	   Minimax_Node outputBoardPosition = new Minimax_Node();
 	   inputFileName = args[0];
 	   outputFileName = args[1];
 	   depthOfTheTree = Integer.parseInt(args[2]);
 	   try {
 		   FileReader inputFileReader = new FileReader(inputFileName);
 		   BufferedReader inputBufferReader = new BufferedReader(inputFileReader);
 			String positionArray = inputBufferReader.readLine();
 			ArrayList<Character> inputBoardPosition = new ArrayList<Character>();
 			for (Character c : positionArray.toCharArray()){
 				inputBoardPosition.add(c);

 			}
 			inputBufferReader.close();
 			MiniMaxGame mg = new MiniMaxGame();
 	    	outputBoardPosition = mg.MiniMaxMidgameEndgame(inputBoardPosition,depthOfTheTree,true);
 	        File outputFileCreation = new File(outputFileName);
 	    	FileWriter writeOutput = new FileWriter(outputFileName);
	    	System.out.println(outputBoardPosition.toString());
 	    	writeOutput.write(outputBoardPosition.toString());
 	    	writeOutput.close();
 	    	
 	   }
 	   catch(IOException io)
 	   {
 		   io.printStackTrace();
 	   }
 	    	   
 	   
    }
}
