
public class ControllerCreate extends Controller {

	//constructor declaration,
	public ControllerCreate(FinanceOffice m) {
		//initialize the instance variables in the superclass.
		super(m);
	}
	//method declaration.
	public String create(String name, String amount, int type) {
		//using switch statement to create each type of person.
		//transform the amount from string into integer.
		try{
			int amountInt = Integer.parseInt(amount);
			switch(type) {
				case 0:
					//which means the type of payer is student.
					//we will create a object of student and add it into the arrayList.
					Student s = new Student(name, amountInt);
					m.addPayer(s);
					break;
				case 1:
					//which means the type of payer is employee.
					//we will create a object of student and add it into the arrayList.
					Employee e;
					try {
						e = new Employee(name, amountInt);
						m.addPayer(e);
					} catch (NegativeSalaryException e1) {
						//which means the salary of employee is invalid.
						return "An employee cannot have a negative salary!";
					}
					break;
				case 2:
					//which means the type of payers is faculty member.
					//we will create a object of student and add it into the arrayList.
					FacultyMember f;
					try {
						f = new FacultyMember(name, amountInt);
						m.addPayer(f);
					} catch (NegativeSalaryException e1) {
						System.out.println("An faculty cannot have a negative salary!");
					}
					break;
					//there is no need for default.
					//since the user must choose one of the number above.
			}
		} catch (NumberFormatException e) {
			//which means the input amount is invalid.
			//we should print out a error message.
			return "For input string: \"" + amount + "\"";
		}
		return "" ;
	}

}
