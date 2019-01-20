import java.awt.Font;
import java.util.Random;

import javax.swing.JOptionPane;
//made by Brandon Quirin: 1310906  
//This class was designed for game logic. It contains some necessary functions like resetGame,win(),draw, etc.

public class Logic  
{

//---------------------------------------------------------------------------WINNING COMBO--------------------------------------------------------------//
		static int[][] winCombo = new int[][]
		{
			{0,1,2},{3,4,5},{6,7,8},//Horizontal
			{0,3,6},{1,4,7},{2,5,8},//Vertical
			{0,4,8},{2,4,6}//Diagonal
		}; 
//======================================================================================================================================================//
	
//------------------------------------------------------------------------TURN METHOD-------------------------------------------------------------------//
	public static boolean MTurn(int number)
	{ 

		if(number % 2 == 0)
		{ 
			return true; 
		}
		else 
		{ 
			return false;
		}
	} 
//======================================================================================================================================================//

//------------------------------------------------------------------------WIN METHOD--------------------------------------------------------------------//
	public static boolean MWin(String LetterCheck)
	{
		String FirstPos = null;
		String SecondPos = null;
		String ThirdPos = null;
		for(int i = 0; i<winCombo.length;i++)
		{
			FirstPos = Board.buttons[winCombo[i][0]].getText();
			SecondPos = Board.buttons[winCombo[i][1]].getText();
			ThirdPos = Board.buttons[winCombo[i][2]].getText();
			if(FirstPos == LetterCheck && SecondPos == LetterCheck && ThirdPos == LetterCheck)
			{
				if(JOptionPane.showConfirmDialog(null, LetterCheck + " Is the Winner! Rematch?","Winner!",0) == JOptionPane.YES_OPTION)
				{
					MResetGame();
				}
				else
				{
					System.exit(0);
				}
				return true;
			}
		}
		return false;
	} 
//======================================================================================================================================================//	
	
//------------------------------------------------------------------DRAW METHOD-------------------------------------------------------------------------//
	public static void MDraw(int count)
	{

		if(count == 9)
		{
			if(JOptionPane.showConfirmDialog(null, "It was a draw, do you want to rematch","Draw!",0) == JOptionPane.YES_OPTION)
			{
				MResetGame();
			}
			else
			{
				System.exit(0);
			}
		}

	} 
//======================================================================================================================================================//
	
//-----------------------------------------------------------------RESET GAME METHOD--------------------------------------------------------------------//
	public static void MResetGame()
	{
		Random rand = new Random();
		int RandomPosition = rand.nextInt(8);
		for(int i = 0; i<Board.buttons.length;i++)
		{
			Board.buttons[i].setText(".");
			Board.buttons[i].setFont(new Font("Times New Romans", Font.BOLD, 20));
			Board.PlayerCount = 0;
		}
		if(Board.PlayerFirst == false)
		{
			Board.buttons[RandomPosition].setText("X");
			Board.buttons[RandomPosition].setFont(new Font("Times New Romans", Font.BOLD, 100));
			JOptionPane.showMessageDialog(null, "Computer has had it's go!");
			Board.PlayerCount++;
		}
	}
//======================================================================================================================================================//
	
//------------------------------------------------------Player Settings Method--------------------------------------------------------------------------//

	public static void MPlayerSettings(String letterValue,int counter)
	{
		Board.buttons[counter].setText(letterValue);
		Board.buttons[counter].setFont(new Font("Times New Romans", Font.BOLD, 100));
		JOptionPane.showMessageDialog(null, "Player has had it's go!");
		Board.PlayerCount++;
		if(Logic.MWin(letterValue) == false)
		{
			AI.MStartAI(Board.PlayerFirst);
		}
	} 
//======================================================================================================================================================//
	
//-----------------------------------------------------------Error Handling Method----------------------------------------------------------------------//
	public static boolean MErrorHandling(int counter)
	{
		if(Board.buttons[counter].getText() == "O"||Board.buttons[counter].getText() == "X")
		{
			JOptionPane.showMessageDialog(null, "Choose another button","ERROR",JOptionPane.OK_OPTION);
			return true; 
		}
		else return false;
	} 
//======================================================================================================================================================//
}
