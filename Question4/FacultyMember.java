
public class FacultyMember extends Employee {

	//FacultyMember class does not have any instance variable.
	
	//constructor declaration.
	public FacultyMember(String name, int debt) throws NegativeSalaryException {
		//initialize the instance variables.
		//the salary that is UIC must pay to the faculty member.
		//a positive salary is the same as a negative debt.
		//since the faculty member can temporarily borrow extra money
		//so the debt can be positive
		//then we do not throw any NegativeSalaryException.
		super(name, debt);
	}
	//methods declaration.
	@Override
	public void pay(int amount) {
		//decreases the current salary of the faculty member
		//by the amount of money given as argument to the method.
		//a faculty member might also temporarily borrow extra money from UIC
		//that the  faculty member will need to reimburse later.
		//the salary of a faculty member might then become negative
		//so the methods do not need to throws any exception.
		this.setDebt(this.getDebt() + amount);
		return;
	}
	public static void testFacultyMember() {
		try{
			//create an object.
			FacultyMember f = new FacultyMember("Wendy", -10000);
		
			//test the methods.
			System.out.println(f.getName() == "Wendy");
			System.out.println(f.getDebt() == -10000);
			f.setDebt(-500);
			//change the amount of debt using setDebt method.
			//the debt of faculty member will be changed correspondingly.
			System.out.println(f.getDebt() == -500);
			//change the amount of debt using pay method.
			//after change, the debt of faculty member should be negative, too.
			f.pay(400);
			System.out.println(f.getDebt() == -100);
			//change the amount of debt using pay method.
			//after change, the debt of faculty member should be positive
			//without any exception, since the debt of faculty can be positive.
			f.pay(200);
			System.out.println(f.getDebt() == 100);
		} catch (NegativeSalaryException n) {
			//since the debt of faculty member can be both positive and negative.
			//so we will not throw any exceptions.
			System.out.println("BUG! This cannot be happen!");
		}
		return;
	}
}
