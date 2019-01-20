import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*This display contains a 3x3 grid of JButtons inside a JPanel. 
This class is designed for the TicTacToe board. It holds the set board method and the implements the action listener
made by Brandon Quirin: 1310906 */


public class Board extends JFrame implements ActionListener
{

	public static JButton buttons[] = new JButton[9];  
	//9 buttons
	public static int PlayerCount = 0;
	public static boolean PlayerFirst; 
 

//----------------------------------------------------------------------SET BOARD METHOD----------------------------------------------------------------//	
	public void MSetBoard() 
	{ 
		setTitle("TicTacToe - 1310906 © Brandon Inc™. 2016"); 
		//super refers to the constructor inside the class
		setVisible(true); 
		setSize(500,500); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false); 
		// The above code sets out the JFrame. 
		
		JPanel panel = new JPanel(); 
		panel.setLayout(new GridLayout(3,3)); 
		for(int count = 0; count<9; count++)
		{ 
			buttons[count] = new JButton();  
			// declaring the buttons object 
			panel.add(buttons[count]);
			buttons[count].addActionListener(this);
			buttons[count].setText(".");
			buttons[count].setFont(new Font("Times New Romans", Font.BOLD, 20));
			buttons[count].setForeground(Color.WHITE);
			buttons[count].setBackground(Color.BLACK); 
			buttons[count].setBorder(BorderFactory.createLineBorder(Color.white,3));
		}
		add(panel); 
		// This loop is designed to set the layout of the panel to a 3x3 grid
		//it adds the jbutton to the panel and the action listener to each button individually 
		// It adds a full stop to each buttons sets the font type in each button 
		// this; refers to the current object   
		// Finally it adds the panel to the Jframe 
	} 
//=======================================================================================================================================================//
	
//---------------------------------------------------------------ACTION PERFORMED METHOD-----------------------------------------------------------------//	
	public void actionPerformed(ActionEvent response) 
	{
		Object click = response.getSource(); 
		//response is the action event 
		//get source is where the button is pressed 

		for(int counter= 0 ; counter <buttons.length; counter++)
		{
			if(Logic.MTurn(PlayerCount)== true)
			{
				if(click == buttons[counter]) 
				{
					if(Logic.MErrorHandling(counter) == true)break;
					Logic.MPlayerSettings("X", counter);
				}
			}
			else
			{
				if(click == buttons[counter]) 
				{
					if(Logic.MErrorHandling(counter) == true)break;
					Logic.MPlayerSettings("O", counter);
				}
			}
		
			Logic.MWin("X");
			Logic.MWin("O");
			Logic.MDraw(PlayerCount);

		}
	}
	/*This loops until all 9 moves have been made. This commences when a button is clicked
	if 1st,3rd,5th,7th go then X 
	if 2nd,4th,6th, 8th go the O  
	if the button  has O or X inside it then dialog box comes up and says choose another buttons 
	Opens a dialog box in the event that an X or O is pressed again 
	stops the letter from changing to other letter*/
//=======================================================================================================================================================//
}
