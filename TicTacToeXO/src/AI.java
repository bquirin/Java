import java.awt.Font;
import java.util.Random;
import javax.swing.JOptionPane;
//made by Brandon Quirin: 1310906  
//This class was created for the computers AI. This is where the main part of the AI comes from. 
 
public class AI {
	public static int RandomPosition = 0;
//--------------------------------------------------------------RANDOM NUMBER GENERATOR METHOD-----------------------------------------------------------//
	public static void MRandomNumberGenerator() 
	{
		Random rand = new Random();
		RandomPosition = rand.nextInt(9);
	}  
	//This method generates a random number between 0 and 8 which is matches up with our buttons.
//=======================================================================================================================================================//
	
//--------------------------------------------------------------SET AI POSITION METHOD-------------------------------------------------------------------//
	public static void MSetAIPosition(String LetterValue) 
	{
		do
		{
			MRandomNumberGenerator();
		}while(Board.buttons[RandomPosition].getText() != "." && Board.PlayerCount != 9);

		if(Board.PlayerCount == 8 && LetterValue == "X")
		{
			if(Logic.MWin("O") == false)
			{
				Board.buttons[RandomPosition].setText(LetterValue);
				Board.buttons[RandomPosition].setFont(new Font("Times New Romans", Font.BOLD, 100));
				JOptionPane.showMessageDialog(null, "Computer has had it's go!");
				Board.PlayerCount++;
			}
		}
		else if(Board.buttons[RandomPosition].getText() == "."  && Board.PlayerCount != 9)
		{
			Board.buttons[RandomPosition].setText(LetterValue);
			Board.buttons[RandomPosition].setFont(new Font("Times New Romans", Font.BOLD, 100));
			JOptionPane.showMessageDialog(null, "Computer has had it's go!");
			Board.PlayerCount++;
		}
	} 
//=======================================================================================================================================================//
	
//--------------------------------------------------------------START AI METHOD--------------------------------------------------------------------------//
	public static void MStartAI(boolean PlayerFirst) 
	{

		MRandomNumberGenerator();
		if(PlayerFirst == true)
		{
			MSetAIPosition("O");
		}
		else
		{
			MSetAIPosition("X");
		}
	} 
	//This method starts the AI.
//=======================================================================================================================================================//
}
