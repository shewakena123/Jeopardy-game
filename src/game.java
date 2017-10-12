import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class game extends JFrame implements ActionListener{
	private static button_details categoryOne, categoryTwo, categoryThree, categoryFour,
	categoryFive, categoryOneForOne,categoryTwoForOne, categoryThreeForOne, 
	categoryFourForOne, categoryFiveForOne, categoryOneForTwo, categoryOneForThree, 
	categoryOneForFour, categoryOneForFive;	
	private static game newGame;
	private static JPanel scoreboard;
	private static JLabel score;
	private static String Identifier, point;
	private static JLabel[] labels;
	private static int scoreboardDimension = 220, numberOfTeams;
	static StartGame s = new StartGame();
	public game(){
		super("Jeopardy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setSize(1800,1800);
		setLocationRelativeTo(null);
		setVisible(true);	
		setBackground(Color.black);

		categoryOneForOne.addActionListener(this);
		categoryOneForTwo.addActionListener(this);
		categoryOneForThree.addActionListener(this);
		categoryOneForFour.addActionListener(this);
		categoryOneForFive.addActionListener(this);
	}
	
	public static void gameBoard(int numOfTeams) throws FileNotFoundException{	
		numberOfTeams = s.getNumOfTeams();
		labels = new JLabel[5];
		scoreboard = new JPanel();
		for(int i = 0; i < numberOfTeams; i++){
			labels[i] = new JLabel("", SwingConstants.CENTER);
			labels[i].setFont(new Font("Tahoma", Font.BOLD, 15));
			labels[i].setText(String.valueOf(0));
			labels[i].setBounds(scoreboardDimension, 600, 80, 30);
			labels[i].setBackground(Color.white);
			labels[i].setForeground(Color.black);
			labels[i].setOpaque(true);
			scoreboard.add(labels[i]);
			scoreboardDimension = scoreboardDimension + 85;
		}
		scoreboard.setLayout(null);
		score = new JLabel("SCORE:", SwingConstants.CENTER);
		score.setFont(new Font("Tahoma", Font.BOLD, 15));
		categoryOne = new button_details("PEOPLE");
		categoryTwo = new button_details("VERSES");
		categoryThree = new button_details("PLACES");
		categoryFour = new button_details("OLD TESTAMENT");
		categoryFour.setText("<html><center>"+"OLD"+"<br>"+"TESTAMENT"+"</center></html>");
		categoryFive = new button_details("NEW TESTAMENT");
		categoryFive.setText("<html><center>"+"NEW"+"<br>"+"TESTAMENT"+"</center></html>");

		categoryOneForOne = new button_details("100");
		categoryOneForTwo = new button_details("200");
		categoryOneForThree = new button_details("300");
		categoryOneForFour = new button_details("400");
		categoryOneForFive = new button_details("500");
		categoryTwoForOne = new button_details("100");
		categoryThreeForOne = new button_details("100");
		categoryFourForOne = new button_details("100");
		categoryFiveForOne = new button_details("100");		
		score.setBackground(Color.gray);
		score.setOpaque(true);
		score.setForeground(Color.green);
		categoryOne.setBounds(120, 5, 200, 80);
		categoryTwo.setBounds(340, 5, 200,80);
		categoryThree.setBounds(560, 5, 200, 80);
		categoryFour.setBounds(780, 5, 220, 80);
		categoryFive.setBounds(1020, 5, 220, 80);
		categoryOneForOne.setBounds(120, 100, 200, 80);
		categoryOneForTwo.setBounds(120, 200, 200, 80);
		categoryOneForThree.setBounds(120, 300, 200, 80);
		categoryOneForFour.setBounds(120, 400, 200, 80);
		categoryOneForFive.setBounds(120, 500, 200, 80);
		categoryTwoForOne.setBounds(340, 100, 200, 80);
		categoryThreeForOne.setBounds(560, 100, 200, 80);
		categoryFourForOne.setBounds(780, 100, 220, 80);
		categoryFiveForOne.setBounds(1020, 100, 220, 80);
		score.setBounds(120, 600, 80, 30);
		scoreboard.add(score);
		scoreboard.add(categoryOne);
		scoreboard.add(categoryTwo);
		scoreboard.add(categoryThree);
		scoreboard.add(categoryFour);
		scoreboard.add(categoryFive);
		scoreboard.add(categoryOneForOne);
		scoreboard.add(categoryOneForTwo);
		scoreboard.add(categoryOneForThree);
		scoreboard.add(categoryOneForFour);
		scoreboard.add(categoryOneForFive);
		scoreboard.add(categoryTwoForOne);
		scoreboard.add(categoryThreeForOne);
		scoreboard.add(categoryFourForOne);
		scoreboard.add(categoryFiveForOne);
		scoreboard.setBackground(Color.black);
		newGame = new game();
		newGame.getContentPane().add(scoreboard);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		newGame.setVisible(false);
		if(e.getSource() == categoryOneForOne){
			point = categoryOneForOne.getText();
			categoryOneForOne.setEnabled(false);
			Identifier = "people1";	
			//q.getQuestion(Identifier);	
			}
	//	newGame.setVisible(true);
	}
	Questions q = new Questions();
}