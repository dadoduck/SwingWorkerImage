import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class FrameImmagini extends JFrame {
	
	JTextField campoTesto;
	JLabel download;
	JButton scarica, cancel;
	JTextArea areaTesto;
	JPanel pannelloCentrale;
	JProgressBar barra;
	
	public FrameImmagini() {
		super("Swing Worker Immagini");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// creazione label, campoTesto e button
		JLabel label = new JLabel("Inserisci Testo: ");
		campoTesto = new JTextField(20);
		JButton testoButton = new JButton("Enter");
		
		// add listener e command to button
		testoButton.setActionCommand("Enter");
		MyListener listener = new MyListener(this);
		testoButton.addActionListener(listener);
		
		// creazione pannelloSuperiore ed aggiunta label campoTesto e button
		JPanel pannelloSuperiore = new JPanel();
		pannelloSuperiore.add(label);
		pannelloSuperiore.add(campoTesto);
		pannelloSuperiore.add(testoButton);
		
		JLabel img1 = new JLabel("1", JLabel.CENTER);
		JLabel img2 = new JLabel("2", JLabel.CENTER);
		JLabel img3 = new JLabel("3", JLabel.CENTER);
		JLabel img4 = new JLabel("4", JLabel.CENTER);
		JLabel img5 = new JLabel("5", JLabel.CENTER);
		JLabel img6 = new JLabel("6", JLabel.CENTER);
		JLabel img7 = new JLabel("7", JLabel.CENTER);
		JLabel img8 = new JLabel("8", JLabel.CENTER);
		JLabel img9 = new JLabel("9", JLabel.CENTER);
		pannelloCentrale = new JPanel(new GridLayout(3, 3));
		pannelloCentrale.add(img1);
		pannelloCentrale.add(img2);
		pannelloCentrale.add(img3);
		pannelloCentrale.add(img4);
		pannelloCentrale.add(img5);
		pannelloCentrale.add(img6);
		pannelloCentrale.add(img7);
		pannelloCentrale.add(img8);
		pannelloCentrale.add(img9);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
