import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class Outcome extends Questions implements ActionListener{
	private static JButton ok,ok2;
	private static JLabel textArea;
	private static JPanel p;
	private static Outcome yes;
	private static JFrame f;
	public static void main (String [] args){
		JOptionPane optionPane = new JOptionPane("The answer provided is incorrect!", JOptionPane.ERROR_MESSAGE);    
		JDialog dialog = optionPane.createDialog("Incorrect!");
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);
	}
	//private static theQuestionAsked q;
	
	/*
	public Outcome(String outCome){
		super("Result");
		ok2 = new JButton("OK");
		ok2.setBounds(185, 90, 80, 25);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setSize(500,150);
		setBackground(Color.black);
		textArea = new JLabel();
		textArea.setBounds(100, 0, 420, 80);
		textArea.setText("Incorect Answer, Next Team Please Try.");
		setLocationRelativeTo(null);
		setVisible(true);	
		p = new JPanel();
		p.setLayout(null);
		p.setSize(500,150);
		setBackground(Color.black);
	}*/
	public Outcome(){
	/*	super("Result");
		ok2 = new JButton("OK");
		ok2.setBounds(185, 90, 80, 25);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setSize(500,150);
		setBackground(Color.black);
		textArea = new JLabel();
		textArea.setBounds(100, 0, 420, 80);
		textArea.setText("That is correct!!! Please press OK to continue.");
		setLocationRelativeTo(null);
		setVisible(true);	
		p = new JPanel();
		p.setLayout(null);
		p.setSize(500,150);	*/
		ok2 = new JButton("OK");
		ok2.addActionListener(this);
	}
	public static void correct(){
		f = new JFrame();
		f.setTitle("Resufffflt");
		ok2.setBounds(185, 90, 80, 25);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setSize(500,150);
		f.setBackground(Color.black);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		textArea = new JLabel();
		textArea.setBounds(100, 0, 420, 80);
		textArea.setText("That is correct!!! Please press OK to continue.");	
		p = new JPanel();
		p.setLayout(null);
		p.setSize(500,150);	
		p.add(ok2);
		p.add(textArea);
		f.getContentPane().add(p);
	}
	/*public void incorrect(){
		String a = null;
		yes = new Outcome(a);
		p.add(ok2);
		p.add(textArea);
		yes.getContentPane().add(p);
	}*/
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ok2){
				f.setVisible(false);
			f.disable();
			
			}		
	}
		
}




