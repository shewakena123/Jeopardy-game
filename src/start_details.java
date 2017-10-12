import java.awt.Color;

import javax.swing.JFrame;

public class start_details extends JFrame{
	public start_details(){
		setTitle("Jeopardy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setSize(400,400);
		setLocationRelativeTo(null);
		setVisible(true);	
		setBackground(Color.black);
	}
	public start_details(int x, int y){
		setTitle("Question");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setSize(x,y);
		setLocationRelativeTo(null);
		setVisible(true);	
		setBackground(Color.black);
		
	}
}
