
public class GUI {

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				
				//to run that code on the event dispatch thread.
				FinanceOffice f = new FinanceOffice("UIC FO");
				
				//test code here.
				Student s = new Student("qin", 2000);
				f.addPayer(s);
				Employee e;
				try {
					e = new Employee("wang", -3000);
					f.addPayer(e);
				} catch (NegativeSalaryException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				FacultyMember r;
				try {
					r = new FacultyMember("justin", -1000);
					f.addPayer(r);
				} catch (NegativeSalaryException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				ControllerSimple c1 = new ControllerSimple(f);
				ViewSimple v1 = new ViewSimple(f, c1);
				ControllerGetDebt c2 = new ControllerGetDebt(f);
				ViewGetDebt v2 = new ViewGetDebt(f, c2);
				ControllerPay c3 = new ControllerPay(f);
				ViewPay v3 = new ViewPay(f, c3);
				return;
			}
		});
	}
}
