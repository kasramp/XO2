package userclasses;

public class ComputerPlayer {
	
	private String[] gameBoard = null;
	private String computerIdentity  = "";
	private String opponentIdentity = "";
	private int[][] conditions = {{1,2},{1,3},{1,4},{1,5},{1,7},{1,9},
			{2,3},{2,5},{2,8},
			{3,5},{3,6},{3,7},{3,9},
			{4,5},{4,6},{4,7},
			{5,6},{5,7},{5,8},{5,9},
			{6,9},
			{7,8},{7,9},
			{8,9}
	};
	private int[] move = {3,2,7,9,4,5,1,8,5,7,9,5,6,6,5,1,4,3,2,1,3,9,8,7};
	private boolean computerWinner = false;
	public ComputerPlayer(String [] gameBoard)
	{
		this.gameBoard = gameBoard;
	}
	public int makeMove(String computerIdentity)
	{
		int iComputerIdentity = Integer.parseInt(computerIdentity);
		this.computerIdentity = Integer.toString(iComputerIdentity%2+1);
		if("1".equalsIgnoreCase(this.computerIdentity))
		{
			this.opponentIdentity = "2";
		}
		else {
			this.opponentIdentity = "1";
		}
		int moveVal = -1;
		moveVal = winningCondition();
		if(moveVal > -1)
		{
			gameBoard[moveVal] = this.computerIdentity;
			return moveVal;
		} 
		else
		{
			moveVal = loosingCondition();
		}
		if(moveVal > -1)
		{
			gameBoard[moveVal] = this.computerIdentity;
			return moveVal;
		} else 
		{
			moveVal = randomMove();
			gameBoard[moveVal] = this.computerIdentity;
			return moveVal;
		}
		
	}
	private int winningCondition()
	{
		for(int i=0; i<conditions.length;i++)
		{
			if(gameBoard[conditions[i][0]].equalsIgnoreCase(computerIdentity) 
			&& gameBoard[conditions[i][1]].equalsIgnoreCase(computerIdentity))
			{
				if(!isBlocked(move[i]))
				{
					return move[i];
				}
			}
				
		}
		return -1;
	}
	private int loosingCondition()
	{
		for(int i=0; i<conditions.length;i++)
		{
			if(gameBoard[conditions[i][0]].equalsIgnoreCase(opponentIdentity) 
			&& gameBoard[conditions[i][1]].equalsIgnoreCase(opponentIdentity))
			{
				if(!isBlocked(move[i]))
				{
					return move[i];
				}
			}
				
		}
		return -1;
	}
	private int randomMove()
	{
		for(int i=1; i<gameBoard.length;i++)
		{
			if(gameBoard[i].equalsIgnoreCase("0"))
			{
				return i;
			}
		}
		return -1;
	}
	private boolean isBlocked(int elnumber)
	{
		if("0".equalsIgnoreCase(gameBoard[elnumber]))
		{
			return false;
		}
		else 
		{
			return true;
		}
	}
	public boolean getIsComputerWinner()
	{
		if ( (gameBoard[1].equals(computerIdentity) && gameBoard[2].equals(computerIdentity) && gameBoard[3].equals(computerIdentity))|| //Row check
		        (gameBoard[4].equals(computerIdentity) && gameBoard[5].equals(computerIdentity) && gameBoard[6].equals(computerIdentity))||
		        (gameBoard[7].equals(computerIdentity) && gameBoard[8].equals(computerIdentity) && gameBoard[9].equals(computerIdentity))|| 
		        (gameBoard[1].equals(computerIdentity) && gameBoard[4].equals(computerIdentity) && gameBoard[7].equals(computerIdentity))|| //Column check
		        (gameBoard[2].equals(computerIdentity) && gameBoard[5].equals(computerIdentity) && gameBoard[8].equals(computerIdentity))||
		        (gameBoard[3].equals(computerIdentity) && gameBoard[6].equals(computerIdentity) && gameBoard[9].equals(computerIdentity))|| //Cross check
		        (gameBoard[1].equals(computerIdentity) && gameBoard[5].equals(computerIdentity) && gameBoard[9].equals(computerIdentity))||
		        (gameBoard[3].equals(computerIdentity) && gameBoard[5].equals(computerIdentity) && gameBoard[7].equals(computerIdentity)) )
		{
			return true;
		}
		else { 
				return false;
			}
	}
}
