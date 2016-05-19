/*
  Stallings, Joshua
  COP-3252
  Project 1
  2/6/2016

  Driver for Tic-Tac-Nole Program

  Sources: 
  For using BoxLayout: 
    http://stackoverflow.com/questions/761341/boxlayout-cant-be-shared-error
    https://docs.oracle.com/javase/tutorial/uiswing/layout/using.html
    https://docs.oracle.com/javase/7/docs/api/java/awt/
      LayoutManager.html#addLayoutComponent
      (java.lang.String,%20java.awt.Component)
    https://docs.oracle.com/javase/7/docs/api/javax/swing/BoxLayout.html
    https://docs.oracle.com/javase/tutorial/uiswing/layout/box.html
  For logic:
    https://www.youtube.com/watch?v=R51BIlAt_Hg&feature=youtu.be

*/ 

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.Container;
import java.awt.Component;
import java.lang.Integer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoleDriver 
{
    private int winner_ ; // indicates who won

    private int turn_ ; // which player's turn it is
    // 1 for X
    // 2 for O

    private int xWins_; // tally of # of wins
    private int oWins_; // tally of # of wins

    private Frame frame_ = new Frame();
 ; 
    private Footer footer_; 

    private int playing_; // indicates whether to play again or exit
    // 1 == playing
    // 0 == exit
 
    public static void main (String[] args)
    {
	JFrame jframe_ = new JFrame("Tic Tac Toe");
	jframe_.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jframe_.setLayout(new BoxLayout
			  (jframe_.getContentPane(), BoxLayout.Y_AXIS));

	NoleDriver nd = new NoleDriver();
	jframe_.add(nd.GetFrame().GetPanel());
	jframe_.add(nd.GetFooter().displayName());
	jframe_.setSize(400, 300);
	jframe_.setVisible(true); 
	while(nd.GetPlaying() == 1)
	    {

		for (int i = 0; i < 9; ++i)
		    {
			nd.frame_.GetSquare(i).SetTurn(nd.turn_);
		    } 
		nd.Check(nd.frame_);

	    };
	nd.Exit();
	
    } // end main
    

    public NoleDriver()
    {
	playing_ = 1;
	// invariant: frame_ has been created
	// invariant: frame_'s panel has been created.
	footer_ = new Footer();
	winner_ = 0;
	turn_ = 1; 
	xWins_ = 0;
	oWins_ = 0;
	
	// create and register listener for mouse events
	ActionHandler Driverhandler = new ActionHandler();

	for (int i = 0; i < 9 ; ++i)
	    {
		frame_.GetSquare(i).addActionListener(Driverhandler);
	    }
    };

    // *******
    // Setters
    // *******

    public void SetFooter(Footer fo)
    {
	footer_ = fo;
    }

    public void SetFrame(Frame fr)
    {
	frame_ = fr;
    }

    public void SetPlaying(int pl)
    {
	playing_ = pl;
    }

    // *******
    // Getters
    // *******

    public Footer GetFooter()
    {
	return footer_;
    }

    public Frame GetFrame()
    {
	return frame_;
    }
    
    public int GetPlaying()
    {
	return playing_;
    }

    // *******
    // Other Methods
    // *******
    
    public void Check(Frame frame)
    {
	// check perpendicular victory
	if( (frame_.GetSquare(0).GetMove() != 0) 
	    && ( frame_.GetSquare(0).GetMove() 
		 == frame_.GetSquare(3).GetMove() ) 
	    && ( frame_.GetSquare(0).GetMove() 
		 == frame_.GetSquare(6).GetMove() ) ) // 036
	    {
		Win(frame_.GetSquare(0).GetMove());
		return;
	    }
	else if(
		(frame_.GetSquare(0).GetMove() != 0) 
		&& ( frame_.GetSquare(0).GetMove() 
		     == frame_.GetSquare(1).GetMove() ) 
		&& ( frame_.GetSquare(0).GetMove() 
		     == frame_.GetSquare(2).GetMove() )
		) // 012
	    {
		Win(frame_.GetSquare(0).GetMove());
		return;
	    }
	else if(
		(frame_.GetSquare(1).GetMove() != 0) 
		&& ( frame_.GetSquare(1).GetMove() 
		     == frame_.GetSquare(4).GetMove() ) 
		&& ( frame_.GetSquare(1).GetMove() 
		     == frame_.GetSquare(7).GetMove() ) 
		) // 147
	    {
		Win(frame_.GetSquare(1).GetMove());
		return;
	    }
	else if(
		(frame_.GetSquare(3).GetMove() != 0) 
		&& ( frame_.GetSquare(3).GetMove() 
		     == frame_.GetSquare(4).GetMove() ) 
		&& ( frame_.GetSquare(3).GetMove() 
		     == frame_.GetSquare(5).GetMove() )
		) // 345
	    {
		
		Win(frame_.GetSquare(3).GetMove());
		return;
	    }
	else if(
		(frame_.GetSquare(6).GetMove() != 0)
		&& ( frame_.GetSquare(6).GetMove() 
		     == frame_.GetSquare(7).GetMove() ) 
		&& ( frame_.GetSquare(6).GetMove() 
		     == frame_.GetSquare(8).GetMove() ) 
		) // 678
	    {
		Win(frame_.GetSquare(6).GetMove());
		return;
	    }
	else if(
		(frame_.GetSquare(2).GetMove() != 0) 
		&& ( frame_.GetSquare(2).GetMove() 
		     == frame_.GetSquare(5).GetMove() ) 
		&& ( frame_.GetSquare(2).GetMove() 
		     == frame_.GetSquare(8).GetMove() )
		) // 258
	    {
		Win(frame_.GetSquare(2).GetMove());
		return;
	    }
	
	// check diagonal victory
	else if(
		(frame_.GetSquare(0).GetMove() != 0) 
		&& ( frame_.GetSquare(0).GetMove() 
		     == frame_.GetSquare(4).GetMove() ) 
		&& ( frame_.GetSquare(0).GetMove() 
		     == frame_.GetSquare(8).GetMove() )
		
		) // 048
	    {
		Win(frame_.GetSquare(0).GetMove());
		return;
	    }
	else if(
		(frame_.GetSquare(6).GetMove() != 0) 
		&& ( frame_.GetSquare(6).GetMove() 
		     == frame_.GetSquare(4).GetMove() ) 
		&& ( frame_.GetSquare(6).GetMove() 
		     == frame_.GetSquare(2).GetMove() )
		
		) // 642
	    {
		Win(frame_.GetSquare(6).GetMove());
		return;
	    }
	
    } // end Check method

    public void Exit()
    {
	
    }

    public void ResetAll()
    {
	frame_.ResetBoard();
	xWins_ = 0; // reset wins
	oWins_ = 0; // Later on, may want a reset button in footer perhaps?
    }; // end NoleDriver ResetBoard 

    public int Win(int winner)
    {
 	// display that someone won and who did
	// ++ tally of whichever player won

	winner_ = winner;
	if(winner == 1)
	    {
		++xWins_;
	    }
	else
	    {
		++oWins_;
	    }
	String playingTS;
	int playingTemp;
	playingTS = JOptionPane.showInputDialog("Play again?: (yes or no)");
	if ( playingTS.equals("No") || playingTS.equals("no") 
	     || playingTS.equals("n"))
	    {
		SetPlaying(0 );
		return winner;
	    } else 
	    {
		SetPlaying(1 );
		frame_.ResetBoard(); 
		return winner;
	    }
    };
    
    // ***************
    // Internal Helper
    // ***************

    private class ActionHandler implements ActionListener
    {
	// ActionListener event handlers
	// handle event when  mouse is pressed

	public void actionPerformed( ActionEvent event)
	{
	    turn_ = turn_ + 1;
	    if (turn_ == 3)
		turn_ = 1;
	}   
    } // end inner class ActionHandler

} // end class NoleDriver



