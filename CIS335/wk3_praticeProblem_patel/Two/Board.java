
//-----------------------------------------------------------------------------------
//Board Class
package practTwo;

public class Board
{
	private char[][] arr;

	  // Constructor
	  public Board()
	  {
        arr = new char[3][3];
	  }
	  // TODO: print board
	  public void printBoard()
	  {
		 System.out.println("|-----|-----|-----|");
		 System.out.println("|- " + arr[0][0] + " -|- " + arr[0][1] + " -|- " + arr[0][2] + " -|");
		 System.out.println("|- " + arr[1][0] + " -|- " + arr[1][1] + " -|- " + arr[1][2] + " -|");
		 System.out.println("|- " + arr[2][0] + " -|- " + arr[2][1] + " -|- " + arr[2][2] + " -|");
		 System.out.println("|-----|-----|-----|");
	  }
	  
	  // Validate a position
	  public boolean addToBoard(int row, int col, Player p)
	  {
	    if (arr[row-1][col-1] == 0)
	    {
			this.arr[row - 1][col - 1] = p.getPiece();
			return true; 
	    }
	    else
	    {
	      return false;
	    }
	  }

	  //Check win
	  public boolean checkForWin(Player p)
	  {
        return (
			  (arr[0][0] == p.getPiece() && arr[0][1] == p.getPiece() && arr[0][2] == p.getPiece()) ||
			  (arr[1][0] == p.getPiece() && arr[1][1] == p.getPiece() && arr[1][2] == p.getPiece()) ||
			  (arr[2][0] == p.getPiece() && arr[2][1] == p.getPiece() && arr[2][2] == p.getPiece()) ||
			  (arr[0][0] == p.getPiece() && arr[1][0] == p.getPiece() && arr[2][0] == p.getPiece()) ||
			  (arr[0][1] == p.getPiece() && arr[1][1] == p.getPiece() && arr[2][1] == p.getPiece()) ||
			  (arr[0][2] == p.getPiece() && arr[1][2] == p.getPiece() && arr[2][2] == p.getPiece()) ||
          	  (arr[0][0] == p.getPiece() && arr[1][1] == p.getPiece() && arr[2][2] == p.getPiece()) ||
          	  (arr[0][2] == p.getPiece() && arr[1][1] == p.getPiece() && arr[2][0] == p.getPiece())
			  );
	  }
	  //Check draw
}

