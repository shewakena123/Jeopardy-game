import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class score_details extends JLabel {
	public score_details(){
		setFont(new Font("Tahoma", Font.BOLD, 15));
		setText(String.valueOf(0));
		//setBounds(scoreboardDimension, 600, 80, 30);
		setBackground(Color.white);
		setForeground(Color.black);
		setOpaque(true);
		setHorizontalAlignment(SwingConstants.CENTER);
		setVisible(false);
	}
}
