import java.util.InputMismatchException;
import java.util.Scanner;

//we want to create a command line interface
//for our finance office software.
public class CLI {

	//add a instance variable.
	//use this variable when need to read input.
	//and we will never close this input.
	private static Scanner input = new Scanner(System.in);
	
	//methods declaration.
	private static String readLine(String str) {
		//take a string as an argument.
		//return a string as a result.
		
		//ask the user to type some text.
		System.out.print(str);
		
		//read a whole line of text from the user of
		//the program and returns the text as result.
			String strLine = input.nextLine();
		return strLine;
	}
	private static int readPosInt(String str) {
		//create a integer to check whether the user input is valid
		//and determine whether to input again.
		//declare the n to store the integer which users input.
		int i = 0;
		int n = 0;
		//take a string as an argument.
		//return a string as a result.
		while(i == 0) {
		//ask the user to type some integer.
		System.out.print(str);
		
		// read an integer from the user of the program.
		//return the integer as result.
			try{
				//try to store the integer which input by users.
				n = input.nextInt();
				//if the user did the valid input,
				//then change the value of index to jump out of the loop.
				i = 1;
				//to read the single newline character that comes from the user
				//pressing the Enter key on the keyboard after typing the integer.
				String newLine = input.nextLine();
				if(n >= 0) {
					//change the value of n and jump out of the loop.
					i = 1;
				} else {
					//give warn to user.
					//and ask user to do the input again.
					i = 0;
					System.out.println("Positive integers only!");
				}
			} catch (InputMismatchException e) {
				//print out the warning of the exception.
				System.out.println("You must type an integer!");
				//to store the wrong input of users.
				String errorLine = input.nextLine();
			}
		}
		return n;
	}
	public static void main(String[] args) {
		//create an object.
		FinanceOffice f = new FinanceOffice("UIC FO");
		
		//just write a infinite loop to run the program.
		while(true) {
			//print out a string asking for users to select the operation.
			System.out.print("Type an action ");
			int i = readPosInt("(total: 1 add: 2 get: 3 give: 4 take: 5 quit: 6) ");
			switch(i) {
				case 1:
					//perform the particular action.
					//printing the total amount of debt.
					System.out.println("Total amount of debt: " + f.totalDebt());
					break;
				case 2:
					//perform the particular action.
					//adding a new payer to the finance office.
					System.out.print("Enter the payer type ");
					int tOfPayer = readPosInt("(student: 1 employee: 2 faculty member: 3) ");
					switch(tOfPayer) {
						//to implement different statement when the type of payers is different.
						case 1:
							String stuName = readLine("Enter the name of payer: ");
							int amountOfMoney1 = readPosInt("Enter the initial amount of money: ");
							Student s = new Student(stuName, amountOfMoney1);
							//use f to add the elements into the arrayList.
							f.addPayer(s);
							//print out the result if successful.
							System.out.println("Student \"" + stuName + "\" with " + amountOfMoney1 + " yuans of debt added");
							break;
						case 2:
							String empName = readLine("Enter the name of payer: ");
							int amountOfMoney2 = readPosInt("Enter the initial amount of money: ");
							try{
								Employee e = new Employee(empName, (-amountOfMoney2));
								//use f to add the elements into the arrayList.
								f.addPayer(e);
								//print out the result if successful.
								System.out.println("Employee \"" + empName + "\" with " + amountOfMoney2 + " yuans of salary added");
							} catch (NegativeSalaryException n) {
								System.out.println("An employee cannot have a negative salary!");
							}
							break;
						case 3:
							String facName = readLine("Enter the name of payer: ");
							int amountOfMoney3 = readPosInt("Enter the initial amount of money: ");
							try{
								FacultyMember m = new FacultyMember(facName, (-amountOfMoney3));
								//use f to add the elements into the arrayList.
								f.addPayer(m);
								//print out the result if successful.
								System.out.println("Faculty member \"" + facName + "\" with " + amountOfMoney3 + " yuans of salary added");
							} catch (NegativeSalaryException n) {
								System.out.println("BUG! This cannot be happened!");
							}
							break;
						default:
							//which means the payer cannot be found in the arrayList.
							System.out.println("Unknown type of payer!");
							break;
					}
					break;
				case 3:
					//perform the particular action.
					//listing the amount of debt for a given payer.
					String name1 = readLine("Enter the name of the payer: ");
					try{
						//try to get the amount of debt of input name.
						System.out.println(name1 + " has " + f.getDebt(name1) + " yuans of debt");
					} catch (UnknownPayerException e) {
						//print out the message to inform the unknown of the payer.
						System.out.println("Payer " + name1 + " unknown");
					}
					break;
				case 4:
					//perform the particular action.
					//paying money to a given payer.
					String name2 = readLine("Enter the name of the payer: ");
					int amount1 = readPosInt("Enter the amount of money: ");
					try{
						f.pay(name2, amount1);
					} catch (UnknownPayerException e1) {
						//print out the message to inform the unknown of the payer.
						System.out.println("Payer " + name2 + " unknown");
					} catch (NegativeSalaryException e2) {
						//this statement will never be operated
						//unless there have some bugs.
						try {
							System.out.println("An employee cannot be overpaid " + (amount1-(-f.getDebt(name2))) + " yuans!");
						} catch (UnknownPayerException e) {
							System.out.println("WARN! The method does not implemented successfully!");
						}
						//immediately terminating the program using System.exit(1).
						System.exit(1);
					}
					break;
				case 5:
					//perform the particular action.
					//taking money from a given payer.
					String name3 = readLine("Enter the name of the payer: ");
					int amount2 = readPosInt("Enter the amount of money: ");
					try {
						f.pay(name3, (-amount2));
					} catch (UnknownPayerException e1) {
						//print out the message to inform the unknown of the payer.
						System.out.println("Payer " + name3 + " unknown");
					} catch (NegativeSalaryException e2) {
						//this statement will never be operated
						//unless there have some bugs.
						try {
							System.out.println("An employee cannot be overpaid by " + (amount2+f.getDebt(name3)) + " yuans!");
						} catch (UnknownPayerException e) {
							System.out.println("BUG! This cannot be happened!");
						}
						//immediately terminating the program using System.exit(1).
						System.exit(1);
					}
					break;
				case 6:
					//perform the particular action.
					//print out the "Goodbye" statement and terminate the program.
					System.out.println("Goodbye!");
					System.exit(0);
					break;
				default:
					System.out.println("Unknown action!");
					break;
			}
		}
	}

}
