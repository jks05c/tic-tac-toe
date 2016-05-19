/*
  Stallings, Joshua
  COP-3252
  Project 1
  2/6/2016

  JButton with statefulness remembering who pushed it.  
*/

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame; // for testing

public class Square extends JButton implements ActionListener
{

    private int turn_;
    private ImageIcon X, O;
    private int owner_;
    
    // 0 == noone
    // 1 == X
    // 2 == 0

    public static void main (String args[])
    {
	JFrame tf = new JFrame() ; 	
	Square s = new Square(); // create a Square
	
	tf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE); 
	tf.setSize( 400, 300); // set frame size
	tf.add(s); // add Square to the JFrame
	tf.setVisible(true);
		
    }
    public Square()
    {
	X = new ImageIcon( getClass().getResource("X_Tic-Tac-Toe_Token.gif"));
	O = new ImageIcon( getClass().getResource("O_Tic-Tac-Toe_Token.gif"));
	this.addActionListener(this);
	turn_ = 0;
	owner_ = 0;
    };

    public void SetTurn( int turn)
    {
	turn_ = turn;
    }

    public int GetMove()
    {
	return owner_;
    }

    public void ResetButton()
    {
	owner_ = 0;
    }
    
    public void actionPerformed(ActionEvent e)
    {
	switch(turn_)
	    {
	    case 0:
		setIcon(null);
		owner_ = 0;
		break;
	    case 1:
		
		setIcon(X);
		owner_ = 1;
		break;
	    case 2:
		
		setIcon(O);
		owner_ = 2;
		break;
	    }
    } // end actionPerformed
    
   

} // end class Square
