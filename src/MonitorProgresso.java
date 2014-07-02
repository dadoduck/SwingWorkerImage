import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JProgressBar;


public class MonitorProgresso implements PropertyChangeListener {
	
	private JProgressBar barraAvanzamento;
	
	public MonitorProgresso(JProgressBar barra) {
		barraAvanzamento = barra;
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("Ciao, sono: " + Thread.currentThread().getName() + 
				" - ed aggiorno la barra");
		String strPropertyName = evt.getPropertyName();
		if("progress".equals(strPropertyName)) {
			barraAvanzamento.setIndeterminate(false);
			int progress = (Integer)evt.getNewValue();
			barraAvanzamento.setValue(progress);
		}
	}
	
	

}
