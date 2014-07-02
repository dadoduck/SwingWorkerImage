import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyListener implements ActionListener {
	
	private FrameImmagini frame;
	private ImmaginiWorker worker;
	
	public MyListener(FrameImmagini frame) {
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command == "scarica") {
			scarica();
		} else if(command == "cancel") {
			cancella();
		} else {
			// Annulla
			frame.areaTesto.append("Testo: " + frame.campoTesto.getText() + "\n");
		}
	}
	
	private void scarica() {
		System.out.println("Ciao, sono: " + Thread.currentThread().getName() + 
				" - aggiorno la GUI e avvio lo SingWorker");
		
		// aggiornamento GUI tramite EDT
		frame.scarica.setEnabled(false);
		frame.cancel.setEnabled(true);
		frame.areaTesto.append("Inizio download immagini...\n");
		frame.download.setText("--");
		frame.barra.setIndeterminate(true);
		frame.pannelloCentrale.removeAll();
		frame.pannelloCentrale.validate();
		frame.pannelloCentrale.repaint();
		
		// creazione ed aggiornamento SwingWorker che eseguirà il download
		MonitorProgresso monitorProgresso = new MonitorProgresso(frame.barra);
		worker = new ImmaginiWorker(frame);
		worker.addPropertyChangeListener(monitorProgresso);
		worker.execute();
		
	}
	
	private void cancella() {
		frame.areaTesto.append("Richiesta di cancellazione...\n");
		frame.barra.setIndeterminate(false);
		frame.barra.setValue(0);
		worker.cancel(true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
