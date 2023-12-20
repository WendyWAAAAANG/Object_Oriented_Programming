
public class Employee extends Person implements Payer {

	//The Employee class does not have any instance variable.
	
	//constructor declaration.
	public Employee(String name, int debt) throws NegativeSalaryException {
		//initialize the instance variables.
		//the salary that is UIC must pay to the employee.
		//a positive salary is the same as a negative debt.
		super(name, debt);
		if(debt > 0) {
			//which means the salary given as argument is strictly less than 0.
			throw new NegativeSalaryException("An employee cannot have a negative salary!");
		}
	}
	//methods declaration.
	@Override
	public void pay(int amount) throws NegativeSalaryException {
		this.setDebt(this.getDebt() + amount);
		if(this.getDebt() > 0) {
			//If the salary given as argument is strictly less than zero
			//then the constructor must throw a NegativeSalaryException.
			this.setDebt(this.getDebt() - amount);
			throw new NegativeSalaryException("An employee cannot be overpaid by " + (amount-(-getDebt())) + " yuans!");
		} else {
			return;
		}
	}
	public static void testEmployee() {
		
		//test the method when the debt of employee is initially negative.
		try {
			//create an object.
			Employee e = new Employee("Justin", -20000);
			
			//test the methods.
			System.out.println(e.getName() == "Justin");
			System.out.println(e.getDebt() == -20000);
			e.setDebt(-30000);	//test the setDebt method.
			System.out.println(e.getDebt() == -30000);	//the amount of debt should be changed correspondingly.
			try {
				//when amount is negative, which means the employee then just receives a salary increase. 
				e.pay(-2000);	//change the amount of debt using pay method.
				System.out.println(e.getDebt() == -32000);	//the amount of debt should be changed correspondingly.
			} catch (NegativeSalaryException n) {
				//this statement should not be implemented
				//since there is no exception in above operations.
				System.out.println("WARN! The operation did not implemented successfully!");
			}
			try {
				//when amount is positive
				//and the debt of employee is not positive.
				e.pay(2000);	//change the amount of debt using pay method.
				System.out.println(e.getDebt() == -30000);	//the amount of debt should be changed correspondingly.
			} catch (NegativeSalaryException n) {
				//this statement should not be implemented
				//since there is no exception in above operations.
				//which means the operation of pay won't have exception.
				System.out.println("WARN! The operation did not implemented successfully!");
			}
			try {
				//when amount is positive
				//and the debt of employee is positive
				//which means the operation of pay will have exception.
				e.pay(200000);	//change the amount of debt using pay method.
				System.out.println(e.getDebt() == -30000);	//the amount of debt should not be changed.
			} catch (NegativeSalaryException n) {
				//this statement will be implemented
				//since there is an exception in above operations.
				System.out.println(n.getMessage().equals("An employee cannot be overpaid by 170000 yuans!"));
			}
		} catch(NegativeSalaryException n) {
			System.out.println(n.getMessage().equals("An employee cannot have a negative salary!"));
		}
		
		//test the constructor when the debt is initially positive.
		try {
			//create an object.
			Employee e = new Employee("Justin", 20000);
			
			//test the methods.
			System.out.println(e.getName() == "Justin");
			System.out.println(e.getDebt() == -20000);
			e.setDebt(-30000);	//test the setDebt method.
			System.out.println(e.getDebt() == -30000);	//the amount of debt should be changed correspondingly.
			try {
				//when amount is negative, which means the employee then just receives a salary increase. 
				e.pay(-2000);	//change the amount of debt using pay method.
				System.out.println(e.getDebt() == -32000);	//the amount of debt should be changed correspondingly.
			} catch (NegativeSalaryException n) {
				//this statement should not be implemented
				//since there is no exception in above operations.
				System.out.println("WARN! The operation did not implemented successfully!");
			}
			try {
				//when amount is positive
				//and the debt of employee is not positive.
				e.pay(2000);	//change the amount of debt using pay method.
				System.out.println(e.getDebt() == -30000);	//the amount of debt should be changed correspondingly.
			} catch (NegativeSalaryException n) {
				//this statement should not be implemented
				//since there is no exception in above operations.
				//which means the operation of pay won't have exception.
				System.out.println("WARN! The operation did not implemented successfully!");
			}
			try {
				//when amount is positive
				//and the debt of employee is positive
				//which means the operation of pay will have exception.
				e.pay(200000);	//change the amount of debt using pay method.
				System.out.println(e.getDebt() == -30000);	//the amount of debt should not be changed.
			} catch (NegativeSalaryException n) {
				//this statement will be implemented
				//since there is an exception in above operations.
				System.out.println(n.getMessage().equals("An employee cannot have a negative salary!"));
			}
		} catch(NegativeSalaryException n) {
			System.out.println(n.getMessage().equals("An employee cannot have a negative salary!"));
		}
		return;
	}

}
