import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingWorker;


public class ImmaginiWorker extends SwingWorker<Integer, ImageIcon> {
	
	private FrameImmagini frame;
	private int downloaded = 0;
	
	public ImmaginiWorker(FrameImmagini frame) {
		this.frame = frame;
	}
	
	@Override
	public Integer doInBackground() throws Exception {
		System.out.println("Ciao, sono: " + Thread.currentThread().getName() + 
				" - ed eseguo doInBackground");
		int i = 1;
		while(!isCancelled() && 1 < 10) {
			Thread.sleep(1000);
			String fileName = "immagini/img" + i + ".png";
			ImageIcon img = new ImageIcon(fileName);
			downloaded += (int)(1000.0 * Math.random());
			i++;
			setProgress(i*10);
			publish(img);
		}
		return downloaded;
	}
	
	@Override
	public void process(List<ImageIcon> infoList) {
		System.out.println("Ciao, sono: " + Thread.currentThread().getName() + 
				" - ed eseguo process()");
		for(ImageIcon img : infoList) {
			if(isCancelled()) {
				break;
			}
			frame.pannelloCentrale.add(new JLabel(img));
			frame.pannelloCentrale.revalidate();
			frame.pannelloCentrale.repaint();
			frame.areaTesto.append("Nuova immagine scaricata\n");
		}
	}
	
	@Override
	public void done() {
		System.out.println("Ciao, sono: " + Thread.currentThread().getName() + 
				" - ed eseguo done()");
		frame.scarica.setEnabled(true);
		frame.cancel.setEnabled(false);
		
		if(isCancelled()) {
			frame.areaTesto.append("Download interrotto!!!\n");
		} else {
			try {
				frame.areaTesto.append("Ricerca completata!!!\n");
				frame.download.setText(get() + "");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
