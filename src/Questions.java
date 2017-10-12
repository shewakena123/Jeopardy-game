import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;
import javax.swing.text.*;

public class Questions extends JFrame implements ActionListener{
	static checkIt score = new checkIt();
	//static StartGame inTheGame = new StartGame();
	private static JPanel questionPanel;
	private static JTextArea textArea;
	private static Random randomGen;
	private static Scanner sc,sc3, sc2;
	private static int RandomChoiceIndex, numberOfQuestions, currentTeam = 1;
	private static JButton submitButton;
	private static JFrame frame;
	AutocompleteJComboBox combo;
	private static ArrayList<String> listOfQuestions, listOfAnswers, myWords;
	private static String qval, possibleQuestionAsked, possibleAnswerGiven, selectedAnswer, selectedQuestion;
	public Questions(){
		listOfQuestions = new ArrayList<String>();
		listOfAnswers = new ArrayList<String>();
		randomGen = new Random();
		submitButton = new button_details();
		submitButton.addActionListener(this);
	}
	public void theLabel(String identifier, String val) throws Exception{

		qval = val;
		try {
			sc = new Scanner(new File("questions"));
			sc2 = new Scanner(new File("answers"));
			sc3 = new Scanner(new File("codeAnswers"));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myWords = new ArrayList<String>();
		while(sc3.hasNext()){	
			String a = sc3.nextLine();
			String[] x = a.split("\\$ ");
			myWords.add(x[1]);
		}

		while(sc.hasNext()){	
			if(sc.next().equals(identifier)){
				possibleQuestionAsked = sc.nextLine();	
				listOfQuestions.add(possibleQuestionAsked);
			}
			numberOfQuestions = listOfQuestions.size() - 1;

		}
		while(sc2.hasNext()){	
			if(sc2.next().equals(identifier)){
				possibleAnswerGiven = sc2.next();
				listOfAnswers.add(possibleAnswerGiven);
			}
		}
		RandomChoiceIndex = randomGen.nextInt((numberOfQuestions - 0) + 1) + 0;
		selectedQuestion = listOfQuestions.get(RandomChoiceIndex);	
		selectedAnswer = listOfAnswers.get(RandomChoiceIndex);
		Thread d = new Thread(new Runnable(){
			@Override
			public void run() {

				StringSearchable searchable = new StringSearchable(myWords);

				combo = new AutocompleteJComboBox(searchable);
				questionPanel = new JPanel();
				questionPanel.setLayout(null);
				questionPanel.setBackground(Color.ORANGE);
				questionPanel.setSize(1800, 1800);
				textArea = new area_details();
				textArea.setText(selectedQuestion);
				submitButton.setText("SUBMItT");			
				combo.setBounds(475, 290, 200, 40);	
				combo.setEditable(true);
				questionPanel.add(textArea);
				questionPanel.add(submitButton);
				questionPanel.add(combo);
				frame = new start_details(1800,1800);
				frame.getContentPane().add(questionPanel);

			}		
		});
		d.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int numberOfTeams = score.getNumOfTeams();
		if(e.getSource() == submitButton){

			String answerProvide = (String) combo.getSelectedItem();
			String answerProvided = answerProvide.toLowerCase();
			if(answerProvided.equals(selectedAnswer)){
				int a = JOptionPane.showOptionDialog(null, "That is Correct!\n"+"The answer is: " + selectedAnswer, "Message", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
				if(a == JOptionPane.OK_OPTION){
					frame.dispose();
					score.setTeamScore(qval, currentTeam);
				}
			}
			else if((numberOfTeams > 0) && (!answerProvided.equals(selectedAnswer))){ 
				JOptionPane optionPane = new JOptionPane("The answer provided is incorrect!\n"+ "Next team please try!", JOptionPane.ERROR_MESSAGE);    
				JDialog dialog = optionPane.createDialog("Incorrect!");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
				numberOfTeams--;
			}
			else{
				JOptionPane optionPane = new JOptionPane("All teams have answered incorrectly!\n"+ "The correct answer is: "+ selectedAnswer , JOptionPane.ERROR_MESSAGE);    
				JDialog dialog = optionPane.createDialog("Incorrect!");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
			}
		}currentTeam++;
	}
}




































/*

public class Questions extends JFrame implements ActionListener{
	static StartGame s = new StartGame();
	static checkIt ss = new checkIt();
	private static Scanner sc, sc2;
	private static theQuestionAsked q;
	private static String qval, possibleQuestionAsked, possibleAnswerGiven, selectedQuestion, selectedAnswer, theQuestion, theAnswer, theResponse;
	private static ArrayList<String> listOfQuestions, listOfAnswers;
	private static int RandomChoiceIndex,currentTeamm, maxNumOfQuestions = 2, currentTeam = 0;
	private static Random randomGen;
	private static JTextArea textArea,answer;
	private static JButton submitButton,ok;
	private static JFrame f;
	private static JLabel label;

	private static JPanel questionPanel,p,panel_copy;


	public Questions(){
		submitButton = new button_details();		
		ok = new button_details("OK");
		textArea = new area_details();
		ok.addActionListener(this);
		listOfQuestions = new ArrayList<String>();
		listOfAnswers = new ArrayList<String>();
		String country[]={"India","Aus","U.S.A","England","Newzealand","aaaa","Inndia","Auss","Uw.S.A","Eengland","Newwzealand","aasaa",}; 
		submitButton.addActionListener(this);
		randomGen = new Random();
		try {
			sc = new Scanner(new File("questions"));
			sc2 = new Scanner(new File("answers"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void correct(){
		f = new JFrame();
		f.setTitle("Result");
		ok.setBounds(185, 90, 80, 25);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setSize(500,150);
		f.setBackground(Color.black);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		label = new JLabel();
		label.setBounds(100, 0, 420, 80);
		label.setText("That is incorrect!! Next team, please try.");	
		p = new JPanel();
		p.setLayout(null);
		p.setSize(500,150);	
		p.add(ok);
		p.add(label);
		f.getContentPane().add(p);
		ok.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == ok){
					f.setVisible(false);
				}
			}
		});		
	}
	public static void incorrect(){
		f = new JFrame();
		f.setTitle("Result");
		ok.setBounds(185, 90, 80, 25);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setSize(500,150);
		f.setBackground(Color.black);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		label = new JLabel();
		String text = "All Teams have answered incorrectly\n";
		text += "the correct answer is: \n" ;
		label.setBounds(100, 0, 420, 80);
		label.setText("<html> All Teams have answered incorrectly <br> the correct answer is: " + selectedAnswer + "</html>"); 
		p = new JPanel();
		p.setLayout(null);
		p.setSize(500,150);	
		p.add(ok);
		p.add(label);
		f.getContentPane().add(p);
		ok.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == ok){
					f.setVisible(false);
					//q.setVisible(false);
				}
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == submitButton){
			//String varName = (String)answerr.getSelectedItem();
			//String value = answerr.getSelectedItem().toString();
			//System.out.println(varName + "111"+value);
			theResponse = answer.getText().toLowerCase();
			if(theResponse.equals(selectedAnswer)){
				if(getCurrentTeam() == 0){ss.teamOneScore();}
				if(getCurrentTeam() == 1){ss.teamTwoScore();}
				if(getCurrentTeam() == 2){ss.teamThreeScore();}
				if(getCurrentTeam() == 3){ss.teamFourScore();}
				if(getCurrentTeam() == 4){ss.teamFiveScore();} 
				//q.setVisible(false);
				//q.dispose();
				//correct();
				//check.labels[currentTeam].setText(String.valueOf(point));
				//TQA.setVisible(false);
				//game.setVisible(true);
			}
			//while(currentTeamm < s.getNumOfTeams()){
			if(!theResponse.equals(selectedAnswer)){
				if (currentTeamm == s.getNumOfTeams() - 1){
					incorrect();
				}
				else{
					currentTeamm = currentTeamm + 1;
					setCurrentTeam(currentTeamm);	
					correct();
				}
			}


			//answerText.setText("place answer here");
			//	theResponse = answerText.getText().toLowerCase();
			//	currentTeam++;
		}
	}			
	public static void setCurrentTeam(int currentTeam){
		currentTeamm = currentTeam;
	}
	public static int getCurrentTeam(){
		return currentTeamm;
	}
	public static void doIt(String identifier, String val){
		qval = val;
		try {
			sc = new Scanner(new File("questions"));
			sc2 = new Scanner(new File("answers"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(sc.hasNext()){	
			if(sc.next().equals(identifier)){
				possibleQuestionAsked = sc.nextLine();	
				listOfQuestions.add(possibleQuestionAsked);
			}

		}
		while(sc2.hasNext()){	
			if(sc2.next().equals(identifier)){
				possibleAnswerGiven = sc2.next();	
				listOfAnswers.add(possibleAnswerGiven);
			}
		}	
		//	while(max >= 0){
		RandomChoiceIndex = randomGen.nextInt((maxNumOfQuestions - 0) + 1) + 0;
		selectedQuestion = listOfQuestions.get(RandomChoiceIndex);	
		listOfQuestions.remove(RandomChoiceIndex);
		selectedAnswer = listOfAnswers.get(RandomChoiceIndex);
		listOfAnswers.remove(RandomChoiceIndex);
		try {

			q.theLabel(selectedQuestion);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//800-872-2657
	}
	private static class theQuestionAsked extends PlainDocument implements ActionListener{
		//static StartGame s = new StartGame();
		static checkIt ss = new checkIt();
	//	private static theQuestionAsked q = new theQuestionAsked();
		private static JPanel questionPanel,p,panel_copy;
		private static JTextArea textArea,answer;
		private static JComboBox<String> answerr, box;
		private static JTextField answerText;
		private static JLabel label;
		private static JLabel labels[];
		private static JFrame f;
		private static int numOfTeams;
		private static String theQuestion, theAnswer, theResponse;
		private static JButton submitButton,ok;
		ComboBoxModel model;
		JTextComponent editor;
		boolean selecting=false;
	    boolean hidePopupOnFocusLoss;
		boolean hitBackspace=false;
		boolean hitBackspaceOnSelection;

			KeyListener editorKeyListener;
		    FocusListener editorFocusListener;

		public theQuestionAsked(JComboBox<String> comboBox){
			//questionPanel = new JPanel();
			submitButton = new button_details();

			//super("Question");
			box = comboBox;
	        model = comboBox.getModel();
	        comboBox.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                if (!selecting) highlightCompletedText(0);
	            }
	        });
	        comboBox.addPropertyChangeListener(new PropertyChangeListener() {
	            public void propertyChange(PropertyChangeEvent e) {
	                if (e.getPropertyName().equals("editor")) configureEditor((ComboBoxEditor) e.getNewValue());
	                if (e.getPropertyName().equals("model")) model = (ComboBoxModel) e.getNewValue();
	            }
	        });
	        editorKeyListener = new KeyAdapter() {
	            public void keyPressed(KeyEvent e) {
	                if (box.isDisplayable()) box.setPopupVisible(true);
	                hitBackspace=false;
	                switch (e.getKeyCode()) {
	                    // determine if the pressed key is backspace (needed by the remove method)
	                    case KeyEvent.VK_BACK_SPACE : hitBackspace=true;
	                    hitBackspaceOnSelection=editor.getSelectionStart()!=editor.getSelectionEnd();
	                    break;
	                    // ignore delete key
	                    case KeyEvent.VK_DELETE : e.consume();
	                    box.getToolkit().beep();
	                    break;
	                }
	            }
	        };
	     // Bug 5100422 on Java 1.5: Editable JComboBox won't hide popup when tabbing out
	        hidePopupOnFocusLoss=System.getProperty("java.version").startsWith("1.5");
	        // Highlight whole text when gaining focus
	        editorFocusListener = new FocusAdapter() {
	            public void focusGained(FocusEvent e) {
	                highlightCompletedText(0);
	            }
	            public void focusLost(FocusEvent e) {
	                // Workaround for Bug 5100422 - Hide Popup on focus loss
	                if (hidePopupOnFocusLoss) box.setPopupVisible(false);
	            }
	        };
	        configureEditor(comboBox.getEditor());
	        // Handle initially selected object
	        Object selected = comboBox.getSelectedItem();
	        if (selected!=null) setText(selected.toString());
	        highlightCompletedText(0);
	    }
		  public static void enable(JComboBox<String> comboBox) {
		        // has to be editable
		        box.setEditable(true);
		        // change the editor's document
		        new theQuestionAsked(box);
		    }

		    void configureEditor(ComboBoxEditor newEditor) {
		        if (editor != null) {
		            editor.removeKeyListener(editorKeyListener);
		            editor.removeFocusListener(editorFocusListener);
		        }

		        if (newEditor != null) {
		            editor = (JTextComponent) newEditor.getEditorComponent();
		            editor.addKeyListener(editorKeyListener);
		            editor.addFocusListener(editorFocusListener);
		            editor.setDocument(this);
		        }
		    }
		    public void remove(int offs, int len) throws BadLocationException {
		        // return immediately when selecting an item
		        if (selecting) return;
		        if (hitBackspace) {
		            // user hit backspace => move the selection backwards
		            // old item keeps being selected
		            if (offs>0) {
		                if (hitBackspaceOnSelection) offs--;
		            } else {
		                // User hit backspace with the cursor positioned on the start => beep
		                box.getToolkit().beep(); 
		                UIManager.getLookAndFeel().provideErrorFeedback(box);// when available use: UIManager.getLookAndFeel().provideErrorFeedback(comboBox);
		            }
		            highlightCompletedText(offs);
		        } else {
		            super.remove(offs, len);
		        }
		    }
		    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
		        // return immediately when selecting an item
		        if (selecting) return;
		        // insert the string into the document
		        super.insertString(offs, str, a);
		        // lookup and select a matching item
		        Object item = lookupItem(getText(0, getLength()));
		        if (item != null) {
		            setSelectedItem(item);
		        } else {
		            // keep old item selected if there is no match
		            item = box.getSelectedItem();
		            // imitate no insert (later on offs will be incremented by str.length(): selection won't move forward)
		            offs = offs-str.length();
		            // provide feedback to the user that his input has been received but can not be accepted
		            box.getToolkit().beep(); // when available use: UIManager.getLookAndFeel().provideErrorFeedback(comboBox);
		        }
		        setText(item.toString());
		        // select the completed part
		        highlightCompletedText(offs+str.length());
		    }
		    private void setText(String text) {
		        try {
		            // remove all text and insert the completed string
		            super.remove(0, getLength());
		            super.insertString(0, text, null);
		        } catch (BadLocationException e) {
		            throw new RuntimeException(e.toString());
		        }
		    }

		    private void highlightCompletedText(int start) {
		        editor.setCaretPosition(getLength());
		        editor.moveCaretPosition(start);
		    }

		    private void setSelectedItem(Object item) {
		        selecting = true;
		        model.setSelectedItem(item);
		        selecting = false;
		    }

		    private Object lookupItem(String pattern) {
		        Object selectedItem = model.getSelectedItem();
		        // only search for a different item if the currently selected does not match
		        if (selectedItem != null && startsWithIgnoreCase(selectedItem.toString(), pattern)) {
		            return selectedItem;
		        } else {
		            // iterate over all items
		            for (int i=0, n=model.getSize(); i < n; i++) {
		                Object currentItem = model.getElementAt(i);
		                // current item starts with the pattern?
		                if (currentItem != null && startsWithIgnoreCase(currentItem.toString(), pattern)) {
		                    return currentItem;
		                }
		            }
		        }
		        // no item starts with the pattern => return null
		        return null;
		    }

		    // checks if str1 starts with str2 - ignores case
		    private boolean startsWithIgnoreCase(String str1, String str2) {
		        return str1.toUpperCase().startsWith(str2.toUpperCase());
		    }
		    public void theLabel(String question) throws Exception{
		    	System.out.println("they here");
				//question = theQuestion;
		    	questionPanel = new JPanel();
				questionPanel.setLayout(null);
				questionPanel.setBackground(Color.ORANGE);
				questionPanel.setSize(1800, 1800);
				textArea.setText(question);
				submitButton.setText("SUBMIT");			
				answerr.setBounds(475, 290, 200, 40);	
				answerr.setEditable(true);
				questionPanel.add(answerr);
				questionPanel.add(textArea);
				questionPanel.add(submitButton);
		    }
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}


}

}

 */
