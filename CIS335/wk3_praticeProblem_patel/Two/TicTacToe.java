//Main Class
package practTwo;

import java.util.Scanner;
public class TicTacToe
{
  	private Player x;
  	private Player o;
  	private Board board;
  	public TicTacToe() 
    {
      x = new Player('x');
      o = new Player('o');
      board = new Board();
      play();  /// play()
    }
  	public void play()
    {
      boolean xTurn = true;
      for (int i = 0; i < 9; i++)
      {
        board.printBoard();
        if (xTurn)
        {
          takeTurn(x);
          if (board.checkForWin(x))
          {
            break;
          }
          xTurn = false;
        }
        else 
        {
          takeTurn(o);
          if (board.checkForWin(o))
          {
            break;
          }
          xTurn = true;
        }
        
      }
      displayWinner();
    }
  
  	public void displayWinner()
    {
      if (!board.checkForWin(o) && !board.checkForWin(x))
        System.out.println("Game is a tie!");
      else if (board.checkForWin(o))
        System.out.println("The winner is " + o.getPiece() + "!");
      else
        System.out.println("The Winner is " + x.getPiece() + "!");
    }
  
  	public void takeTurn(Player p)
    {
      boolean validMove = false;
      Scanner input = new Scanner(System.in);
      while (!validMove) 
      {
        // player "o" or "x" where do you want to move?  etc...
        System.out.println("Enter the position you would like to place your " + p.getPiece() + " (row [1-3]) and (column[1-3]) *space seperated*: ");
        int row = input.nextInt();
        int col = input.nextInt();
        validMove = board.addToBoard(row, col, p);
      }
    }

	public static void main(String[] args)
	{
		new TicTacToe();
	}

}
