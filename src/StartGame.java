import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StartGame extends JFrame {
	private	static JButton teamSelectionButton;
	private static JPanel startScreen;
	private static JComboBox<Integer> myNumbers;
	private static int numOfTeams;
	private  static JTextArea textArea, area,teamField ;
	private  static JTextField field;
	private static start_details s;

	/**
	 * this is the constructor. it is going to create a jframe and display it. It also adds listeners 
	 * to the buttons so that when they are pressed, they perform an action.
	 */
	public StartGame(){
	}

	public static void main(String[] args) {
		try {
			play();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void setNumOfTeams(int numOfTeams){
		StartGame.numOfTeams = numOfTeams;
	}
	public int getNumOfTeams(){
		return this.numOfTeams;
	}
	public static void play()throws FileNotFoundException{
		myNumbers = new JComboBox<Integer>();	
		myNumbers.setForeground(Color.red);
		teamSelectionButton = new JButton("SUBMIT");
		teamSelectionButton.setBounds(155, 340, 100, 30);
		teamSelectionButton.setForeground(Color.blue);
		myNumbers.setBounds(50, 340, 100, 30);
		myNumbers.addItem(1);
		myNumbers.addItem(2);
		myNumbers.addItem(3);
		myNumbers.addItem(4);
		myNumbers.addItem(5);
		teamField = new JTextArea();
		teamField.setBounds(30, 310, 320, 20);
		teamField.setText("Please select the number of teams to participate: ");
		teamField.setForeground(Color.red);
		teamField.setWrapStyleWord(true);
		teamField.setLineWrap(true);
		startScreen = new JPanel();
		startScreen.setLayout(null);
		area = new JTextArea();
		area.setBounds(0,0,400,400);
		area.setFont(new Font( "Tahoma", Font.BOLD, 80));
		area.setWrapStyleWord(true);
		area.setLineWrap(true);
		area.setText("Welcome to Bible Jeopardy");
		area.setBackground(Color.black);
		area.setForeground(Color.yellow);
		area.setEditable(false);
		area.add(teamField);
		area.add(myNumbers);
		area.add(teamSelectionButton);
		startScreen.add(area);
		s = new start_details();
		s.getContentPane().add(startScreen);
		teamSelectionButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == teamSelectionButton){
					numOfTeams = (int) myNumbers.getSelectedItem();
					setNumOfTeams(numOfTeams);
					checkIt.man();
						
					s.setVisible(false);
				}
			}
		});		
	}
}