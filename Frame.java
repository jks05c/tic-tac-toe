/*
  Stallings, Joshua
  COP-3252
  Project 1
  2/6/2016
  
  Frame for Tic Tac Nole Program. This attaches the 9 Squares 
  to their corresponding slots and handles most methods 
  that require access to more than one square.  
  
*/

import java.awt.GridLayout; // layout for Squares JPanel
import javax.swing.JFrame; // the frame around the grid
import javax.swing.JPanel; // for grid
import javax.swing.BoxLayout;

public class Frame 
{
    private JPanel p; // for the 9 squares
    private Square square[]; 
  
    public static void main (String args[])
    { 
	Frame fr = new Frame(); 
	JFrame test = new JFrame();
	test.add(fr.GetPanel());
	test.setVisible(true);
    }

    public Frame()
    {
	square = new Square[9]; // initializes the 9 squares
	p = new JPanel();
 	p.setLayout(new GridLayout(3,3,5,5));
	for (int i = 0; i < 9; ++i)
	    {
		square[i] = new Square();
		p.add(square[i], i);
		 square[i].setVisible(true);
	    } 
	p.setVisible(true);
    }

    public JPanel GetPanel()
    {
	return p;
    }

    public Square GetSquare(int i)
    {
	return square[i];
    }
    public void ResetBoard() // does not reset wins
    {
	for (int i = 0; i < 9; ++i)
	    {
		square[i].setIcon(null);
		square[i].ResetButton();
	    } // reset and reinitialize board 
    }; // end Frame ResetBoard
}
