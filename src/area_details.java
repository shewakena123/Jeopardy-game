import java.awt.Font;

import javax.swing.JTextArea;

public class area_details extends JTextArea{
	public area_details(){
		setWrapStyleWord(true);
		setLineWrap(true);
		setOpaque(false);
		setEditable(false);
		setFocusable(false);
		setBounds(250, 50, 900,100);
		setFont(new Font( "Tahoma", Font.BOLD, 20));
	}
	public area_details(int x, int y, int width, int height){
		setWrapStyleWord(true);
		setLineWrap(true);
		setOpaque(false);
		setEditable(false);
		setFocusable(false);
		setBounds(x, y, width, height);
		setFont(new Font( "Tahoma", Font.BOLD, 40));
	}
}



