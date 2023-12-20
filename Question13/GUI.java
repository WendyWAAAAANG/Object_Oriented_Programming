
public class GUI {

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				
				//to run that code on the event dispatch thread.
				FinanceOffice f = new FinanceOffice("UIC FO");
				
				ControllerSimple c1 = new ControllerSimple(f);
				ViewSimple v1 = new ViewSimple(f, c1);
				ControllerGetDebt c2 = new ControllerGetDebt(f);
				ViewGetDebt v2 = new ViewGetDebt(f, c2);
				ControllerPay c3 = new ControllerPay(f);
				ViewPay v3 = new ViewPay(f, c3);
				ControllerCreate c4 = new ControllerCreate(f);
				ViewCreate v4 = new ViewCreate(f, c4);
				ControllerHistory c5 = new ControllerHistory(f);
				ViewHistory v5 = new ViewHistory(f, c5);
				return;
			}
		});
	}
}
