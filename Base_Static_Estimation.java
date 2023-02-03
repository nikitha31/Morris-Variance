import java.util.ArrayList;
import java.util.Arrays;

public class Base_Static_Estimation {
	 public int StaicEstimationOpening(ArrayList<Character> boardPosition)
     {
     	int numWhitePieces,numBlackPieces;
		numWhitePieces = NumWhitePieces(boardPosition);
     	numBlackPieces = NumBlackPieces(boardPosition);
     	return numWhitePieces-numBlackPieces;
     }
	 public int StaicEstimationMidgameEndgame(ArrayList<Character> boardPosition)
	 {
		 int numWhitePieces,numBlackPieces;
		 numWhitePieces = NumWhitePieces(boardPosition);
		 numBlackPieces = NumBlackPieces(boardPosition);
		 MiniMaxGame mmgo = new MiniMaxGame();
		 ArrayList<ArrayList<Character>> L = mmgo.GenerateMovesMidgameEndgameForBlack(boardPosition);
		 
		 int blackMoves = L.size();
		 if(numBlackPieces<=2)
		 {
			 return 10000;
		 }
		 else if(numWhitePieces<=2)
		 {
			 return -10000;
		 }
		
		 else if(blackMoves==0) 
		 {
			 return 10000;
		 }
		 else 
				 { return 1000*(numWhitePieces-numBlackPieces)-blackMoves;}
	 }

     public int NumWhitePieces(ArrayList<Character> boardPosition)
     {
     	int count = 0;
     	for(Character position : boardPosition)
     	{
     		if(position=='W')
     		{ 
     			count++;
     		}
     	}
     	return count;
     }
     public int NumBlackPieces(ArrayList<Character> boardPosition)
     {
     	int count = 0;
     	
     	for(Character position : boardPosition)
     	{
     		if(position=='B')
     		{
     			count++;
     		}
     	}
     	return count;
     }
     public static boolean closeMill(ArrayList<Character> boardposition, int j)
     {
     	char C = boardposition.get(j);
     	if(boardposition.get(j)=='x')
     	{
     		
     		System.out.println("value at position j shoudl be either W or B not X");
     		return false;
     	}
     	else {
     	switch(j) {
     	case 0:
     	 if((boardposition.get(2)==C)&&(boardposition.get(4)==C))
     	 {    // 		System.out.println("close mill");

     		return true;
     	 }
     	 else
     		 return false;
     	
     	case 1:
     		if((boardposition.get(3)==C && boardposition.get(5)==C) || (boardposition.get(8)==C && boardposition.get(17)==C) )
     		 {     	//	System.out.println("close mill");

      		return true;
      	 }     		else
     			return false;
     		
     	case 2:
     		 if((boardposition.get(0)==C)&&(boardposition.get(4)==C))
     		 {     		//System.out.println("close mill");

      		return true;
      	 }          	 else
          		return false;
     		 
     	case 3: //1,3,5 //3,7,14
     		if((boardposition.get(1)==C && boardposition.get(5)==C) || (boardposition.get(7)==C && boardposition.get(14)==C) )
     		 {     	//	System.out.println("close mill");

      		return true;
      	 }     		else
     			return false;
     		
     	case 4: 
     		if((boardposition.get(0)==C && boardposition.get(2)==C)  )
     		 {     		//System.out.println("close mill");

      		return true;
      	 }     		else
     			return false;
     		
     	case 5: //1,3,5 //5,6,11
     		if((boardposition.get(1)==C && boardposition.get(3)==C) || (boardposition.get(6)==C && boardposition.get(11)==C) )
     		 {     		//System.out.println("close mill");

      		return true;
      	 }     		else
     			return false;
     		
     	case 6: //5,6,11 //6,7,8
     		if((boardposition.get(5)==C && boardposition.get(11)==C) || (boardposition.get(7)==C && boardposition.get(8)==C) )
     		 {     		//System.out.println("close mill");

      		return true;
      	 }     		else
     			return false;
     		
     	case 7: //6,7,8//3,7,14
     		if((boardposition.get(6)==C && boardposition.get(8)==C) || (boardposition.get(3)==C && boardposition.get(14)==C) )
     		 {     	//	System.out.println("close mill");

      		return true;
      	 }     		else
     			return false;
     		
     	case 8://6,7,8 //1,8,17
     		if((boardposition.get(6)==C && boardposition.get(7)==C) || (boardposition.get(1)==C && boardposition.get(17)==C) )
     		 {     //		System.out.println("close mill");

      		return true;
      	 }     		else
     			return false;
     		
     	case 9: // 9,10,11 // 9,12,15
     		if((boardposition.get(10)==C && boardposition.get(11)==C) || (boardposition.get(12)==C && boardposition.get(15)==C) )
     		 {     	//	System.out.println("close mill");

      		return true;
      	 }     		else
     			return false;
     		
     	case 10://9,10,11//10,13,16
     		if((boardposition.get(9)==C && boardposition.get(11)==C) || (boardposition.get(13)==C && boardposition.get(16)==C) )
     		 {     	//	System.out.println("close mill");

      		return true;
      	 }     		else
     			return false;
     		
     	case 11://9,10,11//11,14,17
     		if((boardposition.get(9)==C && boardposition.get(10)==C) || (boardposition.get(14)==C && boardposition.get(17)==C) || (boardposition.get(5)==C && boardposition.get(6)==C))
     		 {     //		System.out.println("close mill");

      		return true;
      	 }     		else
     			return false;	
     		
     	case 12: //9,12,15 //12,13,14
     		if((boardposition.get(9)==C && boardposition.get(15)==C) || (boardposition.get(13)==C && boardposition.get(14)==C) )
     		 {     		//System.out.println("close mill");

      		return true;
      	 }     		else
     			return false;	
     		
     	case 13: //10,13,16 //12,13,14
     		if((boardposition.get(10)==C && boardposition.get(16)==C) || (boardposition.get(12)==C && boardposition.get(14)==C) )
     		 {     	//	System.out.println("close mill");

      		return true;
      	 }     		else
     			return false;	
     		
     	case 14: //11,14,17 //12,13,14
     		if((boardposition.get(11)==C && boardposition.get(17)==C) || (boardposition.get(12)==C && boardposition.get(13)==C) || (boardposition.get(3)==C && boardposition.get(7)==C) )
     		 {     //		System.out.println("close mill");

      		return true;
      	 }     		else
     			return false;	
     		
     	case 15: //9,12,15 //15,16,17
     		if((boardposition.get(9)==C && boardposition.get(12)==C) || (boardposition.get(16)==C && boardposition.get(17)==C) )
     		 {     	//	System.out.println("close mill");

      		return true;
      	 }     		else
     			return false;		
     		
     	case 16: //10,13,16 //15,16,17
     		if((boardposition.get(10)==C && boardposition.get(13)==C) || (boardposition.get(15)==C && boardposition.get(17)==C) )
     		 {     	//	System.out.println("close mill");

      		return true;
      	 }     		else
     			return false;		
     		
     	case 17: //11,14,17 //15,16,17
     		if((boardposition.get(11)==C && boardposition.get(14)==C) || (boardposition.get(15)==C && boardposition.get(16)==C) ||((boardposition.get(1)==C && boardposition.get(8)==C)))
     		 {     	//	System.out.println("close mill");

      		return true;
      	 }     		else
     			return false;		
     	default:
     		return false;
     	}
     		
     	}
     		
     }
     
     public ArrayList<ArrayList<Character>> GenerateAdd(ArrayList<Character> boardPosition){
  	   ArrayList<ArrayList<Character>> L = new ArrayList<ArrayList<Character>>();
  	   ArrayList<Character> b = new  ArrayList<Character>();
  	   for(int location=0;location<boardPosition.size();location++)
  	   {
  		   if(boardPosition.get(location)=='x')
  		   {
  			   //Collections.copy(b, boardPosition);
  			   b=(ArrayList<Character>)boardPosition.clone();
  			   b.set(location,'W');
  			   
  			   if(closeMill(b,location))
  			   {
  				  L =  GenerateRemove(L,b);
  			   }
  			   else {
  				   L.add(b);
  			   }
  			   
  		   }
  		   
  	   }
  	   return L;
  	   
     }
     public static ArrayList<ArrayList<Character>>  GenerateRemove(ArrayList<ArrayList<Character>> List,ArrayList<Character> boardPosition1)
     {
  	   
  	   for(int location=0;location<boardPosition1.size();location++)
  	   {
  		  if(boardPosition1.get(location)=='B')
  		  {
  		    if(!closeMill(boardPosition1,location))
  		    {
  		       ArrayList<Character> b1=(ArrayList<Character>)boardPosition1.clone();
  			   b1.set(location,'x');
  			   List.add(b1);
  		    }
  		  }
  		   
  	   }
  	   return List;
     }
     
     public static  ArrayList<ArrayList<Character>> GenerateHopping(ArrayList<Character> boardPosition)
     {
    	 ArrayList<ArrayList<Character>> L = new ArrayList<ArrayList<Character>>();
    	 ArrayList<Character> b_temp = new ArrayList<Character>();
    	 for(int location =0;location<boardPosition.size();location++)
    	 {
    		 if(boardPosition.get(location)=='W')
    		 {
    	    	 for(int b =0;b<boardPosition.size();b++)
    			 
    			 {
    				 if(boardPosition.get(b)=='x')
    				 {
    					 b_temp = (ArrayList<Character>)boardPosition.clone(); 
    					 b_temp.set(location,'x'); 
    					 b_temp.set(b,'W'); 
    					 if(closeMill(b_temp, b))
    						 {
    						    GenerateRemove(L,b_temp);
    						 }
    				     else L.add(b_temp);
    				 }
    			 }
    		 }
    	 }
    			
    			 return L;
     }
     
     public  ArrayList<ArrayList<Character>> GenerateMove(ArrayList<Character> boardPosition)
     {
    	 ArrayList<ArrayList<Character>> L = new ArrayList<ArrayList<Character>>();
    	 for(int location =0;location<boardPosition.size();location++) 
    	 {
    		 if(boardPosition.get(location)== 'W')
    		 {
    			 ArrayList<Integer> n = new ArrayList<Integer>();
    			 n = neighbors(location);
    			 for(int j : n)
    			 {
    				 if(boardPosition.get(j)=='x')
    				 {
    					 ArrayList<Character> b = (ArrayList<Character>)boardPosition.clone();
    					 b.set(location, 'x');
    					 b.set(j, 'W');
    					 if(closeMill(b,j))
    					 {
    						 GenerateRemove(L,b);
    					 }
    					 else
    					 {
    						 L.add(b);
    					 }
    				 }
    			 }
    		 }
    	 }
    	 return L;
         	
     	
     }
     
     
     
     public static ArrayList<Integer> neighbors(int i){
 		switch(i){
 			case 0:
 				return new ArrayList<Integer>(Arrays.asList(1, 2, 15));
 			case 1:
 				return new ArrayList<Integer>(Arrays.asList(0, 3, 8));
 			case 2:
 				return new ArrayList<Integer>(Arrays.asList(0, 3,4, 12));
 			case 3:
 				return new ArrayList<Integer>(Arrays.asList(1,2,5,7));
 			case 4:
 				return new ArrayList<Integer>(Arrays.asList(2,5,9));
 			case 5:
 				return new ArrayList<Integer>(Arrays.asList(3,4,6));
 			case 6:
 				return new ArrayList<Integer>(Arrays.asList(5,7,11));
 			case 7:
 				return new ArrayList<Integer>(Arrays.asList(3,6,8,14));
 			case 8:
 				return new ArrayList<Integer>(Arrays.asList(1,7,17));
 			case 9:
 				return new ArrayList<Integer>(Arrays.asList(4,10,12));
 			case 10:
 				return new ArrayList<Integer>(Arrays.asList(9,11,13));
 			case 11:
 				return new ArrayList<Integer>(Arrays.asList(6,10,14));
 			case 12:
 				return new ArrayList<Integer>(Arrays.asList(2,9,13,15));
 			case 13:
 				return new ArrayList<Integer>(Arrays.asList(10,12,14,16));
 			case 14:
 				return new ArrayList<Integer>(Arrays.asList(7,11,13,17));
 			case 15:
 				return new ArrayList<Integer>(Arrays.asList(0,12,16));
 			case 16:
 				return new ArrayList<Integer>(Arrays.asList(13,15,17));
 			case 17:
 				return new ArrayList<Integer>(Arrays.asList(8,16));
 			default:
 				return (new ArrayList<Integer>());
 		}
 	}
     
     
     public int mills_possible(ArrayList<Character> boardPosition)
     {
    	 int sum =0;
    	 
 		for (int location = 0; location< boardPosition.size(); location++)
 		{
 			if (boardPosition.get(location) == 'x')
 			{
 				if (closeMill(boardPosition, location))
 				{
 					sum++;
 				}
 			}
 		}
 		return sum;
 	}
     public int StaicEstimationMidgameEndgame_Improved(ArrayList<Character> boardPosition)
	 {
		 int numWhitePieces,numBlackPieces;
		 numWhitePieces = NumWhitePieces(boardPosition);
		 numBlackPieces = NumBlackPieces(boardPosition);
		 MiniMaxGame mmgo = new MiniMaxGame();
		 ArrayList<ArrayList<Character>> L = mmgo.GenerateMovesMidgameEndgameForBlack(boardPosition);
		 
		 int blackMoves = L.size();
		 if(numBlackPieces<=2)
		 {
			 return 10000;
		 }
		 else if(numWhitePieces<=2)
		 {
			 return -10000;
		 }
		
		 else if(blackMoves==0) 
		 {
			 return 10000;
		 }
		 else 
				 { return 1000*(mills_possible(boardPosition)+numWhitePieces-numBlackPieces)-blackMoves;}
	 }

     
     
}
 	



