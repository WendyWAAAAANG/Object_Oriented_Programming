import java.util.ArrayList;

public class FinanceOffice {

	//instance variable declaration.
	//it has an ArrayList of payers but the ArrayList is empty.
	private String name;
	private ArrayList<Payer> payers;
	//add an ArrayList of ModelListener.
	private ArrayList<ModelListener> modLis;
	//an arrayList of integers, to store the data.
	private ArrayList<Integer> history;
	
	//constructor declaration.
	public FinanceOffice(String name) {
		this.name = name;
		payers = new ArrayList<Payer>();
		modLis = new ArrayList<ModelListener>();
		//the history ArrayList must be initialized to contain only one value.
		history = new ArrayList<Integer>();
		history.add(0);
	}
	//methods declaration.
	public ArrayList<Integer> getHistory(){
		//return the history data of the debt.
		return history;
	}
	private void notifyListeners() {
		//taking nothing as argument
		//calls the update method of all the listeners of the FO.
		for(ModelListener l: modLis) {
			//tell the listener that something changed.
			l.update();
		}
		return;
	}
	public void addListener(ModelListener m) {
		//take the ModelListener as argument
		//adds it to the arrayList.
		modLis.add(m);
		return;
	}
	public void addPayer(Payer payer) {
		//takes a payer as argument.
		//adds the payer to the ArrayList of payers for the finance office.
		payers.add(payer);
		//call the totalDebt method
		//add the result to the history arrayList.
		history.add(this.totalDebt());
		//use notifyListeners method to change the data.
		notifyListeners();
		return;
	}
	public int totalDebt() {
		//returns as result the total amount of debt of all the payers of the finance office.
		//positive means that the finance office will receive more money than pay for salary.
		//declare a local variable to store the sum of debt.
		int sum = 0;
		for(Payer p: payers) {
			//using enhanced for loop to sum up the debt of all elements in ArrayList.
			sum = sum + p.getDebt();
		}
		return sum;
	}
	public int getDebt(String name) throws UnknownPayerException {
		//If the finance office does not have a payer with the correct name
		//then the pay method must throw  an UnknownPayerException.
		for(Payer p: payers) {
			//using enhance for loop to find the element whose name is same as the argument.
			if(p.getName().equals(name)) {
				//which means find a element whose name is same as argument.
				//then we return its amount of debt.
				return p.getDebt();
			} else {
				//which means the current element does not the element we want to find.
				//so continue to loop.
				continue;
			}
		}
		//after looping all elements in the ArrayList
		//we cannot find such element whose name is same as the argument.
		//so we throw an UnknownPayerException.
		throw new UnknownPayerException("Payer " + name + " unknown");
	}
	public void pay(String name, int amount) throws NegativeSalaryException, UnknownPayerException {
		//the pay method does not catch any exception, it only throws exceptions.
		for(Payer p: payers) {
			//using enhance for loop to find the element whose name is same as the argument.
			if(p.getName().equals(name)) {
				//which means this is the element whose name is same as argument.
				//then change the debt of this element.
				if(p instanceof Student) {
					//which means the
					//pay operation is valid.
					//so we implement the method.
					p.pay(-amount);
					//call the totalDebt method
					//add the result to the history arrayList.
					history.add(this.totalDebt());
					notifyListeners();
					return;
				} else if(p instanceof Employee && (p instanceof FacultyMember == false) && amount > (-p.getDebt())) {
					//since the Employee cannot have a negative salary.
					//so we throw a exception.
					throw new NegativeSalaryException("An employee cannot be overpaid " + (amount-(-p.getDebt())) + " yuans!");
				} else if(p instanceof Employee && (p instanceof FacultyMember == false) && amount <= (-p.getDebt())) {
					p.pay(amount);
					//call the totalDebt method
					//add the result to the history arrayList.
					history.add(this.totalDebt());
					notifyListeners();
					return;
				} else {
					//which means the pay operation is valid.
					//the type of p is student.
					//so we implement the method.
					p.pay(amount);
					//call the totalDebt method
					//add the result to the history arrayList.
					history.add(this.totalDebt());
					notifyListeners();
					return;
				}
			} else {
				//which means the current element does not the element we want to find.
				//so continue to loop.
				continue;
			}
		}
		throw new UnknownPayerException("Payer " + name + " unknown");
	}
	public static void testFinanceOffice() {
		//create an object.
		FinanceOffice f = new FinanceOffice("UFO");
		Payer p1;
		Payer p2;
		Payer p3 = new Student("Amber", 26150);
		try {
			//create objects.
			p1 = new Employee("Wendy", -19300);
			p2 = new FacultyMember("Justin", -26111);
			
			//test the methods.
			f.addPayer(p1);
			f.addPayer(p2);
			System.out.println(p1.getName() == "Wendy");
			System.out.println(p2.getName() == "Justin");
			System.out.println(p1.getDebt() == -19300);
			System.out.println(p2.getDebt() == -26111);
		} catch (NegativeSalaryException e) {
			System.out.println("BUG! This cannot be happened!");
		}

		//test the methods.
		//add elements into ArrayList.
		f.addPayer(p3);
		//test the methods in p1, p2, p3.
		System.out.println(p3.getName() == "Amber");
		System.out.println(p3.getDebt() == 26150);
		//test the methods in f.
		try{
			//these statement will be implement successfully
			//since the payer are in the ArrayList.
			System.out.println(f.totalDebt() == -19261);
			System.out.println(f.getDebt("Wendy") == -19300);
			System.out.println(f.getDebt("Justin") == -26111);
			//this statement will fail to implement
			//since we cannot find Ember in the ArrayList.
			//it will throw an exception.
			System.out.println(f.getDebt("Ember") == 26150);
		} catch(UnknownPayerException u) {
			System.out.println(u.getMessage().equals("Payer Ember unknown"));
		}
		//test the method through p1, which also is an employee.
		//since p1 is an Employee, so we should also test whether the salary of p1 is negative.
		try{
			//test the method when the change is valid.
			f.pay("Wendy", -19000);
			System.out.println(f.getDebt("Wendy") == -38300);
		} catch (UnknownPayerException u) {
			//this statement should not be implemented
			//since the statement in try does not throw an exception.
			System.out.println("The operation did not implemented successfully!");
		} catch (NegativeSalaryException n) {
			//this statement should not be implemented
			//since the statement in try does not throw an exception.
			System.out.println("The operation did not implemented successfully!");
		}
		try {
			//test the method when the change is invalid.
			f.pay("Wendy", 20300);
			System.out.println(f.getDebt("Wendy") == -18000);
		} catch (UnknownPayerException u) {
			//this statement should not be implemented
			//since the statement in try does not throw an exception.
			System.out.println("The operation did not implemented successfully!");
		} catch (NegativeSalaryException n) {
			//this statement will be print out since the input of amount is invalid.
			System.out.println(n.getMessage().equals("An employee cannot have a negative salary!"));
		}
		//test the methods through p2, which also is a faculty member.
		try {
			f.pay("Justin", 111);
			System.out.println(f.getDebt("Justin") == -26000);
		} catch (UnknownPayerException u) {
			//this statement should not be implemented
			//since the statement in try does not throw an exception.
			System.out.println("The operation did not implemented successfully!");
		} catch (NegativeSalaryException n) {
			//this statement should not be implemented
			//since the statement in try does not throw an exception.
			System.out.println("The operation did not implemented successfully!");
		}
		//test the methods through p3, which also is a student.
		try {
			f.pay("Amber", 150);
			System.out.println(f.getDebt("Amber") == 26300);
		} catch (UnknownPayerException u) {
			//this statement should not be implemented
			//since the statement in try does not throw an exception.
			System.out.println("The operation did not implemented successfully!");
		} catch (NegativeSalaryException n) {
			//this statement should not be implemented
			//since the statement in try does not throw an exception.
			System.out.println("The operation did not implemented successfully!");
		}
		return;
	}
}
