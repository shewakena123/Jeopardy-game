import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class button_details extends JButton {
		private Color normalColor = Color.BLUE;
	    private static int x,y,length,width;
	    private  static JTextArea textArea;

	 public button_details (String text) {
	        super(text);
	        setBorderPainted(false);
	        setOpaque(true);
	        setBackground(normalColor);
	        setForeground(Color.ORANGE);
	        setText(text);
	        setFont(new Font("Tahoma", Font.BOLD, 30));
	        setBounds(x,y,length,width);
}
public button_details(){
	setBackground(Color.BLUE);
	setForeground(Color.white);
	setBorderPainted(false);
	setOpaque(true);
	setBounds(700, 290, 100, 40);
}
}
