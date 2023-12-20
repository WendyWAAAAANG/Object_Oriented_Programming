
public class Student extends Person implements Payer {

	//The Student class does not have any instance variable.
	
	//constructor declaration.
	public Student(String name, int debt) {
		//initialize the variables of Student.
		super(name, debt);
	}
	//methods declaration.
	@Override
	public void pay(int amount) {
		//decreases the amount of debt
		//that the student has by the amount of money given as argument to the method.
		//A student can have a negative debt.
		this.setDebt(this.getDebt() - amount);
	}
	public static void testStudent() {
		//create an object.
		Student s = new Student("Wendy", 10000);
		
		//test methods.
		System.out.println(s.getName() == "Wendy");
		System.out.println(s.getDebt() == 10000);
		s.setDebt(20000);	//change the amount of debt using setDebt method.
		System.out.println(s.getDebt() == 20000);	//the amount of debt should be changed correspondingly.
		s.pay(19999);	//change the amount of debt using pay method.
		System.out.println(s.getDebt() == 1);	//the amount of debt should be changed correspondingly.
		s.pay(2);	//change the amount of debt to make the debt be negative.
		System.out.println(s.getDebt() == -1);	//the amount of debt should be changed correspondingly.
		return;
	}
}
