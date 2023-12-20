
public abstract class Person implements Payer {

	//instance variables declaration.
	private String name;	//indicates the name of the Person.
	private int debt;	//indicates the amount of money that the person must pay to UIC.
	
	//constructor declaration.
	public Person(String name, int debt) {
		//initialize the instance variables.
		this.name = name;
		this.debt = debt;
	}
	//methods declaration.
	@Override
	public String getName() {
		//get value of name.
		return name;
	}
	@Override
	public int getDebt() {
		//get the value of debt.
		return debt;
	}
	protected void setDebt(int debt) {
		//changes the amount of debt that a person has.
		//only subclasses of the Person class can use the setDebt method.
		this.debt = debt;
		return;
	}
	@Override
	public abstract void pay(int amount);
	//to decrease or increase the amount of debt a person has.
	//since we do not know what kind of person the person is.
	public static void testPerson() {
		//since the Person class is an abstract class
		//we cannot create objects in this class
		//so we cannot test the methods in this class.
		return;
	}
}
