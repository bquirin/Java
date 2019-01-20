import java.awt.Font;
import java.util.Random;

import javax.swing.JOptionPane;

//made by Brandon Quirin: 1310906  
//This class was designed for running the game.
public class GameRunner {
	
	public static Board Window = new Board();
	//global variables and object
//-------------------------------------------------------------------------MAIN METHOD-------------------------------------------------------------------//
	public static void main(String[] args) 
	{ 
		//This class runs the game.

		Object[] Options = new String[]{"Player","Computer"};
		Object SelectedOption = JOptionPane.showInputDialog(null, "Select Who goes first", "Settings", JOptionPane.INFORMATION_MESSAGE, null, Options, Options[0]);
		Random rand = new Random();
		int RandomPosition = rand.nextInt(9);
		if(SelectedOption == "Player")
		{
			Board.PlayerFirst = true;
			Window.MSetBoard();
		}
		else if(SelectedOption == "Computer")
		{
			Board.PlayerFirst = false;
			Window.MSetBoard();
			Board.buttons[RandomPosition].setText("X");
			Board.buttons[RandomPosition].setFont(new Font("Times New Romans", Font.BOLD, 100));
			JOptionPane.showMessageDialog(null, "Computer has had it's go!");
			Board.PlayerCount++;
		}
		else System.exit(0);

	}
//=======================================================================================================================================================//
}
