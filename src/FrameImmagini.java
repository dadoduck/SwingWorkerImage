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
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
