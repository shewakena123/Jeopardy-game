import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class checkIt {
	static StartGame s = new StartGame();
	private static game newGame;
	private static String Identifier, questionValue;
	private static JLabel[] labels;
	private static int teamNumber;
	private static JLabel teamOne, teamTwo, teamThree, teamFour, teamFive;
	public checkIt(){
	}
	public void setTeamScore(String questionValue, int x){
		teamNumber = x;
		if (teamNumber == 1){
			teamOne.setText(questionValue);
		}
		if (teamNumber == 2){
			teamTwo.setText(questionValue);
		}
		if (teamNumber == 3){
			teamThree.setText(questionValue);
		}
		if (teamNumber == 4){
			teamFour.setText(questionValue);
		}
		if (teamNumber == 5){
			teamFive.setText(questionValue);
		}
	}
	public void setQuestionValue(String questionValue){
		this.questionValue = questionValue;
	}
	public int getNumOfTeams(){
		return s.getNumOfTeams();
	}
	public static void man(){
		newGame = new game();
		try {
			newGame.gameBoard();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private  static class game extends JFrame implements ActionListener{
		private static button_details categoryOne, categoryTwo, categoryThree, categoryFour,
		categoryFive, categoryOneForOne,categoryTwoForOne, categoryThreeForOne, 
		categoryFourForOne, categoryFiveForOne, categoryOneForTwo, categoryOneForThree, 
		categoryOneForFour, categoryOneForFive, categoryOneForSix, categoryTwoForTwo, categoryTwoForThree, categoryTwoForFour,
		categoryTwoForFive, categoryThreeForTwo, categoryThreeForThree, categoryThreeForFour, categoryThreeForFive,
		categoryFourForTwo, categoryFourForThree, categoryFourForFour, categoryFourForFive, categoryFiveForTwo,
		categoryFiveForThree, categoryFiveForFour,  categoryFiveForFive,categoryTwoForSix,categoryThreeForSix,
		categoryFiveForSix, categoryFourForSix;	
		private static JPanel scoreboard;
		private static JLabel score;
		private static start_details gameBoard;


		public game(){
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
			categoryOneForSix = new button_details("1000");
			categoryTwoForOne = new button_details("100");
			categoryTwoForTwo = new button_details("200");
			categoryTwoForThree = new button_details("300");
			categoryTwoForFour = new button_details("400");
			categoryTwoForFive = new button_details("500");
			categoryTwoForSix = new button_details("1000");
			categoryThreeForOne = new button_details("100");
			categoryThreeForTwo = new button_details("200");
			categoryThreeForThree = new button_details("300");
			categoryThreeForFour = new button_details("400");
			categoryThreeForFive = new button_details("500");
			categoryThreeForSix = new button_details("1000");
			categoryFourForOne = new button_details("100");
			categoryFourForTwo = new button_details("200");
			categoryFourForThree = new button_details("300");
			categoryFourForFour = new button_details("400");
			categoryFourForFive = new button_details("500");
			categoryFourForSix = new button_details("1000");
			categoryFiveForOne = new button_details("100");	
			categoryFiveForTwo = new button_details("200");	
			categoryFiveForThree = new button_details("300");	
			categoryFiveForFour = new button_details("400");	
			categoryFiveForFive = new button_details("500");	
			categoryFiveForSix = new button_details("1000");

			teamOne = new score_details();
			teamTwo = new score_details();
			teamThree = new score_details();
			teamFour = new score_details();
			teamFive = new score_details();
			categoryOneForOne.addActionListener(this);
			categoryOneForTwo.addActionListener(this);
			categoryOneForThree.addActionListener(this);
			categoryOneForFour.addActionListener(this);
			categoryOneForFive.addActionListener(this);
			categoryOneForSix.addActionListener(this);
			categoryTwoForOne.addActionListener(this);
			categoryTwoForTwo.addActionListener(this);
			categoryTwoForThree.addActionListener(this);
			categoryTwoForFour.addActionListener(this);
			categoryTwoForFive.addActionListener(this);
			categoryTwoForSix.addActionListener(this);
			categoryThreeForOne.addActionListener(this);
			categoryThreeForTwo.addActionListener(this);
			categoryThreeForThree.addActionListener(this);
			categoryThreeForFour.addActionListener(this);
			categoryThreeForFive.addActionListener(this);
			categoryThreeForSix.addActionListener(this);
			categoryFourForOne.addActionListener(this);
			categoryFourForTwo.addActionListener(this);
			categoryFourForThree.addActionListener(this);
			categoryFourForFour.addActionListener(this);
			categoryFourForFive.addActionListener(this);
			categoryFourForSix.addActionListener(this);
			categoryFiveForOne.addActionListener(this);
			categoryFiveForTwo.addActionListener(this);
			categoryFiveForThree.addActionListener(this);
			categoryFiveForFour.addActionListener(this);
			categoryFiveForFive.addActionListener(this);
			categoryFiveForSix.addActionListener(this);
			labels = new JLabel[5];
			scoreboard = new JPanel();

		}

		public void gameBoard() throws FileNotFoundException{	
			labels[0] = teamOne;
			labels[1] = teamTwo;
			labels[2] = teamThree;
			labels[3] = teamFour;
			labels[4] = teamFive;
			for(int i = 0; i < s.getNumOfTeams(); i++){	
				labels[i].setVisible(true);
				scoreboard.add(labels[i]);
			}		
			scoreboard.setLayout(null);
			score = new JLabel("SCORE:", SwingConstants.CENTER);
			score.setFont(new Font("Tahoma", Font.BOLD, 15));
			score.setBackground(Color.gray);
			score.setOpaque(true);
			score.setForeground(Color.green);
			teamOne.setBounds(220, 615, 80, 30);
			teamTwo.setBounds(305, 615, 80, 30);
			teamThree.setBounds(390, 615, 80, 30);
			teamFour.setBounds(475, 615, 80, 30);
			teamFive.setBounds(560, 615, 80, 30);
			categoryOne.setBounds(120, 5, 200, 80);
			categoryTwo.setBounds(340, 5, 200,80);
			categoryThree.setBounds(560, 5, 200, 80);
			categoryFour.setBounds(780, 5, 220, 80);
			categoryFive.setBounds(1020, 5, 220, 80);
			categoryOneForOne.setBounds(120, 100, 200, 70);
			categoryOneForTwo.setBounds(120, 185, 200, 70);
			categoryOneForThree.setBounds(120, 270, 200, 70);
			categoryOneForFour.setBounds(120, 355, 200, 70);
			categoryOneForFive.setBounds(120, 440, 200, 70);
			categoryOneForSix.setBounds(120, 525, 200, 70);
			categoryTwoForOne.setBounds(340, 100, 200, 70);
			categoryTwoForTwo.setBounds(340, 185, 200, 70);
			categoryTwoForThree.setBounds(340, 270, 200, 70);
			categoryTwoForFour.setBounds(340, 355, 200, 70);
			categoryTwoForFive.setBounds(340, 440, 200, 70);
			categoryTwoForSix.setBounds(340, 525, 200, 70);
			categoryThreeForOne.setBounds(560, 100, 200, 70);
			categoryThreeForTwo.setBounds(560, 185, 200, 70);
			categoryThreeForThree.setBounds(560, 270, 200, 70);
			categoryThreeForFour.setBounds(560, 355, 200, 70);
			categoryThreeForFive.setBounds(560, 440, 200, 70);
			categoryThreeForSix.setBounds(560, 525, 200, 70);
			categoryFourForOne.setBounds(780, 100, 220, 70);
			categoryFourForTwo.setBounds(780, 185, 220, 70);
			categoryFourForThree.setBounds(780, 270, 220, 70);
			categoryFourForFour.setBounds(780, 355, 220, 70);
			categoryFourForFive.setBounds(780, 440, 220, 70);
			categoryFourForSix.setBounds(780, 525, 220, 70);
			categoryFiveForOne.setBounds(1020, 100, 220, 70);
			categoryFiveForTwo.setBounds(1020, 185, 220, 70);
			categoryFiveForThree.setBounds(1020, 270, 220, 70);
			categoryFiveForFour.setBounds(1020, 355, 220, 70);
			categoryFiveForFive.setBounds(1020, 440, 220, 70);
			categoryFiveForSix.setBounds(1020, 525, 220, 70);
			score.setBounds(120, 615, 80, 30);
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
			scoreboard.add(categoryOneForSix);
			scoreboard.add(categoryFiveForFive);
			scoreboard.add(categoryFiveForFour);
			scoreboard.add(categoryFiveForThree);
			scoreboard.add(categoryFiveForTwo);
			scoreboard.add(categoryFiveForOne);
			scoreboard.add(categoryFiveForSix);
			scoreboard.add(categoryFourForFive);
			scoreboard.add(categoryFourForFour);
			scoreboard.add(categoryFourForThree);
			scoreboard.add(categoryFourForTwo);
			scoreboard.add(categoryFourForOne);
			scoreboard.add(categoryFourForSix);
			scoreboard.add(categoryThreeForFive);
			scoreboard.add(categoryThreeForFour);
			scoreboard.add(categoryThreeForThree);
			scoreboard.add(categoryThreeForTwo);
			scoreboard.add(categoryThreeForOne);
			scoreboard.add(categoryThreeForSix);
			scoreboard.add(categoryTwoForFive);
			scoreboard.add(categoryTwoForFour);
			scoreboard.add(categoryTwoForThree);
			scoreboard.add(categoryTwoForTwo);
			scoreboard.add(categoryTwoForOne);
			scoreboard.add(categoryTwoForSix);

			scoreboard.setBackground(Color.black);
			gameBoard = new start_details(1800,1800);
			gameBoard.setTitle("Jeopardy");
			gameBoard.getContentPane().add(scoreboard);


		}
		public void actionPerformed(ActionEvent e) {

			 Questions q = new Questions();

			if(e.getSource() == categoryOneForOne){
				questionValue = categoryOneForOne.getText();
				categoryOneForOne.setEnabled(false);
				Identifier = "people1";	
				}
			if(e.getSource() == categoryOneForTwo){
				questionValue = categoryOneForOne.getText();
				categoryOneForTwo.setEnabled(false);
				Identifier = "people2";	
				}
			if(e.getSource() == categoryOneForThree){
				questionValue = categoryOneForOne.getText();
				categoryOneForThree.setEnabled(false);
				Identifier = "people3";	
				}
			if(e.getSource() == categoryOneForFour){
				questionValue = categoryOneForOne.getText();
				categoryOneForFour.setEnabled(false);
				Identifier = "people4";	
				}
			if(e.getSource() == categoryOneForFive){
				questionValue = categoryOneForOne.getText();
				categoryOneForFive.setEnabled(false);
				Identifier = "people5";	
				}
			if(e.getSource() == categoryOneForSix){
				questionValue = categoryOneForOne.getText();
				categoryOneForSix.setEnabled(false);
				Identifier = "people6";	
				}
			if(e.getSource() == categoryTwoForOne){
				questionValue = categoryOneForOne.getText();
				categoryTwoForOne.setEnabled(false);
				Identifier = "places1";	
				}
			if(e.getSource() == categoryTwoForTwo){
				questionValue = categoryOneForOne.getText();
				categoryTwoForTwo.setEnabled(false);
				Identifier = "places2";	
				}
			if(e.getSource() == categoryTwoForThree){
				questionValue = categoryOneForOne.getText();
				categoryTwoForThree.setEnabled(false);
				Identifier = "place31";	
				}
			if(e.getSource() == categoryTwoForFour){
				questionValue = categoryOneForOne.getText();
				categoryTwoForFour.setEnabled(false);
				Identifier = "places4";	
				}
			if(e.getSource() == categoryTwoForFive){
				questionValue = categoryOneForOne.getText();
				categoryTwoForFive.setEnabled(false);
				Identifier = "places5";	
				}
			if(e.getSource() == categoryTwoForSix){
				questionValue = categoryOneForOne.getText();
				categoryTwoForSix.setEnabled(false);
				Identifier = "places6";	
				}
			if(e.getSource() == categoryThreeForOne){
				questionValue = categoryOneForOne.getText();
				categoryThreeForOne.setEnabled(false);
				Identifier = "verses1";	
				}
			if(e.getSource() == categoryThreeForTwo){
				questionValue = categoryOneForOne.getText();
				categoryThreeForTwo.setEnabled(false);
				Identifier = "verses2";	
				}
			if(e.getSource() == categoryThreeForThree){
				questionValue = categoryOneForOne.getText();
				categoryThreeForThree.setEnabled(false);
				Identifier = "verses3";	
				}
			if(e.getSource() == categoryThreeForFour){
				questionValue = categoryOneForOne.getText();
				categoryThreeForFour.setEnabled(false);
				Identifier = "verses4";	
				}
			if(e.getSource() == categoryThreeForFive){
				questionValue = categoryOneForOne.getText();
				categoryThreeForFive.setEnabled(false);
				Identifier = "verses5";	
				}
			if(e.getSource() == categoryThreeForSix){
				questionValue = categoryOneForOne.getText();
				categoryThreeForSix.setEnabled(false);
				Identifier = "verses6";	
				}
			if(e.getSource() == categoryFourForOne){
				questionValue = categoryOneForOne.getText();
				categoryFourForOne.setEnabled(false);
				Identifier = "ot1";	
				}
			if(e.getSource() == categoryFourForTwo){
				questionValue = categoryOneForOne.getText();
				categoryFourForTwo.setEnabled(false);
				Identifier = "ot2";	
				}
			if(e.getSource() == categoryFourForThree){
				questionValue = categoryOneForOne.getText();
				categoryFourForThree.setEnabled(false);
				Identifier = "ot3";	
				}
			if(e.getSource() == categoryFourForFour){
				questionValue = categoryOneForOne.getText();
				categoryFourForFour.setEnabled(false);
				Identifier = "ot4";	
				}
			if(e.getSource() == categoryFourForFive){
				questionValue = categoryOneForOne.getText();
				categoryFourForFive.setEnabled(false);
				Identifier = "ot5";	
				}
			if(e.getSource() == categoryFourForSix){
				questionValue = categoryOneForOne.getText();
				categoryFourForSix.setEnabled(false);
				Identifier = "ot6";	
				}
			if(e.getSource() == categoryFiveForOne){
				questionValue = categoryOneForOne.getText();
				categoryFiveForOne.setEnabled(false);
				Identifier = "nt1";	
				}
			if(e.getSource() == categoryFiveForTwo){
				questionValue = categoryOneForOne.getText();
				categoryFiveForTwo.setEnabled(false);
				Identifier = "nt2";	
				}
			if(e.getSource() == categoryFiveForThree){
				questionValue = categoryOneForOne.getText();
				categoryFiveForThree.setEnabled(false);
				Identifier = "nt3";	
				}
			if(e.getSource() == categoryFiveForFour){
				questionValue = categoryOneForOne.getText();
				categoryFiveForFour.setEnabled(false);
				Identifier = "nt4";	
				}
			if(e.getSource() == categoryFiveForFive){
				questionValue = categoryOneForOne.getText();
				categoryFiveForFive.setEnabled(false);
				Identifier = "nt5";	
				}
			if(e.getSource() == categoryFiveForSix){
				questionValue = categoryOneForOne.getText();
				categoryFiveForSix.setEnabled(false);
				Identifier = "nt6";	
				}
			
				try {
					q.theLabel(Identifier, questionValue);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
			}

		}		
	} 


