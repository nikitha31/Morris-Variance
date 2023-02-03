import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ABGame extends Base_Static_Estimation{
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
  	   ArrayList<ArrayList<Character>> blackMoves = GenerateMovesMidgameEndgame(tempb);
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
	
	public Minimax_Node ABMidGameEndGame_1(ArrayList<Character> boardPosition, boolean white_player,int depth, int alpha, int beta)
	{
		Base_Static_Estimation bse = new Base_Static_Estimation();
		ABOpening abo_local = new ABOpening();
  	   Minimax_Node node = new Minimax_Node();
  	   Minimax_Node temp = new Minimax_Node();
  	   if(depth == 0)
  	   {
  		   node.mini_max_estimate = bse.StaicEstimationMidgameEndgame(boardPosition);
  		   node.positions_evaluated_se++;
  		  // node.outputBoardPosition=inputBoardPosition;
 			return node;
  	   }
  	 ArrayList<ArrayList<Character>> possibleMovesFromHere  = new ArrayList<ArrayList<Character>>();
  	   //if depth is not 0
  	   if(white_player)
  	   {
  		 possibleMovesFromHere = GenerateMovesMidgameEndgame(boardPosition);
  	   }
  	   else
  	   {
  		 possibleMovesFromHere = GenerateMovesMidgameEndgameForBlack(boardPosition);
  	   }

  	   for (ArrayList<Character> pm : possibleMovesFromHere)
  	   {
  		   if(white_player)
  		   {

 			//recursive call	    
  		   temp = ABMidGameEndGame_1(pm,false,depth - 1,alpha,beta);
  		   node.positions_evaluated_se += temp.positions_evaluated_se;
 			   if (temp.mini_max_estimate > alpha)
 					{
 					 alpha = temp.mini_max_estimate;
 					 node.outputBoardPosition = (ArrayList<Character>)pm.clone();
 					}
  		   }
  		   else {
  			 temp = ABMidGameEndGame_1(pm,true,depth - 1,alpha,beta);
    		   node.positions_evaluated_se += temp.positions_evaluated_se;
    		  // node.positions_evaluated_se++;
   			   if (beta > temp.mini_max_estimate )
   					{
   					 beta = temp.mini_max_estimate;
   					 node.outputBoardPosition = (ArrayList<Character>)pm.clone();
   					}
  			   
  		   }
 			  if(alpha>=beta)
 		  	   {
 		  		   break;
 		  	   }
 			
 		    }
  	  if(white_player)
  	  {
  	   node.mini_max_estimate = alpha;
  	  }
  	  else {
  	  	   node.mini_max_estimate = beta;
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
 			ABGame abme = new ABGame();
 	    	outputBoardPosition = abme.ABMidGameEndGame_1(inputBoardPosition,true,depthOfTheTree,Integer.MIN_VALUE,Integer.MAX_VALUE);
 	        File outputFileCreation = new File(outputFileName);
 	    	FileWriter writeOutput = new FileWriter(outputFileName);
 	    	System.out.println("out"+outputBoardPosition.toString());
 	    	writeOutput.write(outputBoardPosition.toString());
 	    	writeOutput.close();
 	    	
 	   }
 	   catch(IOException io)
 	   {
 		   io.printStackTrace();
 		   System.out.println("catch");
 	   }
 	    	   
    }

}
