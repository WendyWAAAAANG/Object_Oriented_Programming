
public class ControllerGetDebt extends Controller {

	//constructor declaration.
	public ControllerGetDebt(FinanceOffice m) {
		//initialize the superclass instance variable.
		super(m);
	}
	//method declaration.
	public String getDebt(String name) {
		//change the amount of debt into a string.
		//and print out the current result.
		String strAmount;
		try {
			strAmount = Integer.toString(m.getDebt(name));
			return strAmount;
		} catch (UnknownPayerException e) {
			//which means the payer cannot be found.
			return "Payer " + name + " unknown";
		}
	}
}
