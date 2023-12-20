
public class ControllerPay extends Controller {

	//constructor declaration.
	public ControllerPay(FinanceOffice m) {
		//initialize the instance variable in the superclass.
		super(m);
	}
	//method declaration.
	public String pay(String name, String amount) {
		//call the pay method in the FO.
		try {
			//change the input string into an integer.
			int amountInt = Integer.parseInt(amount);
			//change the amount of money.
			//if the pay operation is implemented successfully
			//we just return a null String.
			m.pay(name, amountInt);
			return "";
		} catch (NegativeSalaryException e) {
			//which means the salary of employee is invalid.
			//so we return a statement as warning.
			try {
				return "An employee cannot be overpaid by " + (Integer.parseInt(amount)-(-m.getDebt(name))) + " yuans!";
			} catch (NumberFormatException e1) {
				//which means the input amount is invalid.
				//we should print out a error message.
				return "For input string: \"" + amount + "\"";
			} catch (UnknownPayerException e1) {
				//which means the payer of the input name does not exist.
				return "Payer " + name + " unknown";
			}
		} catch (UnknownPayerException e) {
			//which means the payer of the input name does not exist.
			return "Payer " + name + " unknown";
		} catch (NumberFormatException e) {
			//which means the input amount is invalid.
			//we should print out a error message.
			return "For input string: \"" + amount + "\"";
		}
	}

}
