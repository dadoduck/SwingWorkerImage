import javax.swing.SwingUtilities;


public class Main {
	
	public static void main(String[] args) {
		System.out.println("Ciao, sono: " + Thread.currentThread().getName() + 
				" - e chiedo allìEDT di creare la GUI");
		Runnable init = new Runnable() {
			
			@Override
			public void run() {
				new FrameImmagini();
			}
		};
		
		SwingUtilities.invokeLater(init);
	}
	
}
