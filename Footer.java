/*

Stallings, Joshua
COP-3252
Project 1
2/12/2016
*/

import javax.swing.JFrame; // for testing
import javax.swing.JLabel; // for my name
import javax.swing.JPanel; // JLabel stuck on here
import javax.swing.SwingConstants;

// class Footer displays my name
public class Footer  // extends JFrame
{
    // instance variables
    private static final String name_ = "Josh Stallings";
    private static JLabel nLabel_;
    private JPanel f;
    
    // Footer constructor
    public Footer()
    {
	f = new JPanel();
    	f.setSize( 400, 100);
	nLabel_ = new JLabel(name_, SwingConstants.CENTER);
	f.add(nLabel_, 0);
	f.setVisible(true);
	
    }; // end Footer constructor

    public static void main(String args[]) 
    {
	Footer footer = new Footer();
	JFrame tf = new JFrame();
	tf.setDefaultCloseOperation(tf.EXIT_ON_CLOSE);
	tf.add(footer.f);
	tf.setSize(400, 100);
	tf.setVisible(true);

    } // end main

    // methods
    
    public JPanel displayName() 
    {
	return f;
    }; // end class displayName
    
    // ************************************************************************
    // eventually could have a reset button?, whether players are human or not?
    // ... who's turn it is ... , tabs on top...
    // ************************************************************************

}; // end class Footer
