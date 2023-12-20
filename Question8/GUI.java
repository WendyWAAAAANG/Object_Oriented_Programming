
public class GUI {

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				//to run that code on the event dispatch thread.
				FinanceOffice f = new FinanceOffice("UIC FO");
				ControllerSimple c = new ControllerSimple(f);
				ViewSimple v = new ViewSimple(f, c);
				return;
			}
		});
	}
}
